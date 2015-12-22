package by.khrapovitsky.dao;

import by.khrapovitsky.model.Archive;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ArchivesDAOImplement implements ArchivesDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Archive archive) {
        sessionFactory.getCurrentSession().save(archive);
    }

    public Archive getArchive(String name) {
        return (Archive) sessionFactory.getCurrentSession().get(Archive.class, name);
    }

    public List getAllArchives() {
        return sessionFactory.getCurrentSession().createCriteria(Archive.class).list();
    }

    public List getArchivesOfCurrentDay(Date fromDate,Date toDate) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Archive.class);
        criteria.add(Restrictions.ge("dateOfCreating",fromDate));
        criteria.add(Restrictions.le("dateOfCreating",toDate));
        return criteria.list();
    }
}
