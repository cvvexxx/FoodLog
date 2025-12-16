package cvv.project.foodlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_item")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
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


    @OneToMany(mappedBy = "foodItem", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FoodIntake> foodIntakes = new ArrayList<>();

    public void setFoodIntakes(FoodIntake foodIntake) {
        foodIntakes.add(foodIntake);
        foodIntake.setFoodItem(this);
    }
}
