
package com.mycompany.projektdropwizard;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import java.util.Optional;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Trieda, v ktorej sa overuje spravnosti uzivatela a hesla
 *
 * @author Mato&Pato&Niko
 */
public class BasicAuth implements Authenticator<BasicCredentials, User> {

    /**
     * HashMap uzivatelov. HashMap je naplneny po zadani uzivatela a hesla a
     * naslednej poziadavke na server.
     */
    private HashMap<String, User> users = new HashMap<String, User>() {
    };
    /**
     *
     * @param credentials credetials
     * @return Optional
     * @throws AuthenticationException
     */
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {

        Session session = MyApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from User");
        /**
         * Naplnenie uzivatelov z databazy
         */
        List<User> userList = query.list();

        session.getTransaction().commit();
        session.close();

        for (int i = 0; i < userList.size(); i++) {
            /**
             * Pridanie uzivatela do HashMapy
             */
            users.put(userList.get(i).getName(), userList.get(i));
        }

        /**
         * Overenie spravnonosti zadaneho uzivatelskeho mena a hesla
         */
        if (users.containsKey(credentials.getUsername()) && users.get(credentials.getUsername()).getPassword().equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername(), users.get(credentials.getUsername()).getPassword(), users.get(credentials.getUsername()).getRole()));
        }
        return Optional.empty();
    }
}
