package by.itacademy.javaenterprise.goralchuk.dao.second.impl;

import by.itacademy.javaenterprise.goralchuk.dao.second.MuscleInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.second.MuscleInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class MuscleInstrumentDaoImpl implements MuscleInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(MuscleInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public MuscleInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public MuscleInstrument find(Long id) {
        MuscleInstrument instrument = entityManager.find(MuscleInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public MuscleInstrument save(MuscleInstrument instrument) {
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
    public MuscleInstrument update(MuscleInstrument muscleInstrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<MuscleInstrument> findAll() {
        return null;
    }
}
