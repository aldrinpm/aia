package com.example.demo.services;

import com.example.demo.domain.LetterRendererRegistry;
import com.example.demo.dto.LetterGridResponse;
import com.example.demo.dto.PrintRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrintService {

    private final LetterRendererRegistry registry;

    public PrintService(LetterRendererRegistry registry) {
        this.registry = registry;
    }

    /**
     * Renders every letter in the request, preserving input order.
     *
     * @throws com.example.demo.exception.UnsupportedLetterException
     *         if the request contains a letter with no renderer
     */
    public List<LetterGridResponse> render(PrintRequest request) {
        String letters = request.letters().toUpperCase();
        int size = request.size();

        List<LetterGridResponse> result = new ArrayList<>(letters.length());
        for (char letter : letters.toCharArray()) {
            result.add(new LetterGridResponse(registry.get(letter).render(size)));
        }
        return result;
    }
}
