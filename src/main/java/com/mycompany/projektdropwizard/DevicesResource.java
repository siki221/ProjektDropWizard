package com.mycompany.projektdropwizard;

import com.codahale.metrics.annotation.Timed;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Resource trieda pre link /devices Produces JSON
 *
 * @author Mato&Pato&Niko
 */
@Path("/device")
@Produces(MediaType.APPLICATION_JSON)
public class DevicesResource {

    /**
     * Stlpec name
     */
    private final String name;
    /**
     * Stlpec ip
     */
    private final String ip;

    /**
     * Stlpec id
     */
    private final AtomicLong counter;

    /**
     * Konstruktor
     *
     * @param name stlpec name
     * @param ip stlpec ip
     */
    public DevicesResource(String name, String ip) {
        this.name = name;
        this.ip = ip;
        this.counter = new AtomicLong();
    }

    /**
     * Obsluha poziadavky GET pre /device
     *
     * @return list zariadeni
     */
    @GET
    @Timed
    public List<Device> sayDevice() {
        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Device");
        List<Device> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    /**
     * Obsluha poziadavky GET pre /device/nazov -> Data pre konkretne zariadenie
     *
     * @param id nazov zariadenia
     * @return data pre konkretne zariadenie
     */
    @GET
    @Path("/{id}")
    @Timed
    public Data sayHello(@PathParam("id") String id) {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data where id=" + id);
        Data uniqueResult = (Data) query.uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }

        return uniqueResult;
    }

    /**
     * Obsluha poziadavky POST pre /device Prijima JSON
     *
     * @param input JSON
     * @return odpoved servera
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Device sayHello(Device input) {
        Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Device deleteHello(Device input) {
        Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.delete(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
}
