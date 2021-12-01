package by.itacademy.javaenterprise.goralchuk.dao.first.Impl;

import by.itacademy.javaenterprise.goralchuk.dao.first.WindInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.first.WindInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class WindInstrumentDaoImpl implements WindInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(WindInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public WindInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }
    @Override
    public WindInstrument find(Long id) {
        WindInstrument instrument = entityManager.find(WindInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public WindInstrument save(WindInstrument instrument) {
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
    public WindInstrument update(WindInstrument windInstrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<WindInstrument> findAll() {
        return null;
    }
}
