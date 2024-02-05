package BotForStatistic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "MatchMNHL")
public class MatchMNHL {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "divisionId")
    private int divisionId;
    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
    @Column(name = "teamHome")
    private String teamHome;
    @Column(name = "teamAway")
    private String teamAway;
    @Column(name = "scoreHome")
    private int scoreHome;
    @Column(name = "scoreAway")
    private int scoreAway;
    @Column(name = "scorePeriod")
    private String scorePeriod;
    @Column(name = "events", columnDefinition = "TEXT")
    private String events;

    // пустой обязательно для JpaRepository
    public MatchMNHL() {}

    public MatchMNHL(String id, int divisionId, LocalDateTime date, String teamHome, String teamAway, int scoreHome, int scoreAway, String scorePeriod, String events) {
        this.id = id;
        this.divisionId = divisionId;
        this.date = date;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.scorePeriod = scorePeriod;
        this.events = events;
    }
}