package ee.martin.decathlon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.martin.decathlon.models.Competitor;
import ee.martin.decathlon.services.CompetitorService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/competitors")
public class CompetitorController {
    private final CompetitorService competitorService;

    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping()
    public List<Competitor> getAllCompetitors() {
        return competitorService.getAllCompetitors();
    }

    @PostMapping()
    public Competitor addCompetitor(@Valid @RequestBody Competitor competitor) {
        return competitorService.saveCompetitor(competitor);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Competitor>> addCompetitors(@Valid @RequestBody List<Competitor> competitors) {
        List<Competitor> savedCompetitors = competitorService.saveCompetitors(competitors);
        return ResponseEntity.ok(savedCompetitors);
    }
    
    @DeleteMapping("/name/{name}")
    public ResponseEntity<String> deleteCompetitorByName(@PathVariable String name) {
        boolean deleted = competitorService.deleteCompetitorByName(name);

        if (deleted) {
            return ResponseEntity.ok("Competitor deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competitor not found.");
        }

    }
}
