package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// BARE IN MIND
// If a 'talentguard' instance does not exist within the 
// database with this 'talentguard_id', this will throw an error
// Ensure you fill the talentguard table before filling this one

@Entity
public class Experiences {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exp_id")
	private int expId;
	@ManyToOne
	@JoinColumn(name="talentguard_id")
	public TalentGuards talentguard;
	public String experience;
	public int years;
	public int months;
	
	public Experiences() {};
	
	public Experiences(int expId, TalentGuards tgs) {
		this.expId = expId;
		this.talentguard = tgs;
	}
	
	public Experiences(String experience, int years, int months) {
		this.experience = experience;
		this.years = years;
		this.months = months;
	}
	
	public Experiences(int expId, TalentGuards tgs, String experience, int years, int months) {
		this.expId = expId;
		this.talentguard = tgs;
		this.experience = experience;
		this.years = years;
		this.months = months;
	}
	
	public Experiences(TalentGuards tgs, String experience, int years, int months) {
		this.talentguard = tgs;
		this.experience = experience;
		this.years = years;
		this.months = months;
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public TalentGuards getTalentguards() {
		return talentguard;
	}

	public void setTalentguards(TalentGuards talentguards) {
		this.talentguard = talentguards;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}
}
