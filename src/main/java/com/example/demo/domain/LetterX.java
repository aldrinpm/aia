package com.example.demo.domain;

import org.springframework.stereotype.Component;

/** Draws 'X' as its two diagonals crossing in the centre. */
@Component
public class LetterX extends GridLetterRenderer {

    @Override
    public char symbol() {
        return 'X';
    }

    @Override
    protected boolean isFilled(int row, int col, int size) {
        return row == col || row + col == size - 1;
    }
}
