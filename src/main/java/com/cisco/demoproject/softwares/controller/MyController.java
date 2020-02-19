package com.cisco.demoproject.softwares.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cisco.demoproject.softwares.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.cisco.demoproject.softwares.pojo.Softwares;

@RestController
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
}
