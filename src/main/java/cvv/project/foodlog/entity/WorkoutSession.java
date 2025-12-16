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
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;

    @Enumerated(EnumType.STRING)
    private SessionType sessionType;

    private Integer duration;

    @OneToMany(fetch = FetchType.LAZY)
    private List<WorkoutExercise> workoutExercises = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExercises.add(workoutExercise);
        workoutExercise.setWorkoutSession(this);
    }
}
