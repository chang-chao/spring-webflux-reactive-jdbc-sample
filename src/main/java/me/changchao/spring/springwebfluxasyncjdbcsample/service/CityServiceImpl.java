package me.changchao.spring.springwebfluxasyncjdbcsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import me.changchao.spring.springwebfluxasyncjdbcsample.domain.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Component("cityService")
class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;

	@Override
	public Mono<City> getCity(String name, String country) {
		Mono<City> city = Mono
				.fromCallable(() -> this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country))
				.publishOn(jdbcScheduler);
		return city;
	}

	@Override
	public Flux<City> findAll() {
		Flux<City> defer = Flux.defer(() -> Flux.fromIterable(this.cityRepository.findAll()));
		return defer.subscribeOn(jdbcScheduler);
	}

}