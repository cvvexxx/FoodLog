package cvv.project.foodlog.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "food_item")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_id")
    private Long workoutId;

    @Column(name = "exercise_id")
    private Long exerciseId;

    private Integer sets;
    private Integer reps;
    private BigDecimal weight;
    private String notes;
}
