package cvv.project.foodlog.Test;

import cvv.project.foodlog.entity.*;
import cvv.project.foodlog.model.Goal;
import cvv.project.foodlog.model.SessionType;
import cvv.project.foodlog.model.Sex;
import cvv.project.foodlog.model.WeekDay;
import cvv.project.foodlog.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class DataRunnerTest {

    @Test
    void userWorkoutExerciseMapping_shouldPersistCorrectly() {
        try (SessionFactory sf = HibernateUtil.buildSessionFactory()) {


            Long userId;
            Long workoutId;
            Long exerciseId;
            Long weId;

            // ---------- persist ----------
            try (Session session = sf.openSession()) {
                session.beginTransaction();

                UserPersonalInfo info = UserPersonalInfo.builder()
                        .name("Ivan")
                        .height(new BigDecimal("180.7"))
                        .weight(new BigDecimal("75.0"))
                        .sex(Sex.M)
                        .age(18)
                        .goal(Goal.BULK)
                        .build();

                User user = User.builder()
                        .registeredAt(Instant.now())
                        .caloriesAmount(2600)
                        .PersonalInfo(info)
                        .build();

                WorkoutSession workout = WorkoutSession.builder()
                        .weekDay(WeekDay.MON)
                        .sessionType(SessionType.PUSH)
                        .duration(60)
                        .user(user)
                        .build();

                Exercise bench = Exercise.builder()
                        .name("Bench Press")
                        .build();

                WorkoutExercise we = WorkoutExercise.builder()
                        .workoutSession(workout)
                        .exercise(bench)
                        .sets(3)
                        .reps(8)
                        .weight(new BigDecimal("60.0"))
                        .notes("RPE 8")
                        .build();

                user.setWorkoutSession(workout);
                workout.setWorkoutExercise(we);
                bench.setWorkoutExercise(we);

                session.persist(user);
                session.persist(bench);

                session.getTransaction().commit();

                userId = user.getId();
                workoutId = workout.getId();
                exerciseId = bench.getId();
                weId = we.getId();
            }

            // ---------- load & assert ----------
            try (Session session = sf.openSession()) {
                User loadedUser = session.find(User.class, userId);
                assertNotNull(loadedUser);
                assertEquals("Ivan", loadedUser.getPersonalInfo().getName());

                assertEquals(1, loadedUser.getSessions().size());
                WorkoutSession loadedWorkout = loadedUser.getSessions().get(0);
                assertEquals(WeekDay.MON, loadedWorkout.getWeekDay());
                assertEquals(SessionType.PUSH, loadedWorkout.getSessionType());

                assertEquals(1, loadedWorkout.getWorkoutExercises().size());
                WorkoutExercise loadedWe = loadedWorkout.getWorkoutExercises().get(0);
                assertEquals(3, loadedWe.getSets());
                assertEquals(8, loadedWe.getReps());
                assertEquals(new BigDecimal("60.0").doubleValue(), loadedWe.getWeight().doubleValue());

                assertEquals("Bench Press", loadedWe.getExercise().getName());
            }
        }
    }
}
