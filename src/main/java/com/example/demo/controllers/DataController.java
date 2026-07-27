package com.example.demo.controllers;

import com.example.demo.dto.LetterGridResponse;
import com.example.demo.dto.PrintRequest;
import com.example.demo.services.PrintService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private final PrintService printService;

    public DataController(PrintService printService) {
        this.printService = printService;
    }

    @PostMapping(value = "/print", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LetterGridResponse> print(@Valid @RequestBody PrintRequest request) {
        return printService.render(request);
    }
}
