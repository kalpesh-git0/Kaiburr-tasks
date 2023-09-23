package com.kalpesh.kaiburrclient.dao;

import com.kalpesh.kaiburrclient.model.ServerObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectDao extends MongoRepository<ServerObject, Integer> {

    @Query("{'name':{'$regex':'?0'}}")
    List<ServerObject> findByName(String serverName);
}
