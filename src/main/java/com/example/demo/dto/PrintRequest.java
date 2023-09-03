package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PrintRequest {

    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[XYZ]+$", message = "Only X, Y, and Z characters are allowed")
    private String letters;

    @NotNull
    @Positive
    @Size(min = 3, max = 7)
    private int dimension;
}
