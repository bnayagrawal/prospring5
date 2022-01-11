package dev.bnayagrawal.prospring5.chapter7.repository;

import dev.bnayagrawal.prospring5.chapter7.entity.Instrument;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl implements InstrumentDao {

    private static final Logger logger = Logger.getLogger(SingerDaoImpl.class.getName());

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Instrument save(Instrument instrument) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        return null;
    }
}
