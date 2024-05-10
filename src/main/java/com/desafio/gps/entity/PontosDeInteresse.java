package com.desafio.gps.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table(name = "tbl_pontos_de_interesse")
public class PontosDeInteresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPonto;

    private String nome_ponto;


    private Long cordenada_x;

    private Long cordenada_y;

    public PontosDeInteresse() {
    }

    public PontosDeInteresse(String nome_ponto, Long cordenada_x, Long cordenada_y) {
        this.nome_ponto = nome_ponto;
        this.cordenada_x = cordenada_x;
        this.cordenada_y = cordenada_y;
    }

    public String getNome_ponto() {
        return nome_ponto;
    }

    public void setNome_ponto(String nome_ponto) {
        this.nome_ponto = nome_ponto;
    }

    public Long getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Long idPonto) {
        this.idPonto = idPonto;
    }

    public Long getCordenada_x() {
        return cordenada_x;
    }

    public void setCordenada_x(Long cordenada_x) {
        this.cordenada_x = cordenada_x;
    }

    public Long getCordenada_y() {
        return cordenada_y;
    }

    public void setCordenada_y(Long cordenada_y) {
        this.cordenada_y = cordenada_y;
    }
}
