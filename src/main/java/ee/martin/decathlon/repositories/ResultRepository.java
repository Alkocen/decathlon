package ee.martin.decathlon.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.martin.decathlon.models.Competitor;
import ee.martin.decathlon.models.Result;

public interface ResultRepository extends JpaRepository<Result, UUID> {

    List<Result> findByCompetitor(Competitor competitor);
    List<Result> findByEventName(String eventName);
    
}
