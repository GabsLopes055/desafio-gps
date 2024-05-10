package com.desafio.gps.repository;

import com.desafio.gps.entity.PontosDeInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PontosRepository extends JpaRepository<PontosDeInteresse, Long> {

    @Query(value = "SELECT * FROM tbl_pontos_de_interesse WHERE cordenada_x >= :eixoXMin AND cordenada_x <= :eixoXMax AND cordenada_y >= :eixoYMin AND cordenada_y <= :eixoYMax", nativeQuery = true)
    List<PontosDeInteresse> procurarProximos(
            @Param("eixoXMin")
            Long eixoXMin,
            @Param("eixoXMax")
            Long eixoXMax,
            @Param("eixoYMin")
            Long eixoYMin,
            @Param("eixoYMax")
            Long eixoYMax);

}
