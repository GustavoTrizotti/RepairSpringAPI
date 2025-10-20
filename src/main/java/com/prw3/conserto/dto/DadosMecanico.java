package com.prw3.conserto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosMecanico(
        @NotBlank String nome,
        @NotNull Integer anosExperiencia
) {}