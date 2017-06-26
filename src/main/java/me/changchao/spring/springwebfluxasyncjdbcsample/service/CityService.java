package me.changchao.spring.springwebfluxasyncjdbcsample.service;

import me.changchao.spring.springwebfluxasyncjdbcsample.domain.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityService {
	Mono<City> getCity(String name, String country);

	Flux<City> findAll();

	Mono<City> add(String name, String country);
}
