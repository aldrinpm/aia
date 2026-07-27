package com.example.demo.dto;

import com.example.demo.validation.OddNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Request body: one or more letters to render and the (odd, positive) grid size.
 *
 * <p>Which letters are actually accepted is validated against the registered
 * renderers in the service layer, so it stays in step with the available letters.
 */
public record PrintRequest(

        @NotBlank(message = "letters must not be blank")
        String letters,

        @NotNull(message = "size is required")
        @Positive(message = "size must be a positive integer")
        @OddNumber(message = "size must be an odd integer")
        Integer size
) {
}
