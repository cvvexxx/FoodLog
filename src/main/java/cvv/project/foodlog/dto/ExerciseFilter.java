package cvv.project.foodlog.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
@Builder
public class ExerciseFilter {
    String name;
    Integer sets;
    Integer reps;
    BigDecimal weight;
    String notes;
}
