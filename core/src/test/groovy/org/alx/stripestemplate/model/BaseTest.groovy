package org.alx.stripestemplate.model

import org.hibernate.Transaction
import org.hibernate.Session

import org.alx.stripestemplate.persistence.HibernateStore
import org.junit.Before

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
abstract class BaseTest {

    private HibernateStore store

    @Before
    public void setUp(){
        store = new HibernateStore()
    }

    /**
     * Encapsulate the default operation used to manipulate the Hibernate session.
     * Thanks to groovy to its powerful closure mechanism
     *
     * @param c a Groovy closure which basically interact with the DB.
     */
    protected void doInTx(Closure c) {
        Session s = store.getSession()
        Transaction tx = s.beginTransaction()
        println "Started tx $tx"
        try {
            c.call(store)
            println "Commiting  $tx"
            tx.commit()
        } catch(Throwable e) {
            println "Exception caught : $e, Roll-backing and rethrowing"
            tx.rollback()
            throw new RuntimeException("Exception within tx", e)
        }
    }
}
