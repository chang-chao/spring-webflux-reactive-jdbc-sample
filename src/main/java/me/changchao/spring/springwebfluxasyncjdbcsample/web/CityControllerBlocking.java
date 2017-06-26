package me.changchao.spring.springwebfluxasyncjdbcsample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.changchao.spring.springwebfluxasyncjdbcsample.domain.City;
import me.changchao.spring.springwebfluxasyncjdbcsample.service.CityRepository;

@Controller
public class CityControllerBlocking {
	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/search")
	@ResponseBody
	public City searchOne() {
		return cityRepository.findByNameAndCountryAllIgnoringCase("Bath", "UK");
	}

	@GetMapping("/")
	@ResponseBody
	public Iterable<City> list() {
		return cityRepository.findAll();
	}

	@GetMapping("/add")
	@ResponseBody
	@Transactional
	public Long add() {
		String name = "city:" + Math.random();
		String country = "country:" + Math.random();

		City city = new City(name, country);
		city.setState("state");
		city.setMap("map");
		City savedCity = cityRepository.save(city);

		return savedCity.getId();
	}
}
