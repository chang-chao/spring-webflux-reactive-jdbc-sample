package me.changchao.spring.springwebfluxasyncjdbcsample.service;

import java.io.Serializable;

public class CitySearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public CitySearchCriteria() {
	}

	public CitySearchCriteria(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}