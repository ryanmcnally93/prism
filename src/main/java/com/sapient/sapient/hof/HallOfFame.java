package com.sapient.sapient.hof;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "hall_of_fame")
public class HallOfFame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_of_fame_id")
    private int hallOfFameId;

    @Column(name = "achievement_date")
    private LocalDate achievementDate;

    @Column(name = "achievement_type")
    private String achievementType;

    @Column(name = "description")
    private String description;

    //EmployeeID foreign key


    public HallOfFame() {
    }

    public HallOfFame(LocalDate achievementDate, String achievementType, String description) {
        this.achievementDate = achievementDate;
        this.achievementType = achievementType;
        this.description = description;
    }

    public int getHallOfFameId() {
        return hallOfFameId;
    }

    public void setHallOfFameId(int hallOfFameId) {
        this.hallOfFameId = hallOfFameId;
    }

    public LocalDate getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(LocalDate achievementDate) {
        this.achievementDate = achievementDate;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HallOfFame{" +
                "hallOfFameId=" + hallOfFameId +
                ", achievementDate=" + achievementDate +
                ", achievementType='" + achievementType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
