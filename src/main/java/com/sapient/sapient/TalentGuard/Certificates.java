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
	public TalentGuards talentguard;
	@Column(name="date")
	private LocalDate certDate;
	@Column(name="cert_name")
	public String name;

	public Certificates() {};
	
	public Certificates(int certId, TalentGuards talentguard) {
		this.certId = certId;
		this.talentguard = talentguard;
	}
	
	public Certificates(LocalDate date, String name) {
		this.certDate = date;
		this.name = name;
	}
	
	public Certificates(int certId, LocalDate date, String name, TalentGuards talentguard) {
		this.certId = certId;
		this.certDate = date;
		this.name = name;
		this.talentguard = talentguard;
	}
	
	public Certificates(TalentGuards talentguard, LocalDate date, String name) {
		this.talentguard = talentguard;
		this.certDate = date;
		this.name = name;
	}
	
	@Column(name="cert_id")
	public int getCertId() {
		return certId;
	}
	@Column(name="cert_id")
	public void setCertId(int certId) {
		this.certId = certId;
	}

	public TalentGuards getTalentguards() {
		return talentguard;
	}

	public void setTalentguards(TalentGuards talentguards) {
		this.talentguard = talentguards;
	}
	@Column(name="date")
	public LocalDate getCertDate() {
		return certDate;
	}
	@Column(name="date")
	public void setCertDate(LocalDate certDate) {
		this.certDate = certDate;
	}
	@Column(name="cert_name")
	public String getName() {
		return name;
	}
	@Column(name="cert_name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Certificates [certId=" + certId + ", talentguards=" + talentguard + ", certDate=" + certDate
				+ ", name=" + name + "]";
	}
	
}
