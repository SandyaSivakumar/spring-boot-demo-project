package com.cisco.demoproject.softwares.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cisco.demoproject.softwares.service.SoftwareService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.cisco.demoproject.softwares.pojo.Softwares;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyController {
    @Autowired
    private SoftwareService softwareService;

    @GetMapping(value = "/software/{softwareName}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<Softwares> getSoftwareName(@PathVariable("softwareName") String softwareName){
        return softwareService.findByName(softwareName);
    }

    @GetMapping(value = "/software",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Softwares> getSoftware(){
        return softwareService.find();
    }

    @GetMapping(value = "/softwares/{softwareId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Softwares getObject(@PathVariable("softwareId") String softwareId){
        return softwareService.findObject(softwareId);
    }

    @PostMapping(value = "/software/{softwareId}")
    public Softwares modifySoftwareById(@PathVariable("softwareId") String softwareId, @Valid @RequestBody Softwares softwares){
        return softwareService.updateViews(softwareId,softwares);
    }
}
