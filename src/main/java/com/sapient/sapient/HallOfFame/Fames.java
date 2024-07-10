package com.sapient.sapient.HallOfFame;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;


@Entity
@Table(name="fames")
public class Fames {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fame_id")
	private int fameId;
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="fame_type")
	private String fameType;
	@Column(name="fame_date")
	private LocalDate fameDate;
	@Column(name="description")
	private String description;

	public Fames() {};
	
	public Fames(int fameId, int employeeId) {
		super();
		this.fameId = fameId;
		this.employeeId = employeeId;
	}
	
	public Fames(int fameId, int employeeId, String fameType, LocalDate fameDate, String description) {
		super();
		this.fameId = fameId;
		this.employeeId = employeeId;
		this.fameType = fameType;
		this.fameDate = fameDate;
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

	public LocalDate getFameDate() {
		return fameDate;
	}

	public void setFameDate(LocalDate fameDate) {
		this.fameDate = fameDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}