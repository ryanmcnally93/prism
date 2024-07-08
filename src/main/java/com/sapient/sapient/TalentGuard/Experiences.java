package com.sapient.sapient.TalentGuard;
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
	public TalentGuards talentguards;
	public String experience;
	public int years;
	public int months;
	
	public Experiences(String exp, int years, int months) {
		this.experience = exp;
		this.years = years;
		this.months = months;
	}
}
