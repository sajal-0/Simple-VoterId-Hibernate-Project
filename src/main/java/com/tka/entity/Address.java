package com.tka.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


@Entity
public class Address {
	
	@Id
	private int  pincode;
	private String cityName;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Person> person;

	

	
	
	public List<Person> getPerson() {
		return person;
	}
	public void setPerson(List<Person> person) {
		this.person = person;
	}
	
	public Address(int pincode, String cityName, List<Person> person) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
		this.person = person;
	}
	public Address() {
		super();
	}
	public Address(int pincode, String cityName) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", cityName=" + cityName + ", person=" + person + "]";
	}
	
	

}
