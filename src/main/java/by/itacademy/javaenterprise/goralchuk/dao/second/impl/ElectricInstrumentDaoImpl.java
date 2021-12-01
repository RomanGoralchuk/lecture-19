package by.itacademy.javaenterprise.goralchuk.dao.second.impl;

import by.itacademy.javaenterprise.goralchuk.dao.second.ElectricInstrumentDao;
import by.itacademy.javaenterprise.goralchuk.entity.second.ElectricInstrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ElectricInstrumentDaoImpl implements ElectricInstrumentDao {
    private static final Logger logger = LoggerFactory.getLogger(ElectricInstrumentDaoImpl.class);

    private EntityManager entityManager;

    public ElectricInstrumentDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public ElectricInstrument find(Long id) {
        ElectricInstrument instrument = entityManager.find(ElectricInstrument.class, id);
        if (instrument == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return instrument;
        }
    }

    @Override
    public ElectricInstrument save(ElectricInstrument instrument) {
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
    public ElectricInstrument update(ElectricInstrument electricInstrument) {
        return null;
    }

    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<ElectricInstrument> findAll() {
        return null;
    }
}
