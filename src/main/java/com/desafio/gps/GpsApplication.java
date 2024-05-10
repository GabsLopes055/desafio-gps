package com.desafio.gps;

import com.desafio.gps.entity.PontosDeInteresse;
import com.desafio.gps.repository.PontosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GpsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GpsApplication.class, args);
	}

	@Autowired
	private PontosRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new PontosDeInteresse("Lanchonete", 27L, 12L));
		repository.save(new PontosDeInteresse("Posto", 31L, 18L));
		repository.save(new PontosDeInteresse("Joalheria", 15L, 12L));
		repository.save(new PontosDeInteresse("Floricultura", 19L, 21L));
		repository.save(new PontosDeInteresse("Pub", 12L, 8L));
		repository.save(new PontosDeInteresse("Supermercado", 23L, 6L));
		repository.save(new PontosDeInteresse("Churrascaria", 28L, 2L));
	}
}
