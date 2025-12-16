package cvv.project.foodlog;

import cvv.project.foodlog.entity.User;
import cvv.project.foodlog.entity.UserPersonalInfo;
import cvv.project.foodlog.model.Goal;
import cvv.project.foodlog.model.Sex;
import cvv.project.foodlog.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.Instant;

public class HibernateRunner {

    private static Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {
        try (var sessionFactory = HibernateUtil.buildSessionFactory();
             var session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .id(3L)
                    .PersonalInfo(new UserPersonalInfo("Artem",BigDecimal.valueOf(180.7), BigDecimal.valueOf(81.6), Sex.M, Goal.CUT, 18))
                    .registeredAt(Instant.now())
                    .caloriesAmount(1500)
                    .build();
            log.warn("create User - {User}");
            System.out.println(user);
            session.remove(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
