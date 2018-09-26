package me.changchao.spring.springwebfluxasyncjdbcsample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.io.Serializable;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "city_generator", sequenceName = "city_sequence", initialValue = 23)
	@GeneratedValue(generator = "city_generator")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String country;

	protected City() {
	}

	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public String getCountry() {
		return this.country;
	}

	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return getName() + "," + getCountry();
	}
}