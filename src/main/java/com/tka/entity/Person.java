package com.tka.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	private int aadhar_no;
	private String name;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(unique = true)
	private VoterID voterId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person(int aadhar_no, String name, VoterID voterId, Address address) {
		super();
		this.aadhar_no = aadhar_no;
		this.name = name;
		this.voterId = voterId;
		this.address = address;
	}

	public Person() {
		super();
	}

	public int getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(int aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VoterID getVoterId() {
		return voterId;
	}

	public void setVoterId(VoterID voterId) {
		this.voterId = voterId;
	}

	@Override
	public String toString() {
		return "Person{" + "aadhar_no=" + aadhar_no + ", name='" + name + '\'' + ", voterId=" + voterId + '}';
	}

}
