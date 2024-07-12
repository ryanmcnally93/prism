package com.sapient.sapient.SmallImprovements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallImprovementsRepository extends JpaRepository<SmallImprovements, Integer> {
}
