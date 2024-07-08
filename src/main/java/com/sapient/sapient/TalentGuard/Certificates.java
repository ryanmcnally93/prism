package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//BARE IN MIND
//If a 'talentguard' instance does not exist within the 
//database with this 'talentguard_id', this will throw an error
//Ensure you fill the talentguard table before filling this one

@Entity
public class Certificates {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cert_id")
	private int certId;
	
	@ManyToOne
	@JoinColumn(name="talentguard_id")
	public TalentGuards talentguards;
	@Column(name="date")
	private LocalDate certDate;
	public String name;

	public Certificates(String name, LocalDate date) {
		this.name = name;
		this.certDate = date;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getCertDate() {
		return certDate;
	}

	public void setCertDate(LocalDate certDate) {
		this.certDate = certDate;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
