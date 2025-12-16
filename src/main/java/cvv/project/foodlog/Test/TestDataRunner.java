package cvv.project.foodlog.Test;

import cvv.project.foodlog.entity.*;
import cvv.project.foodlog.model.Goal;
import cvv.project.foodlog.model.SessionType;
import cvv.project.foodlog.model.Sex;
import cvv.project.foodlog.model.WeekDay;
import cvv.project.foodlog.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.Instant;

public class TestDataRunner {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.buildSessionFactory();

        try (Session session = sf.openSession()) {
            session.beginTransaction();

            // 1. User + personal info
            UserPersonalInfo info = new UserPersonalInfo();
            info.setName("Ivan");
            info.setWeight(new BigDecimal("75.0"));
            info.setSex(Sex.M);
            info.setAge(18);
            info.setGoal(Goal.BULK);

            User user = new User();
            user.setRegisteredAt(Instant.now());
            user.setCaloriesAmount(2600);
            user.setPersonalInfo(info);

            // 2. WorkoutSession, привязать к user
            WorkoutSession session1 = new WorkoutSession();
            session1.setWeekDay(WeekDay.MON);
            session1.setSessionType(SessionType.PUSH);
            session1.setDuration(60);
            session1.setUser(user);              // many-to-one
            user.getSessions().add(session1);    // one-to-many

            // 3. Exercise
            Exercise bench = new Exercise();
            bench.setName("Bench Press");

            // 4. WorkoutExercise, связка session + exercise
            WorkoutExercise we = new WorkoutExercise();
            we.setWorkoutSession(session1);
            we.setExercise(bench);
            we.setSets(3);
            we.setReps(8);
            we.setWeight(new BigDecimal("60.0"));
            we.setNotes("RPE 8");


            // 5. Сохранить корень графа
            session.persist(user);   // cascade на sessions и exercises, если настроен
            session.persist(bench);  // exercise отдельно

            session.getTransaction().commit();
        }

        sf.close();
    }
}
