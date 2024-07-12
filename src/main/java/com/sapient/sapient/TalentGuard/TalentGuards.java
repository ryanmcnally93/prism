package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sapient.sapient.employees.Employee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;


@Entity
@Table(name="talentguards")
public class TalentGuards {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="talentguard_id")
	private int talentguardId;
	
	// Remove this when connecting to Employee Table
	// Remove mentions of this in constructors
//	@Column(name="employee_id")
//	private int employeeId;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@OneToMany(mappedBy = "talentguard", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OrderColumn
	private List<Certificates> certs;
	@OneToMany(mappedBy = "talentguard", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@OrderColumn
	private List<Experiences> exps;
	
	public TalentGuards() {};
	
	public TalentGuards(int talentguardId, Employee employee) {
		super();
		this.talentguardId = talentguardId;
		this.employee = employee;
	}
	
	public TalentGuards(int talentguardId, Employee employee, ArrayList<Certificates> certs, ArrayList<Experiences> exps) {
		super();
		this.talentguardId = talentguardId;
		this.employee = employee;
		this.certs = certs;
		this.exps = exps;
	}
	
	public TalentGuards(Employee employee) {
		super();
		this.employee = employee;
	}
	
	public TalentGuards(Employee employee, Certificates cert) {
		super();
		this.employee = employee;
		if(this.certs == null) {
			this.certs = new ArrayList<Certificates>();
		}
		this.addToCerts(cert);
	}
	
	public TalentGuards(Employee employee, Experiences exp) {
		super();
		this.employee = employee;
		if(this.exps == null) {
			this.exps = new ArrayList<Experiences>();
		}
		this.addToExps(exp);
	}
	
	
	public TalentGuards(Employee employee, ArrayList<Certificates> certs, ArrayList<Experiences> exps) {
		super();
		this.employee = employee;
		this.certs = certs;
		this.exps = exps;
	}
	
	public int getTalentguardId() {
		return talentguardId;
	}
	public void setTalentguardId(int talentguardId) {
		this.talentguardId = talentguardId;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Certificates> getCerts() {
		if (certs == null) {
	        certs = new ArrayList<Certificates>();
	    }
	    return certs;
	}

	public void addToCerts(Certificates cert) {
		cert.setTalentguards(this);
		if(certs == null) {
			certs = new ArrayList<Certificates>();
			certs.add(cert);
		} else {
			certs.add(cert);
		}
	}
	public void addToExps(Experiences exp) {
		exp.setTalentguards(this);
		if(exps == null) {
			exps = new ArrayList<Experiences>();
			exps.add(exp);
		} else {
			exps.add(exp);
		}
	}
	public List<Experiences> getExps() {
		if (exps == null) {
	        exps = new ArrayList<Experiences>();
	    }
	    return exps;
	}
	public void setCerts(ArrayList<Certificates> certs) {
		this.certs = certs;
	}

	public void setExps(ArrayList<Experiences> exps) {
		this.exps = exps;
	}

	@Override
	public String toString() {
		return "TalentGuards [talentguardId=" + talentguardId + ", employeeId=" + employee + ", certs=" + certs
				+ ", exps=" + exps + "]";
	}
	
}