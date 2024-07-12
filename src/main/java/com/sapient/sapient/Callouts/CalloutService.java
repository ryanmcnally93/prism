package com.sapient.sapient.Callouts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.sapient.HallOfFame.Fames;

@Component
public class CalloutService {
	@Autowired
	private CalloutRepository calloutRepository;
	
	public boolean addCallout(Callout c) {
		if(c.getCalloutDate() == null) {
			c.setCalloutDate(LocalDateTime.now());
		}
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
	
	public boolean updateCallout(Callout c, int id, int employeeId, LocalDateTime date, String type, int points, String comments) {
		c.setEmployeeId(employeeId);
		c.setCalloutDate(date);
		c.setCalloutType(type);
		c.setPoints(points);
		c.setComments(comments);
		return true;
	}
}