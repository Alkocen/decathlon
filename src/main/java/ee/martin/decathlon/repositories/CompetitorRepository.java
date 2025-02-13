package ee.martin.decathlon.repositories;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ee.martin.decathlon.models.Competitor;
import jakarta.transaction.Transactional;

public interface CompetitorRepository extends JpaRepository<Competitor, UUID>{
    
    List<Competitor> findByName(String name);
    List<Competitor> findByAge(int age);
    List<Competitor> findByCountry(String country);

    @Transactional
    void deleteByName(String name);

}
