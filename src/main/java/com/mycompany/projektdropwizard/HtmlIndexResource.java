package com.mycompany.projektdropwizard;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Resource trieda pre uvodnu stranku / RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})
@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HtmlIndexResource {

    /**
     * Obsluha poziadavky GET html pre /
     *
     * @return IndexView
     */
    @GET
    public IndexView getIndex() {
        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        return new IndexView();
    }

}
