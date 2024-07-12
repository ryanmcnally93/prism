package com.sapient.sapient.HallOfFame;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="fames")
public class Fames {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fame_id")
	private int fameId;
	
	// Remove this when connecting to Employee Table
	// Remove mentions of this in constructors
	@Column(name="employee_id")
	private int employeeId;
	
//	@ManyToOne
//	@JoinColumn(name="employee_id")
//	private Employee employee;
//	
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//	public Fames(Employee employee, int employeeId, String fameType, LocalDate fameDate, String description) {
//	super();
//	this.employee = employee;
//	this.fameId = fameId;
//	this.employeeId = employeeId;
//	this.fameType =  LocalDateTime.now();
//	this.fameDate = fameDate;
//	this.description = description;
//}
	
	@Column(name="fame_type")
	private String fameType;
	@Column(name="fame_date")
	private LocalDateTime fameDate;
	@Column(name="description")
	private String description;

	public Fames() {};
	
	public Fames(int fameId, int employeeId) {
		super();
		this.fameId = fameId;
		this.employeeId = employeeId;
	}
	
	public Fames(int fameId, int employeeId, String fameType, LocalDateTime fameDate, String description) {
		super();
		this.fameId = fameId;
		this.employeeId = employeeId;
		this.fameType = fameType;
		this.fameDate =  LocalDateTime.now();
		this.description = description;
	}
	
	public Fames(int employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public int getFameId() {
		return fameId;
	}

	public void setFameId(int fameId) {
		this.fameId = fameId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFameType() {
		return fameType;
	}

	public void setFameType(String fameType) {
		this.fameType = fameType;
	}

	public LocalDateTime getFameDate() {
		return fameDate;
	}

	public void setFameDate(LocalDateTime fameDate) {
		this.fameDate = fameDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Fames [fameId=" + fameId + ", employeeId=" + employeeId + ", fameType=" + fameType + ", fameDate="
				+ fameDate + ", description=" + description + "]";
	}
}