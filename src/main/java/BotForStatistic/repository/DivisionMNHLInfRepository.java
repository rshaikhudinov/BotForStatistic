package BotForStatistic.repository;

import BotForStatistic.model.DivisionMNHLInf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionMNHLInfRepository  extends JpaRepository<DivisionMNHLInf, Long> {
    DivisionMNHLInf findByDivisionId (int divisionId);
}
