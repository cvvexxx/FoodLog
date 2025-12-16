package cvv.project.foodlog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;


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

}
