package by.itacademy.javaenterprise.goralchuk;

import by.itacademy.javaenterprise.goralchuk.util.FlywayUtil;
import by.itacademy.javaenterprise.goralchuk.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            FlywayUtil.cleanMigration();
            FlywayUtil.updateMigration();

        } catch (StackOverflowError  e) {
            logger.error(e.getMessage(), e);
        }
        HibernateUtil.close();
    }
}