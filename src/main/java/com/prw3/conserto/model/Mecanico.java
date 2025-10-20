package com.prw3.conserto.model;

import com.prw3.conserto.dto.DadosAtualizacaoMecanico;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @Column(name = "mecanico_nome")
    private String nome;

    @Column(name = "mecanico_anos_experiencia")
    private Integer anosExperiencia;

    public void atualizarInformacoes(DadosAtualizacaoMecanico dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.anosExperiencia() != null) this.anosExperiencia = dados.anosExperiencia();
    }
}