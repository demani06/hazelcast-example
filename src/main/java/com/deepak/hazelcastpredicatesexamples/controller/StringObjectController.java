package com.deepak.hazelcastpredicatesexamples.controller;

import com.deepak.hazelcastpredicatesexamples.service.CommonBackingService;
import com.hazelcast.com.eclipsesource.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StringObjectController {

    @Autowired
    private CommonBackingService commonBackingService;

    @GetMapping("/getStr")
    public Collection<String> getStringObjects(){
        return commonBackingService.getStringObjectToMap();
    }

    @GetMapping("/getJson")
    public Collection<JsonObject> getJsonObjects(){
        return commonBackingService.getJsonObjectsFromMap();
    }

    @GetMapping("/putStr")
    public String addStringObjects(){
        return commonBackingService.addStringObjectToMap();
    }

    @GetMapping("/putJson")
    public String addJsonObjectToMap(){
        return commonBackingService.addJsonObjectToMap();
    }

}
