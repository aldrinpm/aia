package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Template-method base for grid letters: it walks every cell of the square and
 * delegates the shape decision to {@link #isFilled(int, int, int)}, so each concrete
 * letter only needs to express its geometry.
 */
public abstract class GridLetterRenderer implements LetterRenderer {

    static final char FILLED = '*';
    static final char EMPTY = ' ';

    @Override
    public List<String> render(int size) {
        List<String> grid = new ArrayList<>(size);
        for (int row = 0; row < size; row++) {
            StringBuilder line = new StringBuilder(size);
            for (int col = 0; col < size; col++) {
                line.append(isFilled(row, col, size) ? FILLED : EMPTY);
            }
            grid.add(line.toString());
        }
        return grid;
    }

    /** @return whether the cell at ({@code row}, {@code col}) is part of the letter. */
    protected abstract boolean isFilled(int row, int col, int size);
}
