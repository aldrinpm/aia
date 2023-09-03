package com.example.demo.services;

import com.example.demo.dao.Letter;
import com.example.demo.dto.PrintRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrintService {

    public List<Map<String, List<String>>> printGrid(PrintRequest request) {
        String letters = ((String) request.getLetters()).toUpperCase();
        int dim = request.getDimension();

        List<Map<String, List<String>>> result = new ArrayList<>();

        if (dim % 2 == 0) {
            Map<String, List<String>> errorMessage = new HashMap<>();
            errorMessage.put("Error", new ArrayList<>(List.of("Message", "The dimension must be an odd integer.")));
            result.add(errorMessage);

            return result;
        }

        for (char letter : letters.toCharArray()) {
            Letter letterObj = new Letter(letter);
            List<String> letterGrid = letterObj.printGrid(dim);

            Map<String, List<String>> letterMap = new HashMap<>();
            letterMap.put("letterGrid", letterGrid);

            result.add(letterMap);
        }


        return result;
    }
}
