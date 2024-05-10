package com.desafio.gps.DTOs;

import java.util.UUID;

public record PontosResponse(Long idPonto, String nome_ponto, Long cordenada_x, Long cordenada_y) {
}
