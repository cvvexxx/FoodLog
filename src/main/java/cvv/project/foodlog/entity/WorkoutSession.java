package cvv.project.foodlog.entity;

import cvv.project.foodlog.model.SessionType;
import cvv.project.foodlog.model.WeekDay;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workout_sessions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;

    @Enumerated(EnumType.STRING)
    private SessionType sessionType;

    private Integer duration;
}
