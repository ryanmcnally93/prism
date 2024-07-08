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

@Entity
@Table(name="talentguards")
public class TalentGuards {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="talentguard_id")
	private int talentguardId;
	@Column(name="employee_id")
	private int employeeId;
	@OneToMany(mappedBy = "talentguards", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Certificates> certs;
	@OneToMany(mappedBy = "talentguards", cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Experiences> exps;

	public TalentGuards() {};
	public TalentGuards(int employeeId, Certificates cert, Experiences exp) {
		super();
		this.employeeId = employeeId;
		this.certs.add(cert);
		this.exps.add(exp);
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
	public ArrayList<Certificates> getCerts() {
		return certs;
	}
	public void setCerts(ArrayList<Certificates> certs) {
		this.certs = certs;
	}
	public ArrayList<Experiences> getExps() {
		return exps;
	}
	public void setExps(ArrayList<Experiences> exps) {
		this.exps = exps;
	}
}