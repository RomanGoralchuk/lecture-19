package by.itacademy.javaenterprise.goralchuk.dao.third.impl;

import by.itacademy.javaenterprise.goralchuk.dao.third.ElevatorInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.third.ElevatorInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ElevatorInstrumentDaoImpl implements ElevatorInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(ElevatorInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public ElevatorInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public ElevatorInstrument find(Long id) {
        ElevatorInstrument instrument = entityManager.find(ElevatorInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public ElevatorInstrument save(ElevatorInstrument instrument) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(instrument);
            entityManager.getTransaction().commit();
            logger.debug("The transaction was successful - {}", instrument);
            return instrument;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Transaction failed {}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public ElevatorInstrument update(ElevatorInstrument elevatorInstrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<ElevatorInstrument> findAll() {
        return null;
    }
}
