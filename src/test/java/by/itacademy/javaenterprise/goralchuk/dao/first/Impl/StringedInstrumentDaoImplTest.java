package by.itacademy.javaenterprise.goralchuk.dao.first.Impl;

import by.itacademy.javaenterprise.goralchuk.entity.first.StringedInstrument;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringedInstrumentDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(StringedInstrumentDaoImplTest.class);

    private EntityManager entityManagerManager;
    private EntityTransaction entityTransactionTransaction;
    private StringedInstrumentDaoImpl instrumentDao;

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.error("Test failed: {}", description, e);
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("Test successes: {}", description);
        }
    };

    @Before
    public void setUp() {
        entityManagerManager = mock(EntityManager.class);
        entityTransactionTransaction = mock(EntityTransaction.class);
        instrumentDao = new StringedInstrumentDaoImpl(entityManagerManager);
    }

    @Test
    public void whenFindInstrumentById() {
        Long expectedId = 10L;
        StringedInstrument instrument = new StringedInstrument(expectedId);

        when(entityManagerManager.find(StringedInstrument.class, expectedId)).thenReturn(instrument);

        logger.info("FirstObject  {}", instrument);
        logger.info("SecondObject  {}", instrumentDao.find(expectedId));

        assertEquals(instrument, instrumentDao.find(expectedId));
    }

    @Test
    public void whenSaveInstrumentToDatabase() {
        Long expectedId = 10L;
        StringedInstrument instrument = new StringedInstrument(expectedId);

        when(entityManagerManager.getTransaction()).thenReturn(entityTransactionTransaction);

        assertNotNull(instrumentDao.save(instrument));
        assertEquals(expectedId, instrumentDao.save(instrument).getId());
    }
}