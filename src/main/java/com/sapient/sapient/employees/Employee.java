package com.sapient.sapient.employees;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.sapient.sapient.Callouts.Callout;
import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	@OneToMany(mappedBy = "employee")
	private List<Callout> callouts;
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	@Column(name="team")
	private int team;
	@Column(name="DOB")
	private LocalDate dob;
	@Column(name="email")
	private String email;
	@Column(name="telephone")
	private String tPhone;
	@Column(name="ROLE")
	private String role;
	@Column(name="is_friend")
	private boolean isFriend;
	@Column(name="is_manager")
	private boolean isManager;
	public Employee(String fName, String lName, int team, LocalDate dob, String email, String tPhone, String role,
			boolean isFriend, boolean isManager) {

		this.fName = fName;
		this.lName = lName;
		this.team = team;
		this.dob = dob;
		this.email = email;
		this.tPhone = tPhone;
		this.role = role;
		this.isFriend = isFriend;
		this.isManager = isManager;
	}
	public Employee() {
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String gettPhone() {
		return tPhone;
	}
	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getIsFriend() {
		return isFriend;
	}
	public void setIsFriend(Boolean isFriend) {
		this.isFriend = isFriend;
	}
	public Boolean getIsManager() {
		return isManager;
	}
	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}
	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}

}
