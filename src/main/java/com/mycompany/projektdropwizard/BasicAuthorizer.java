package com.mycompany.projektdropwizard;

/**
 *
 * @author Mato&Pato&Niko
 */
import io.dropwizard.auth.Authorizer;

/**
 * Trieda basic auhtorizer. Overenie role
 *
 * @author Jano
 */
public class BasicAuthorizer implements Authorizer<User> {

    /**
     *
     * @param user user
     * @param role role
     * @return
     */
    @Override
    public boolean authorize(User user, String role) {
        return user.getRole() != null && user.getRole().contains(role);
    }
}