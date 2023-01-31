package com.cricket.team.utils;

import com.cricket.team.models.Team;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonReader {


    public Team readTeam(String filename) {
        Team obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //JSON file to Java object
            obj = mapper.readValue(new File("./src/test/resources/"+filename+".json"), Team.class);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return obj;
    }

}
