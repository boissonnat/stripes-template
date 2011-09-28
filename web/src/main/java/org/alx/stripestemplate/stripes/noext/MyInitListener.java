package org.alx.stripestemplate.stripes.noext;

import org.alx.stripestemplate.model.Role;
import org.alx.stripestemplate.model.User;
import org.alx.stripestemplate.persistence.HibernateStore;
import org.alx.stripestemplate.util.AppConstants;
import org.hibernate.Transaction;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

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

        // Create Roles
        Role userRole = new Role();
        userRole.setName(AppConstants.ROLE_USER);

        Role adminRole = new Role();
        adminRole.setName(AppConstants.ROLE_ADMIN);


        // Helper : create list with role
        List<Role> userRoleList = new ArrayList<Role>();
        userRoleList.add(userRole);
        List<Role> adminRoleList = new ArrayList<Role>();
        adminRoleList.add(adminRole);

        // Save the groups
        store.save(userRole);
        store.save(adminRole);

        // Create some users with role
        User admin = new User();
        admin.setEmail("admin@admin.com");
        PasswordTypeConverter converter = new PasswordTypeConverter();
        admin.setPassword(converter.hash("admin"));
        admin.setRoles(adminRoleList);

        User user = new User();
        user.setEmail("user@user.com");
        user.setPassword(converter.hash("user"));
        user.setRoles(userRoleList);

        // Save users
        store.save(admin);
        store.save(user);

        tx.commit();

    }

    public void contextDestroyed(ServletContextEvent e) {
        HibernateStore store = (HibernateStore)e.getServletContext().getAttribute(CTX_STORE_KEY);
        store.close();
    }


}
