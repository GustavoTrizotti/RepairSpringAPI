package com.prw3.conserto.model;

import com.prw3.conserto.dto.DadosAtualizacaoConserto;
import com.prw3.conserto.dto.DadosCadastroConserto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(
                dados.mecanico().nome(),
                dados.mecanico().anosExperiencia()
        );
        this.veiculo  = new Veiculo(
                dados.veiculo().marca(),
                dados.veiculo().modelo(),
                dados.veiculo().ano(),
                dados.veiculo().cor()
        );
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }
        if (dados.mecanico() != null) {
            this.mecanico.atualizarInformacoes(dados.mecanico());
        }
    }

    public void excluir() { this.ativo = false; }
}
