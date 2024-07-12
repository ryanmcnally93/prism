package com.sapient.sapient.SmallImprovements;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "small_improvements")
public class SmallImprovements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "small_improvements_id")
    private int smallImprovementsId;
	
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "objectives")
	private String objectives;

	@Column(name = "meetings")
	private String meetings;

	@Column(name = "feedback")
	private String feedback;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "meeting_date")
	private LocalDate meetingDate;

	public SmallImprovements() {
		super();
	}

	public SmallImprovements(String objectives, String meetings, String feedback, LocalDate dueDate,
			LocalDate meetingDate) {
		super();
		this.objectives = objectives;
		this.meetings = meetings;
		this.feedback = feedback;
		this.dueDate = dueDate;
		this.meetingDate = meetingDate;
	}

	public SmallImprovements(int smallImprovementsId, int employeeId, String objectives, String meetings,
			String feedback, LocalDate dueDate, LocalDate meetingDate) {
		super();
		this.smallImprovementsId = smallImprovementsId;
		this.employeeId = employeeId;
		this.objectives = objectives;
		this.meetings = meetings;
		this.feedback = feedback;
		this.dueDate = dueDate;
		this.meetingDate = meetingDate;
	}

	public int getSmallImprovementsId() {
		return smallImprovementsId;
	}

	public void setSmallImprovementsId(int smallImprovementsId) {
		this.smallImprovementsId = smallImprovementsId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public String getMeetings() {
		return meetings;
	}

	public void setMeetings(String meetings) {
		this.meetings = meetings;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDate getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}

	@Override
	public String toString() {
		return "SmallImprovements [smallImprovementsId=" + smallImprovementsId + ", employeeId=" + employeeId
				+ ", objectives=" + objectives + ", meetings=" + meetings + ", feedback=" + feedback + ", dueDate="
				+ dueDate + ", meetingDate=" + meetingDate + "]";
	}

}