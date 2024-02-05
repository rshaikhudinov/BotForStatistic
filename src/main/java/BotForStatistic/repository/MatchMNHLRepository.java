package BotForStatistic.repository;

import BotForStatistic.model.MatchMNHL;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchMNHLRepository  extends JpaRepository<MatchMNHL, Long> {
    MatchMNHL findById (String id);
    List<MatchMNHL> findAllByDivisionIdAndDateBetween(int divisionId, LocalDateTime dateStart, LocalDateTime dateEnd, Sort sort);
}
