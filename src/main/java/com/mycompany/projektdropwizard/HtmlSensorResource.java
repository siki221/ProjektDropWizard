package com.mycompany.projektdropwizard;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Resource trieda pre zobrazenie dat od konkretneho senzora v zariadeni
 * RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})

@Path("/sensor")
@Produces(MediaType.TEXT_HTML)
public class HtmlSensorResource {

    /**
     * Obsluha GET html poziadavky pre /sensor/zariadenie/senzor
     *
     * @param device zariadenie
     * @param sensor senzor
     * @return
     */
    @Path("/{device}/{sensor}")
    @GET
    public SensorView getSensor(@PathParam("device") String device, @PathParam("sensor") String sensor) {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data where device is '" + device + "'" + " and info is '" + sensor + "'");
        List<Data> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new SensorView(list);
    }

}
