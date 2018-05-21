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
 * Resource trieda pre link /data Produces JSON vystup
 *
 * @author Mato&Pato&Niko
 */
@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    /**
     * Parameter pre stlpec device
     */
    private final String device;
    /**
     * Parameter pre stlpec date
     */
    private final String date;
    /**
     * Parameter pre stlpec data
     */
    private final String data;
    /**
     * Parameter pre stlpec info
     */
    private final String info;
    /**
     * Parameter pre stlpec id
     */
    private final AtomicLong counter;

    /**
     * Konstruktor
     *
     * @param device stlpec device
     * @param date stlpec date
     * @param data stlpec data
     * @param info stlpec info
     */
    public DataResource(String device, String date, String data, String info) {
        this.device = device;
        this.date = date;
        this.data = data;
        this.info = info;
        this.counter = new AtomicLong();
    }

    /**
     * Obsluha poziadavky GET pre root /data
     *
     * @return list dat zo vsetkych zariadeni.
     */
    @GET
    @Timed
    public List<Data> sayDevice() {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data");
        List<Data> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    /**
     * Obsluha GET poziadavky na /data/zariadenie
     *
     * @param device pre ake zariadenie chceme data
     * @return List dat pre dane zariadenie.
     */
    @GET
    @Path("/{device}")
    @Timed
    public List<Data> sayHello(@PathParam("device") String device) {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Data where device is '" + device + "'");
        List<Data> uniqueResult = query.list();

        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }

        return uniqueResult;
    }

    /**
     * Obsluha poziadavky POST pre root /data Prijima JSON objekt
     *
     * @param input JSON
     * @return odpoved servera
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Data sayHello(Data input) {
        Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }

    /**
     * Obsluha poziadavky DELETE pre /data Prijima JSON objekt
     * @param input JSON
     * @return  odpoved servera
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Data deleteHello(Data input) {
        Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.delete(input);
        session.getTransaction().commit();
        session.close();
        return input;

    }
}