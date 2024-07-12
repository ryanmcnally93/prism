package com.sapient.sapient.SmallImprovements;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmallImprovementsService {

    @Autowired
    private SmallImprovementsRepository smallImprovementsRepository;

    public List<SmallImprovements> getAllImprovements() {
        return smallImprovementsRepository.findAll();
    }

    public SmallImprovements getImprovementById(int id) {
        return smallImprovementsRepository.findById(id).orElse(null);
    }

    public SmallImprovements saveImprovement(SmallImprovements improvement) {
        return smallImprovementsRepository.save(improvement);
    }

    public SmallImprovements updateImprovement(int id, SmallImprovements improvementDetails) {
        SmallImprovements improvement = smallImprovementsRepository.findById(id).orElse(null);
        if (improvement != null) {
        	improvement.setEmployeeId(improvementDetails.getEmployeeId());
            improvement.setObjectives(improvementDetails.getObjectives());
            improvement.setMeetings(improvementDetails.getMeetings());
            improvement.setFeedback(improvementDetails.getFeedback());
            improvement.setDueDate(improvementDetails.getDueDate());
            improvement.setMeetingDate(improvementDetails.getMeetingDate());
            return smallImprovementsRepository.save(improvement);
        }
        return null;
    }

    public void deleteImprovement(int id) {
    	smallImprovementsRepository.deleteById(id);
    }

    public List<SmallImprovements> getDueSoonObjectives() {
        LocalDate today = LocalDate.now();
        return smallImprovementsRepository.findAll().stream()
                .filter(improvement -> improvement.getDueDate() != null && !improvement.getDueDate().isBefore(today))
                .sorted((i1, i2) -> i1.getDueDate().compareTo(i2.getDueDate()))
                .collect(Collectors.toList());
    }

    public SmallImprovements getNextMeeting() {
        LocalDate today = LocalDate.now();
        return smallImprovementsRepository.findAll().stream()
                .filter(improvement -> improvement.getMeetingDate() != null && !improvement.getMeetingDate().isBefore(today))
                .sorted((i1, i2) -> i1.getMeetingDate().compareTo(i2.getMeetingDate()))
                .findFirst()
                .orElse(null);
    }

    public SmallImprovements getMostRecentFeedback() {
        return smallImprovementsRepository.findAll().stream()
                .sorted((i1, i2) -> i2.getSmallImprovementsId() - i1.getSmallImprovementsId())
                .findFirst()
                .orElse(null);
    }
}
