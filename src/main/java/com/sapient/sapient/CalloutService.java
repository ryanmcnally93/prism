package com.sapient.sapient;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalloutService {
	@Autowired
	private CalloutRepository calloutRepository;
	
	public boolean addPerson(Callout c) {
		calloutRepository.save(c);
		return true;
	}
	
	public boolean deletePerson(Integer i) {
		calloutRepository.deleteById(i);
		return true;
	}
	
	public List<Callout> getAllCallouts(){
		return calloutRepository.findAll();
	}
	
	public boolean updateCallout(Callout c, int id, int employeeId, LocalDate date, String type, int points, String comments) {
		c.setEmployeeId(employeeId);
		c.setCalloutDate(date);
		c.setCalloutType(type);
		c.setPoints(points);
		c.setComments(comments);
		return true;
	}
}
