package me.changchao.spring.springwebfluxasyncjdbcsample.service;

import org.springframework.data.repository.CrudRepository;

import me.changchao.spring.springwebfluxasyncjdbcsample.domain.City;

public interface CityRepository extends CrudRepository<City, Long> {
	City findByNameAndCountryAllIgnoringCase(String name, String country);
}
