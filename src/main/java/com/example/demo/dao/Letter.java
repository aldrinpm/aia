package com.example.demo.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Data
public class Letter {
    private char character;

    @Autowired
    public Letter(@Value("${letter.character}") char character) {
        this.character = character;
    }

    public List<String> printGrid(int size) {
        List<String> grid = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < size; j++) {
                switch (character) {
                    case 'X' -> {
                        if (i == j || Math.abs(i - j) == size - 1) {
                            row.append("*");
                        } else {
                            row.append(" ");
                        }
                    }

                    case 'Y' -> {
                        if (i == 0 || i == size - 1) {
                            if (j % (size - 1) == 0) {
                                if (i == 0) {
                                    row.append("*");
                                } else if (j > 0) {
                                    row.append("* ");
                                }
                            } else {
                                row.append(" ");
                            }
                        } else {
                            if (j == size / 2) {
                                row.append("*");
                            } else {
                                row.append(" ");
                            }
                        }
                    }

                    case 'Z' -> {
                        if (i == 0 || i == size - 1 || j == size / 2) {
                            row.append("*");
                        } else {
                            row.append(" ");
                        }
                    }

                    default -> {
                        // Default case if none of the cases match
                    }
                }
            }

            grid.add(row.toString());
        }

        return grid;
    }
}
