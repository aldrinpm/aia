package com.example.demo.domain;

import org.springframework.stereotype.Component;

/**
 * Draws 'Y': two arms fall from the top corners and meet in the middle column,
 * then a single stem drops straight down to the bottom.
 */
@Component
public class LetterY extends GridLetterRenderer {

    @Override
    public char symbol() {
        return 'Y';
    }

    @Override
    protected boolean isFilled(int row, int col, int size) {
        int middle = size / 2;
        if (row <= middle) {
            return col == row || col == size - 1 - row;
        }
        return col == middle;
    }
}
