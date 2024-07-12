package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class TalentService {
	@Autowired
	private TalentRepository talentrepository;
	
	public boolean addTalent(TalentGuards t) {
		talentrepository.save(t);
		return true;
	}
	
    public void saveCert(Certificates cert) {
        if(talentrepository.findById(1).isPresent()) {
        	TalentGuards t = talentrepository.findById(1).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
        	t.addToCerts(cert);
        	talentrepository.save(t);
        } else {
        	TalentGuards t = new TalentGuards(1);
        	t.addToCerts(cert);
        	talentrepository.save(t);
        }
    }
	
    public void saveExp(Experiences exp) {
    	if(talentrepository.findById(1).isPresent()) {
	        TalentGuards t = talentrepository.findById(1).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
	        t.addToExps(exp);
	        talentrepository.save(t);
    	} else {
    		TalentGuards t = new TalentGuards(1);
        	t.addToExps(exp);
        	talentrepository.save(t);
    	}
    }
	
	public boolean deleteTalent(Integer i) {
		talentrepository.deleteById(i);
		return true;
	}
	
	public List<TalentGuards> getTalents() {
		return talentrepository.findAll();
	}
	
	public boolean updateTalent(TalentGuards t, int id, int employeeId, LocalDate date, Certificates cert, Experiences exp) {
		t.setEmployeeId(employeeId);
		t.addToCerts(cert);
		t.addToExps(exp);
		cert.setCertDate(date);
		return true;
	}
	
}
