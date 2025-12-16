package cvv.project.foodlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_intake")
public class FoodIntake {

    @Id
    private Long id;

    private String name;

    private Integer weight;

    private BigDecimal protein;
    private BigDecimal fats;
    private BigDecimal carbs;
    private Integer calories;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
