package com.tka.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VoterID {
	
	@Id
	private int vid;
	@Column(unique = true)
	private String voter_id;
	private String constituency;
	
	public VoterID() {
		super();
	}

	public VoterID(int vid, String voter_id, String constituency) {
		super();
		this.vid = vid;
		this.voter_id = voter_id;
		this.constituency = constituency;
	}

	public int getVid() {
		return vid;
	}

	@Override
	public String toString() {
		return "VoterID [vid=" + vid + ", voter_id=" + voter_id + ", constituency=" + constituency + "]";
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(String voter_id) {
		this.voter_id = voter_id;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	
	

}
