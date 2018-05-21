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
 * Resource trieda pre zobrazenie vsetkych dat. Link /data RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})

@Path("/data")
@Produces(MediaType.TEXT_HTML)
public class HtmlDataResource {

    /**
     * Obsluha GET html poziadavky
     *
     * @return DataAllView pre vsetky zariadenia
     */
    @GET
    public DataAllView getIndex() {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data");
        List<Data> list = query.list();
        session.getTransaction().commit();
        session.close();

        return new DataAllView(list);
    }

}
