package com.sapient.sapient.Callouts;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
//	public Callout(Employee employee, LocalDate calloutDate, String calloutType, int points, String comments) {
//		super();
//		this.employee = employee;
//		this.calloutDate = calloutDate;
//		this.calloutType = calloutType;
//		this.points = points;
//		this.comments = comments;
//	}
	
	@Column(name="callout_date")
	private LocalDate calloutDate;
	@Column(name="callout_type")
	private String calloutType;
	@Column(name="points")
	private int points;
	@Column(name="comments")
	private String comments;

	public Callout() {};
	public Callout(int employeeId, LocalDate calloutDate, String calloutType, int points, String comments) {
		super();
		this.employeeId = employeeId;
		this.calloutDate = calloutDate;
		this.calloutType = calloutType;
		this.points = points;
		this.comments = comments;
	}
	public Callout(int employeeId, String comments) {
		super();
		this.employeeId = employeeId;
		this.comments = comments;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getCalloutDate() {
		return calloutDate;
	}
	public void setCalloutDate(LocalDate calloutDate) {
		this.calloutDate = calloutDate;
	}
	public String getCalloutType() {
		return calloutType;
	}
	public void setCalloutType(String calloutType) {
		this.calloutType = calloutType;
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
		return "Callout [calloutId=" + calloutId + ", employeeId=" + employeeId + ", calloutDate=" + calloutDate
				+ ", calloutType=" + calloutType + ", points=" + points + ", comments=" + comments + "]";
	}

}
