package com.example.demo.controllers;

import com.example.demo.dto.PrintRequest;
import com.example.demo.services.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    PrintService printService;

    @GetMapping("/print")
    public List<Map<String, List<String>>> print(@RequestBody PrintRequest request) {
        return printService.printGrid(request);
    }
}