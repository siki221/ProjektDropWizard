package com.mycompany.projektdropwizard;

import java.util.ArrayList;
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
 * Resource trieda pre data pre konkretne zariadenie /data/zariadenie
 * RolesAllowed - ADMIN
 *
 * @author Mato&Pato&Niko
 */
@RolesAllowed({"ADMIN"})
@Path("/data/{name}")
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    /**
     * Obsluha GET html poziadavjy pre /device/zariadenie
     *
     * @param name nazov zariadenia
     * @return DataView pre konkretne zariadenie, zoznam dat
     */
    @GET
    public DataView getData(@PathParam("name") String name) {
        ArrayList<String> sensors = new ArrayList<>();

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data where device=\'" + name + "\'");
        List<Data> list = query.list();

        for (int i = 0; i < list.size(); i++) {
            if (!sensors.contains(list.get(i).getInfo())) {
                sensors.add(list.get(i).getInfo());
            }
        }
        session.getTransaction().commit();
        session.close();

        return new DataView(list, sensors, name);
    }

}
