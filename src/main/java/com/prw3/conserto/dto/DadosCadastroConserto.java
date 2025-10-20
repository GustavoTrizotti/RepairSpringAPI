package com.prw3.conserto.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "dataEntrada deve estar no formato dd/mm/aaaa")
        String dataEntrada,

        @NotBlank
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "dataSaida deve estar no formato dd/mm/aaaa")
        String dataSaida,

        @NotNull @Valid
        DadosMecanico mecanico,

        @NotNull @Valid
        DadosVeiculo veiculo
) {}