package com.example.mdb_spring_boot.api.dto;

import jakarta.validation.constraints.NotEmpty;

public record BookDto(@NotEmpty(message = "Title must be informed!") String title,
                      @NotEmpty(message = "Author Name must be informed!") String authorName) {
}
