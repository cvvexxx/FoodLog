package cvv.project.foodlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private UserPersonalInfo PersonalInfo;

    @Column(name = "registered_at")
    private Instant registeredAt;

    @Column(name = "calories_amount")
    private Integer caloriesAmount;


    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<WorkoutSession> sessions = new ArrayList<>();

    @Builder.Default
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
