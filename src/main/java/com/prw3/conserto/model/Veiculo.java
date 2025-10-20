package com.prw3.conserto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Column(name = "veiculo_marca")
    private String marca;

    @Column(name = "veiculo_modelo")
    private String modelo;

    @Column(name = "veiculo_ano")
    private String ano;

    @Column(name = "veiculo_cor")
    private String cor;
}