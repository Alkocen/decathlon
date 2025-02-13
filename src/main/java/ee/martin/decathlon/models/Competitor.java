package ee.martin.decathlon.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "competitors")
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Country cannot be blank")
    private String country;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    private Integer age;

    @OneToMany(mappedBy = "competitor", cascade = CascadeType.ALL)
    private List<Result> results;
}
