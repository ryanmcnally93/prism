//package com.sapient.sapient.teams;
//import java.util.ArrayList;
//
//import com.sapient.sapient.employees.Employee;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "teams")
//public class Teams {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="team_id")
//    private Long teamID;
//
//    @OneToMany
//    @JoinColumn(name = "employee_id", nullable = false)
//    private ArrayList<Employee> employee;
//
//    public Teams() {
//    }
//
//    public Long getTeamID() {
//        return teamID;
//    }
//
//    public void setTeamID(Long teamID) {
//        this.teamID = teamID;
//    }
//
//    public ArrayList<Employee> getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(ArrayList<Employee> employee) {
//        this.employee = employee;
//    }
//}