package cvv.project.foodlog.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
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
}
