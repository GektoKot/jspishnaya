package hibernate;

import entity.User;
import org.hibernate.Session;

public class HibernateRunner {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            User user = session.get(User.class, 1);
            System.out.println(user);

        }
    }
}
