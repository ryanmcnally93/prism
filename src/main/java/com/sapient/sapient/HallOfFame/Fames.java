package com.sapient.sapient.HallOfFame;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sapient.sapient.employees.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import com.sapient.sapient.Callouts.CommonAttribute;

@Entity
@Table(name="fames")
public class Fames implements CommonAttribute {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fame_id")
	private int fameId;
	
	// Remove this when connecting to Employee Table
	// Remove mentions of this in constructors
//	@Column(name="employee_id")
//	private int employeeId;
	@Column(name="fame_likes")
	private int likes;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@Column(name = "comments")
	private ArrayList<String> comments;
	@Column(name="fame_type")
	private String fameType;
	@Column(name="fame_date")
	private LocalDateTime fameDate;
	@Column(name="description")
	private String description;

	public Fames() {};
	
	public Fames(int fameId, Employee employee) {
		super();
		this.fameId = fameId;
		this.employee = employee;
		this.comments = new ArrayList<String>();
	}
	
	public Fames(int fameId, Employee employee, String fameType, LocalDateTime fameDate, String description) {
		super();
		this.fameId = fameId;
		this.employee = employee;
		this.fameType = fameType;
		this.fameDate =  LocalDateTime.now();
		this.description = description;
		this.comments = new ArrayList<String>();
	}
	
	public Fames(Employee employee) {
		super();
		this.employee = employee;
		this.comments = new ArrayList<String>();
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getFameId() {
		return fameId;
	}

	public void setFameId(int fameId) {
		this.fameId = fameId;
	}

	public String getFameType() {
		return fameType;
	}

	public void setFameType(String fameType) {
		this.fameType = fameType;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
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
	public ArrayList<String> getComments() {
		return comments;
	}
	public void addToComments(String comment) {
		if(comments == null) {
			comments = new ArrayList<String>();
		}
		this.comments.add(comment);
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Fames [fameId=" + fameId + ", employeeId=" + employee + ", fameType=" + fameType + ", fameDate="
				+ fameDate + ", description=" + description + "]";
	}

	@Override
	public LocalDateTime getDate() {
		return this.getFameDate();
	}

	@Override
	public String getType() {
		return "fame";
	}
}