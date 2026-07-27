package com.example.demo.exception;

import java.util.Collection;
import java.util.stream.Collectors;

/** Thrown when the request asks for a letter the API has no renderer for. */
public class UnsupportedLetterException extends RuntimeException {

    public UnsupportedLetterException(char letter, Collection<Character> supported) {
        super("Unsupported letter '" + letter + "'. Supported letters: "
                + supported.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
