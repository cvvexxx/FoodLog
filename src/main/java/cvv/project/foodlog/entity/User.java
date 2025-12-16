package cvv.project.foodlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registered_at")
    private Instant registeredAt;

    @Column(name = "calories_amount")
    private Integer caloriesAmount;

    @Embedded
    private UserPersonalInfo PersonalInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkoutSession> sessions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FoodIntake> foodIntakes = new ArrayList<>();

    public void setFoodIntake(FoodIntake foodIntake) {
        foodIntakes.add(foodIntake);
        foodIntake.setUser(this);
    }

    public void setWorkoutSession(WorkoutSession session) {
        sessions.add(session);
        session.setUser(this);
    }
}
