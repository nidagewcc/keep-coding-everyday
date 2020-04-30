package com.interview.datacollect.controller;

import com.interview.datacollect.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DataCollectController {

    @Autowired
    private CollectService collectService;

    @GetMapping("/refresh")
    public Map refresh() {
        return collectService.getCollectData();
    }
}
