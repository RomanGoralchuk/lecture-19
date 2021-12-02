package by.itacademy.javaenterprise.goralchuk.dao.third.impl;

import by.itacademy.javaenterprise.goralchuk.dao.third.SawGigliInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.third.SawGigliInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class SawGigliInstrumentDaoImpl implements SawGigliInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(SawGigliInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public SawGigliInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public SawGigliInstrument find(Long id) {
        SawGigliInstrument instrument = entityManager.find(SawGigliInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public SawGigliInstrument save(SawGigliInstrument instrument) {
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
    public SawGigliInstrument update(SawGigliInstrument sawGigliInstrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<SawGigliInstrument> findAll() {
        return null;
    }
}
