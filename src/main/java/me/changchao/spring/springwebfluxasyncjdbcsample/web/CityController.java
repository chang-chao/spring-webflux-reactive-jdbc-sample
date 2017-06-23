package me.changchao.spring.springwebfluxasyncjdbcsample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.changchao.spring.springwebfluxasyncjdbcsample.domain.City;
import me.changchao.spring.springwebfluxasyncjdbcsample.service.CityService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Controller

public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping("/search")
	@ResponseBody
	public Mono<City> searchOne() {
		return this.cityService.getCity("Bath", "UK");
	}

	@GetMapping("/")
	@ResponseBody
	public Flux<City> list() {
		return this.cityService.findAll();
	}

	@GetMapping("/reactor")
	@ResponseBody
	String reactor() {

		 Flux.just("a","b","c").log()
//		Flux.from((s) -> {
//			System.out.println("subscribe " + Thread.currentThread().getName());
//			
//			s.onNext("a");
//			s.onNext("b");
//			s.onNext("c");
//			s.onComplete();
//		
//		}) // this is where subscription triggers data
			// production
			// this is influenced by subscribeOn
				.doOnNext(v -> System.out
						.println("doOnNext before publish " + v + " on " + Thread.currentThread().getName()))
				.publishOn(Schedulers.elastic())
				// the rest is influenced by publishOn
				.doOnNext(v -> System.out
						.println("doOnNext after publish " + v + " on " + Thread.currentThread().getName()))
				.subscribeOn(Schedulers.parallel()).subscribe(
						v -> System.out.println("subscribe received " + v + " on " + Thread.currentThread().getName()))

		;
		return "OK";
	}

}
