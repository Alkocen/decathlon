package ee.martin.decathlon.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ScoringService {
    // Constants for each event
    private static final Map<String, double[]> SCORING_RULES = Map.of(
        "100m", new double[]{25.4347, 18, 1.81},
        "long jump", new double[]{0.14354, 220, 1.4},
        "shot put", new double[]{51.39, 1.5, 1.05},
        "high jump", new double[]{0.8465, 75, 1.42},
        "400 meters", new double[]{1.53775, 82, 1.81},
        "110 meters hurdles", new double[]{5.74352, 28.5, 1.92},
        "discus throw", new double[]{12.91, 4, 1.1},
        "pole vault", new double[]{0.2797, 100, 1.35},
        "javelin throw", new double[]{10.14, 7, 1.08},
        "1500 meters", new double[]{0.03768, 480, 1.85}
    );

    public int calculatePoints(String event, double performance) {
        double[] params = SCORING_RULES.get(event);
        if (params == null) throw new IllegalArgumentException("Invalid event: " + event);

        double A = params[0], B = params[1], C = params[2];

        // Determine if the event is time-based or distance-based
        double points;
        if (event.contains("meters") || event.contains("hurdles")) {
            points = A * Math.pow((B - performance), C);
        } else {
            points = A * Math.pow((performance - B), C);
        }

        return (int) Math.round(points);
    }
}
