package com.sapient.sapient.HallOfFame;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FameService {
	@Autowired
	private FameRepository famerepository;
	
	public boolean addFame(Fames f) {
		famerepository.save(f);
		return true;
	}
	
	public boolean deleteFame(Integer i) {
		famerepository.deleteById(i);
		return true;
	}
	
	public List<Fames> getFames() {
		return famerepository.findAll();
	}
	
}
