package cvv.project.foodlog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "workout_exercise")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //ToDO
    private Long workoutId;
    private Long exerciseId;

    private Integer sets;
    private Integer reps;
    private BigDecimal weight;
    private String notes;
}
