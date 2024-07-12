package com.sapient.sapient.Callouts;
import java.time.LocalDateTime;

import com.sapient.sapient.employees.Employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="callouts")
public class Callout {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="callout_id")
	private int calloutId;
	// Remove this when connecting to Employee Table
	// Remove mentions of this in constructors
//	@Column(name="employee_id")
//	private int employeeId;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@Column(name="callout_date")
	private LocalDateTime calloutDate;
	@Column(name="callout_likes")
	private int likes;
	@Column(name="points")
	private int points;
	@Column(name="comments")
	private String comments;

	public Callout() {};
	public Callout(Employee employee, LocalDateTime calloutDate, int likes, int points, String comments) {
		super();
		this.employee = employee;
		this.calloutDate = LocalDateTime.now();
		this.likes = likes;
		this.points = points;
		this.comments = comments;
	}
	public Callout(Employee employee, String comments) {
		super();
		this.employee = employee;
		this.comments = comments;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public LocalDateTime getCalloutDate() {
		return calloutDate;
	}
	public void setCalloutDate(LocalDateTime calloutDate) {
		this.calloutDate = calloutDate;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getCalloutId() {
		return calloutId;
	}
	@Override
	public String toString() {
		return "Callout [calloutId=" + calloutId + ", employeeId=" + employee + ", calloutDate=" + calloutDate
				+ ", calloutType=" + likes + ", points=" + points + ", comments=" + comments + "]";
	}

}