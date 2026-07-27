package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/** Verifies each letter's geometry against the README examples. */
class LetterRendererTest {

    @Test
    void x_size3() {
        assertThat(new LetterX().render(3)).containsExactly(
                "* *",
                " * ",
                "* *");
    }

    @Test
    void x_size7() {
        assertThat(new LetterX().render(7)).containsExactly(
                "*     *",
                " *   * ",
                "  * *  ",
                "   *   ",
                "  * *  ",
                " *   * ",
                "*     *");
    }

    @Test
    void y_size3() {
        assertThat(new LetterY().render(3)).containsExactly(
                "* *",
                " * ",
                " * ");
    }

    @Test
    void z_size3() {
        assertThat(new LetterZ().render(3)).containsExactly(
                "***",
                " * ",
                "***");
    }

    @Test
    void z_size5() {
        assertThat(new LetterZ().render(5)).containsExactly(
                "*****",
                "   * ",
                "  *  ",
                " *   ",
                "*****");
    }

    @Test
    void everyRowIsSquare() {
        List<String> grid = new LetterY().render(7);
        assertThat(grid).hasSize(7).allSatisfy(row -> assertThat(row).hasSize(7));
    }
}
