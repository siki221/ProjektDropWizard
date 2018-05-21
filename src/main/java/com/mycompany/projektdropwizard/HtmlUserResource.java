package com.mycompany.projektdropwizard;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Resource trieda pre zobrazenie zoznamu uzivatelov RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})
@Path("/user")
@Produces(MediaType.TEXT_HTML)
public class HtmlUserResource {

    /**
     * Obsluha poziadavky GET html pre /user
     *
     * @return UserView
     */
    @GET
    public UserView getIndex() {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new UserView(list);
    }

}
