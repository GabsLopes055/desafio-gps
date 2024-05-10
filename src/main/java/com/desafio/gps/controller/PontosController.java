package com.desafio.gps.controller;

import com.desafio.gps.DTOs.PontosRequest;
import com.desafio.gps.DTOs.PontosResponse;
import com.desafio.gps.service.PontoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pontos")
public class PontosController {

    private final PontoService service;

    PontosController(PontoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PontosResponse> salvarNovoPonto(@RequestBody @Valid PontosRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarNovoPonto(request));
    }

    @GetMapping
    public ResponseEntity<List<PontosResponse>> listarTodosPontos() {
        if (service.listarTodosPontos().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosPontos());
        }
    }

    @GetMapping(value = "proximos")
    public ResponseEntity<List<PontosResponse>> listarProximos(@RequestParam(value = "eixo_x") Long eixo_x,
                                                               @RequestParam(value = "eixo_y") Long eixo_y,
                                                               @RequestParam(value = "distancia") Long distancia) {

        if(service.listarProximos(eixo_x, eixo_y, distancia).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(service.listarProximos(eixo_x, eixo_y, distancia));
        }

    }

}
