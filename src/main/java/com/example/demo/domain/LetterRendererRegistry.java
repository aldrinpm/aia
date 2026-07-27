package com.example.demo.domain;

import com.example.demo.exception.UnsupportedLetterException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Central lookup of the letters the API can render. Spring injects every
 * {@link LetterRenderer} bean on the classpath, so registering a new letter is
 * just a matter of adding a new {@code @Component} — this class needs no changes.
 */
@Component
public class LetterRendererRegistry {

    private final Map<Character, LetterRenderer> renderers;

    public LetterRendererRegistry(List<LetterRenderer> discovered) {
        this.renderers = discovered.stream().collect(Collectors.toMap(
                LetterRenderer::symbol,
                Function.identity(),
                (a, b) -> {
                    throw new IllegalStateException("Duplicate renderer for letter '" + a.symbol() + "'");
                },
                TreeMap::new));
    }

    /**
     * @param letter an upper-case letter
     * @return the renderer for {@code letter}
     * @throws UnsupportedLetterException if no renderer is registered for it
     */
    public LetterRenderer get(char letter) {
        LetterRenderer renderer = renderers.get(letter);
        if (renderer == null) {
            throw new UnsupportedLetterException(letter, renderers.keySet());
        }
        return renderer;
    }
}
