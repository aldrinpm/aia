package com.example.demo.dto;

import java.util.List;

/** One rendered letter, serialized as {@code {"letterGrid": ["...", ...]}}. */
public record LetterGridResponse(List<String> letterGrid) {
}
