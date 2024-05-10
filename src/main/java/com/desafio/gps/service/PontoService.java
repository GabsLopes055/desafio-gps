package com.desafio.gps.service;

import com.desafio.gps.DTOs.PontosRequest;
import com.desafio.gps.DTOs.PontosResponse;
import com.desafio.gps.entity.PontosDeInteresse;
import com.desafio.gps.repository.PontosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PontoService {

    private final PontosRepository repository;

    PontoService(PontosRepository repository) {
        this.repository = repository;
    }

    public PontosResponse salvarNovoPonto(PontosRequest request) {

        PontosDeInteresse pontosDeInteresse = new PontosDeInteresse(request.nome_ponto(), request.cordenada_x(), request.cordenada_y());

        PontosDeInteresse pontos = repository.save(pontosDeInteresse);

        return new PontosResponse(pontos.getIdPonto(), pontos.getNome_ponto(), pontos.getCordenada_x(), pontos.getCordenada_y());

    }


    public List<PontosResponse> listarTodosPontos() {

        List<PontosDeInteresse> listaPontos = repository.findAll();

        List<PontosResponse> listaResponse = new ArrayList<>();

        for (PontosDeInteresse list : listaPontos) {

            PontosResponse response = new PontosResponse(list.getIdPonto(), list.getNome_ponto(), list.getCordenada_x(), list.getCordenada_y());

            listaResponse.add(response);
        }

        return listaResponse;
    }

    public List<PontosResponse> listarProximos(Long eixoX, Long eixoY, Long distancia) {

        Long eixoX_min = eixoX - distancia;
        Long eixoX_max = eixoX + distancia;
        Long eixoY_min = eixoY - distancia;
        Long eixoY_max = eixoY + distancia;

        List<PontosDeInteresse> pontosProximos = repository.procurarProximos(eixoX_min, eixoX_max, eixoY_min, eixoY_max);

        List<PontosResponse> listaResponse = new ArrayList<>();

        for (PontosDeInteresse list : pontosProximos) {

            if (calcularDistanciaEntrePontos(eixoX, eixoY, list.getCordenada_x(), list.getCordenada_y()) <= distancia) {

                PontosResponse response = new PontosResponse(list.getIdPonto(), list.getNome_ponto(), list.getCordenada_x(), list.getCordenada_y());

                listaResponse.add(response);
            }
        }

        return listaResponse;

    }

    private Double calcularDistanciaEntrePontos(Long eixoX1, Long eixoY1, Long eixoX2, Long eixoY2) {
        Double retorno = Math.sqrt(Math.pow(eixoX2 - eixoX1, 2) + Math.pow(eixoY2 - eixoY1, 2));
        System.out.println(retorno);
        return retorno;
    }
}
