package com.tka.controller;

import java.util.List;

import com.tka.entity.Person;
import com.tka.service.VoterService;

public class VoterController {
	VoterService controller = null;
	

	public List<Person> allPersons() {
		controller = new VoterService();
		List<Person> allPersons = controller.allPersons();
		return allPersons;
	}
	
	public List<Person> insertPerson() {
		controller = new VoterService();
		List<Person> insertPerson = controller.insertPerson();
		return insertPerson;
	}
	
	public List<Person> deleteCandidate(int Person_aadhar) {
		controller = new VoterService();
		List<Person> deleteCandidate = controller.deleteCandidate(Person_aadhar);
		return deleteCandidate;
	}
	
	public List<Person> updatePerson(int Person_aadhar) {
		controller = new VoterService();
		List<Person> updatePerson = controller.updatePerson(Person_aadhar);
		return updatePerson;
	}
	
	public List<Person> listByname(String name){
		controller = new VoterService();
		List<Person> listByname = controller.listByname(name);
		return listByname;
	}
	
	public List<Person> listByCity(String city){
		controller = new VoterService();
		List<Person> listByCity = controller.listByCity(city);
		return listByCity;
	}
	
	public List<Person> listByContituency(String constituency){
		controller = new VoterService();
		List<Person> listByContituency = controller.listByContituency(constituency);
		return listByContituency;
	}
	
	
	
}
