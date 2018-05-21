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
 * Resource trieda pre zobrazenie zoznamu zariadeni /device RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})

@Path("/devices")
@Produces(MediaType.TEXT_HTML)
public class HtmlDeviceResource {

    /**
     * Obsluha poziadavky GET html pre /devices
     *
     * @return DeviceView pre vsetky zariadenia
     */
    @GET
    public DeviceView getIndex() {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Device");
        List<Device> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new DeviceView(list);
    }

}
