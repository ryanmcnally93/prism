package com.sapient.sapient.TalentGuard;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface TalentRepository extends JpaRepository<TalentGuards, Integer> {
	
}
// Thing