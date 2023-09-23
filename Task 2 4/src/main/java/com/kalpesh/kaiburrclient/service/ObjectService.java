package com.kalpesh.kaiburrclient.service;

import com.kalpesh.kaiburrclient.dao.ObjectDao;
import com.kalpesh.kaiburrclient.model.ServerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectService {

    @Autowired
    private ObjectDao objectDao;

    public List<ServerObject> allServers() {
        return objectDao.findAll();
    }

    public String addObject(ServerObject serverObject) {
        objectDao.save(serverObject);
        return "Success!";
    }

    public String deleteObject(Integer serverId) {
        objectDao.deleteById(serverId);
        return "Success!";
    }

    public Optional<ServerObject> getServer(Integer serverId) {
        return objectDao.findById(serverId);
    }

    public List<ServerObject> getServerByName(String serverName) {
        return objectDao.findByName(serverName);
    }
}
