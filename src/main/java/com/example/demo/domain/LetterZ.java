package com.example.demo.domain;

import org.springframework.stereotype.Component;

/** Draws 'Z' as the top and bottom bars joined by the anti-diagonal. */
@Component
public class LetterZ extends GridLetterRenderer {

    @Override
    public char symbol() {
        return 'Z';
    }

    @Override
    protected boolean isFilled(int row, int col, int size) {
        return row == 0 || row == size - 1 || row + col == size - 1;
    }
}
