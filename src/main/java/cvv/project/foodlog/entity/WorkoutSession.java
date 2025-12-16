package cvv.project.foodlog.entity;

import cvv.project.foodlog.model.SessionType;
import cvv.project.foodlog.model.WeekDay;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workout_sessions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"user"})
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day")
    private WeekDay weekDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SessionType sessionType;

    private Integer duration;

    @Builder.Default
    @OneToMany(mappedBy = "workoutSession", fetch = FetchType.LAZY)
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExercises.add(workoutExercise);
        workoutExercise.setWorkoutSession(this);
    }
}
