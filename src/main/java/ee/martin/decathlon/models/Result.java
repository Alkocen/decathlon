package ee.martin.decathlon.models;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "results")
public class Result {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String eventName;
    private double performance;
    private int points;
    
    @ManyToOne
    @JoinColumn(name = "competitor_id", nullable = false)
    private Competitor competitor;
}
