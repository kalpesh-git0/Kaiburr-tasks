package com.kalpesh.kaiburrclient.controller;

import com.kalpesh.kaiburrclient.model.ServerObject;
import com.kalpesh.kaiburrclient.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/objects")
@CrossOrigin
public class ObjectController {

    @Autowired
    private ObjectService objectService;

    @GetMapping("get")
    public ResponseEntity<List<ServerObject>> getAllServers(@RequestParam(required = false) Optional<Integer> id){
        if(id.isEmpty()){
            return new ResponseEntity<List<ServerObject>>(objectService.allServers(), HttpStatus.OK);
        }
        List<ServerObject> server = objectService.getServer(id.get()).stream().toList();
        if(server.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ServerObject>>(server, HttpStatus.OK);
    }

    @GetMapping("/{servername}")
    public ResponseEntity<List<ServerObject>> getServers(@PathVariable String servername){
        List<ServerObject> matchedServers = objectService.getServerByName(servername);
        if(matchedServers.isEmpty()){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ServerObject>>(matchedServers, HttpStatus.OK);
    }

    @PutMapping("add")
    public ResponseEntity<String> putServer(@RequestBody ServerObject serverObject){
        return new ResponseEntity<String>(objectService.addObject(serverObject), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteServer(@PathVariable Integer id){
        return new ResponseEntity<String>(objectService.deleteObject(id), HttpStatus.OK);
    }


}
