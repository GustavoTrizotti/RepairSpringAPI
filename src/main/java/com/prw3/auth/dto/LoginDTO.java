package com.prw3.auth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String login, @NotBlank String password) {
}
