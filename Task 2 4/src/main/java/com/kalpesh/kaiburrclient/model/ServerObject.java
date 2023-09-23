package com.kalpesh.kaiburrclient.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "serverobjects")
@Data
public class ServerObject {

    @Id
    private Integer id;

    private String name;

    private String language;

    private String framework;

}
