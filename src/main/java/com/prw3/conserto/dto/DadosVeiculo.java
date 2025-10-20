package com.prw3.conserto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank @Pattern(regexp = "\\d{4}", message = "Ano deve ter 4 dígitos") String ano,
        String cor
) {}