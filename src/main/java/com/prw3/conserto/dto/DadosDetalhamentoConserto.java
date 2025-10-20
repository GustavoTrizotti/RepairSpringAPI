package com.prw3.conserto.dto;

import com.prw3.conserto.model.Conserto;

public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        DadosMecanico mecanico,
        DadosVeiculo veiculo
) {
    public DadosDetalhamentoConserto(Conserto c) {
        this(
            c.getId(),
            c.getDataEntrada(),
            c.getDataSaida(),
            new DadosMecanico(c.getMecanico().getNome(), c.getMecanico().getAnosExperiencia()),
            new DadosVeiculo(c.getVeiculo().getMarca(), c.getVeiculo().getModelo(), c.getVeiculo().getAno(), c.getVeiculo().getCor())
        );
    }
}