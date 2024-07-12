package com.sapient.sapient.employees;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean addEmployee(Employee e) {
		employeeRepository.save(e);
		return true;
	}
	
	public boolean deleteEmployee(Integer i) {
		employeeRepository.deleteById(i);
		return true;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
//	public boolean updateEmployee(Callout c, int id, int employeeId, LocalDate date, String type, int points, String comments) {
//		c.setEmployeeId(employeeId);
//		c.setCalloutDate(date);
//		c.setCalloutType(type);
//		c.setPoints(points);
//		c.setComments(comments);
//		return true;
//	}
}