package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.collection.spi.PersistentBag;


@Entity
@Table(name="talentguards")
public class TalentGuards {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="talentguard_id")
	private int talentguardId;
	@Column(name="employee_id")
	private int employeeId;
	@OneToMany(mappedBy = "talentguard", cascade = CascadeType.ALL, orphanRemoval = true)
	private PersistentBag<Certificates> certs;
	@OneToMany(mappedBy = "talentguard", cascade = CascadeType.ALL, orphanRemoval = true)
	private PersistentBag<Experiences> exps;

	public TalentGuards() {};
	
	public TalentGuards(int talentguardId, int employeeId) {
		super();
		this.talentguardId = talentguardId;
		this.employeeId = employeeId;
	}
	
	public TalentGuards(int talentguardId, int employeeId, PersistentBag<Certificates> certs, PersistentBag<Experiences> exps) {
		super();
		this.talentguardId = talentguardId;
		this.employeeId = employeeId;
		this.certs = certs;
		this.exps = exps;
	}
	
	public TalentGuards(int employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	public int getTalentguardId() {
		return talentguardId;
	}
	public void setTalentguardId(int talentguardId) {
		this.talentguardId = talentguardId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public PersistentBag<Certificates> getCerts() {
		if (certs == null) {
	        certs = new PersistentBag<Certificates>();
	    }
	    return certs;
	}
	public void addToCerts(Certificates cert) {
		this.certs.add(cert);
	}
	public void addToExps(Experiences exp) {
		this.exps.add(exp);
	}
	public PersistentBag<Experiences> getExps() {
		if (exps == null) {
	        exps = new PersistentBag<Experiences>();
	    }
	    return exps;
	}
	public void setCerts(PersistentBag<Certificates> certs) {
		this.certs = certs;
	}

	public void setExps(PersistentBag<Experiences> exps) {
		this.exps = exps;
	}
}