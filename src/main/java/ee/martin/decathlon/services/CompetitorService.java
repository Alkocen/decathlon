package ee.martin.decathlon.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ee.martin.decathlon.models.Competitor;
import ee.martin.decathlon.repositories.CompetitorRepository;
import jakarta.validation.Valid;

@Service
public class CompetitorService {
    private final CompetitorRepository competitorRepository;

    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAll();
    }

    public Competitor saveCompetitor(@Valid Competitor competitor) {
        return competitorRepository.save(competitor);
    }

    public List<Competitor> saveCompetitors(@Valid List<Competitor> competitors) {
        return competitorRepository.saveAll(competitors);
    }

    public boolean deleteCompetitorByName(String name) {
        List<Competitor> competitors = competitorRepository.findByName(name);
        if (competitors.isEmpty()) {
            return false; // No competitor found
        }
        
        competitorRepository.deleteByName(name);
        return true;
    }
}
