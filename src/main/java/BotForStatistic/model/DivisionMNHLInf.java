package BotForStatistic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "DivisionMNHLInf")
public class DivisionMNHLInf {
    @Id
    @Column(name = "divisionId")
    private int divisionId;
    @Column(name = "divisionName")
    private String divisionName;
    @Column(name = "dateLastCheck")
    private LocalDate dateLastCheck;
}
