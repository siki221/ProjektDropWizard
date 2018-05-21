package com.mycompany.projektdropwizard;

import com.codahale.metrics.annotation.Timed;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Resource trieda pre link /user produce JSON
 *
 * @author Mato&Pato&Niko
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    /**
     * Stlpec username
     */
    private final String username;
    /**
     * Stlpec password
     */
    private final String password;
    /**
     * Stlpec id
     */
    private final AtomicLong counter;

    /**
     * Konstruktor
     *
     * @param username uzivatelske meno
     * @param password uzivatelske heslo
     */
    public UserResource(String username, String password) {
        this.username = username;
        this.password = password;
        this.counter = new AtomicLong();
    }

    /**
     * Obsluha poziadavky GET pre /user
     *
     * @param name
     * @return
     */
    @GET
    @Timed
    public List<User> sayUser(@QueryParam("name") Optional<String> name) {
        // final String value = String.format(name, name.orElse(defaultName));

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    /**
     * Obsliha poziadavky GET pre user/meno
     *
     * @param name
     * @return User
     */
    @GET
    @Path("/user/{name}")
    @Timed
    public User sayHello(@PathParam("name") String name) {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from User where username=" + "'" + name + "'");
        User uniqueResult = (User) query.uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }

        return uniqueResult;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User sayHello(User input) {
        Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public User deleteHello(User input){
         Session session = MyApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.delete(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }

}
