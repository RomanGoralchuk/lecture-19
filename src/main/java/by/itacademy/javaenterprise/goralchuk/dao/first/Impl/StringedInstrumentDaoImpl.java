package by.itacademy.javaenterprise.goralchuk.dao.first.impl;

import by.itacademy.javaenterprise.goralchuk.dao.first.StringedInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.first.StringedInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class StringedInstrumentDaoImpl implements StringedInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(StringedInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public StringedInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public StringedInstrument find(Long id) {
        StringedInstrument instrument = entityManager.find(StringedInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public StringedInstrument save(StringedInstrument instrument) {
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
    public StringedInstrument update(StringedInstrument instrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<StringedInstrument> findAll() {
        return null;
    }
}
