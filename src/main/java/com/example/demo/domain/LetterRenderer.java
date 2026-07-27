package com.example.demo.domain;

import java.util.List;

/**
 * Renders a single letter as a square grid of '*' (filled) and ' ' (empty) cells.
 *
 * <p>Adding a new letter to the API is done by adding a new implementation of this
 * interface as a Spring {@code @Component}; {@link LetterRendererRegistry} discovers
 * it automatically and no existing code needs to change (open/closed principle).
 */
public interface LetterRenderer {

    /** The upper-case character this renderer draws (e.g. {@code 'X'}). */
    char symbol();

    /**
     * Renders the letter into {@code size} rows, each {@code size} characters wide.
     *
     * @param size the (odd, positive) grid dimension
     * @return one string per row, top to bottom
     */
    List<String> render(int size);
}
