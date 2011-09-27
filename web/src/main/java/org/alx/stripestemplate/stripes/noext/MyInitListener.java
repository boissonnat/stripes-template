package org.alx.stripestemplate.stripes.noext;

import org.alx.stripestemplate.persistence.HibernateStore;
import org.hibernate.Transaction;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
public class MyInitListener implements ServletContextListener {

  public static final String CTX_STORE_KEY = "store";

  private ServletContext servletContext;

  public ServletContext getServletContext() {
    return servletContext;
  }

  public void contextInitialized(ServletContextEvent e) {
    servletContext = e.getServletContext();
    HibernateStore store =  new HibernateStore();
    servletContext.setAttribute(CTX_STORE_KEY, store);

    /*****************************************/
    /** Init database with users and groups **/
    /*****************************************/
    // Create and init a transaction
    Transaction tx = store.getSessionFactory().getCurrentSession().beginTransaction();


    // Create Groups
//    UserGroup userGroup = new UserGroup([name:'userGroup'])
//    UserGroup adminGroup = new UserGroup([name:'adminGroup'])

    // Helper : create list with group
//    UserGroup[] userGroupList = [userGroup]
//    UserGroup[] adminGroupList = [adminGroup]

    // Save the groups
//    store.save(userGroup)
//    store.save(adminGroup)

    // Create some users with group
//    User admin = new User([userName:'admin', password:'admin', email:'admin@fiemser.eu', groups:userGroupList])
//    User user = new User([userName:'user', password:'user', email:'user@fiemser.eu', groups:adminGroupList])

    // Save users
//    store.save(admin)
//    store.save(user)

    tx.commit();

  }

  public void contextDestroyed(ServletContextEvent e) {
    HibernateStore store = (HibernateStore)e.getServletContext().getAttribute(CTX_STORE_KEY);
    store.close();
  }


}
