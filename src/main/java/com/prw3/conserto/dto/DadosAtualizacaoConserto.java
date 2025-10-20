package com.prw3.conserto.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull Long id,
        String dataSaida,
        DadosAtualizacaoMecanico mecanico
) {}
