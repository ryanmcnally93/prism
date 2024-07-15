package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.sapient.employees.Employee;
import com.sapient.sapient.employees.EmployeeRepository;

import jakarta.transaction.Transactional;

@Component
public class TalentService {
	@Autowired
	private TalentRepository talentrepository;
	@Autowired
	private EmployeeRepository employeerepo;
	
	public boolean addTalent(TalentGuards t) {
		talentrepository.save(t);
		return true;
	}
	
    public void saveCert(Certificates cert) {
    	if(employeerepo.findById(5).isPresent()) {
    		if(talentrepository.findById(1).isPresent()) {
            	TalentGuards t = talentrepository.findById(1).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
            	t.addToCerts(cert);
            	talentrepository.save(t);
            } else {
            	Employee e = employeerepo.findById(5).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
        		TalentGuards t = new TalentGuards(e);
            	t.addToCerts(cert);
            	talentrepository.save(t);
            }
    	} else {
    		System.out.println("Couldn't find user");
    	}
        
    }
	
    public void saveExp(Experiences exp) {
    	if(employeerepo.findById(5).isPresent()) {
	    	if(talentrepository.findById(1).isPresent()) {
		        TalentGuards t = talentrepository.findById(1).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
		        t.addToExps(exp);
		        talentrepository.save(t);
	    	} else {
	    		Employee e = employeerepo.findById(5).orElseThrow(() -> new RuntimeException("TalentGuards not found"));
        		TalentGuards t = new TalentGuards(e);
	        	t.addToExps(exp);
	        	talentrepository.save(t);
	    	}
    	} else {
    		System.out.println("Couldn't find user");
    	}
    }
	
	public boolean deleteTalent(Integer i) {
		talentrepository.deleteById(i);
		return true;
	}
	
	public List<TalentGuards> getTalents() {
		return talentrepository.findAll();
	}
	
	public boolean updateTalent(TalentGuards t, int id, Employee employee, LocalDate date, Certificates cert, Experiences exp) {
		t.setEmployee(employee);
		t.addToCerts(cert);
		t.addToExps(exp);
		cert.setCertDate(date);
		return true;
	}
	
}