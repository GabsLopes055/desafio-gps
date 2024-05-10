package com.desafio.gps.DTOs;

public record PontosRequest(
        String nome_ponto,
        Long cordenada_x,
        Long cordenada_y) {
}
