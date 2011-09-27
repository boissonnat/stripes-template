package org.alx.stripestemplate.persistence;

import org.alx.stripestemplate.util.MLogger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class HibernateStore {

    private static final MLogger logger = MLogger.getLogger(HibernateStore.class);

    private final SessionFactory sessionFactory;

    public HibernateStore(){
        logger.debug("Try to build the session factory");
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new AnnotationConfiguration();
            sessionFactory =  cfg.configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            logger.error("Initial SessionFactory creation failed. - " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Object load(Class clazz, Integer id){
        if (clazz == null && id == null){
            return null;
        }
        if (clazz == null){
            return null;
        }

        if (id == null){
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Session s = getSession();
        return s.get(clazz, id);
    }

    public List<Object> load(Class clazz){
        if (clazz == null){
            return null;
        }
        Session s = getSession();
        String hql = new StringBuilder().append("from ").append(clazz.getSimpleName()).append(" as o").toString();
        logger.info("try to execute Query : ["+ hql + "]");
        Query q = s.createQuery(hql);
        return q.list();
    }

    public Object findBy(Class clazz, String fieldName, String value) {
        if (clazz == null){
            return null;
        }
        Session s = getSession();
        String hql = new StringBuilder().append("from ").append(clazz.getSimpleName()).append(" as o").append(" where o.").append(fieldName).append(" = '").append(value).append("'").toString();
        logger.info("try to execute Query : ["+ hql + "]");
        Query q = s.createQuery(hql);

        return q.uniqueResult();
    }

    public Object save(Object obj) {
        if (obj==null) {
            return null;
        }
        getSession().saveOrUpdate(obj);
        return obj;
    }

    public Object delete(Object obj) {
        if (obj==null) {
            return null;
        }
        getSession().delete(obj);
        return obj;
    }

    public void close() {
        sessionFactory.close();
    }

}
