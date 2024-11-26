package com.tka.service;

import java.util.ArrayList;

import java.util.List;


import com.tka.dao.VoterDao;
import com.tka.entity.Person;

public class VoterService {
	VoterDao  nn = null;

	public List<Person> allPersons() {
		nn = new VoterDao();
		List<Person> allPersons = nn.allPersons();
		return allPersons;
	}
	
	public List<Person> listByname(String name){
		nn = new VoterDao();
		List<Person> allPersons = nn.allPersons();
		List<Person> listByname = new ArrayList<>();
		for(Person person : allPersons) {
			if(name.equalsIgnoreCase(person.getName())) {
				listByname.add(person);
			}
		}
		return listByname;
	}
	
	public List<Person> listByCity(String city){
		nn = new VoterDao();
		List<Person> allPersons = nn.allPersons();
		List<Person> listByCity = new ArrayList<>();
		for(Person person: allPersons) {
			if(person.getAddress().getCityName().equalsIgnoreCase(city)) {
				listByCity.add(person);
			}
		}
		return listByCity;
	}
	
	public List<Person> listByContituency(String constituency){
		nn = new VoterDao();
		List<Person> allPersons = nn.allPersons();
		List<Person> listByContituency = new ArrayList<>();
		for(Person person: allPersons) {
			if(person.getVoterId().getConstituency().equalsIgnoreCase(constituency)) {
				listByContituency.add(person);
			}
		}
		return listByContituency;
	}
 	
	public List<Person> insertPerson() {
		nn = new VoterDao();
		List<Person> insertPerson = nn.insertPerson();
		return insertPerson;
	}
	
	public List<Person> deleteCandidate(int Person_aadhar) {
		nn = new VoterDao();
		List<Person> deleteCandidate = nn.deleteCandidate(Person_aadhar);
		return deleteCandidate;
	}
	
	public List<Person> updatePerson(int Person_aadhar) {
		nn = new VoterDao();
		List<Person> updatePerson = nn.updatePerson(Person_aadhar);
		return updatePerson;
	}
	

}
