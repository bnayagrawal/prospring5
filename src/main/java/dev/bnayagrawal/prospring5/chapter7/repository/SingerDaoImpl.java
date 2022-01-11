package dev.bnayagrawal.prospring5.chapter7.repository;

import dev.bnayagrawal.prospring5.chapter7.entity.Singer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

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
    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbums() {
        return sessionFactory.getCurrentSession().getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Override
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession()
                .getNamedQuery("Singer.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    @Override
    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer delete with id: " + singer.getId());
    }
}
