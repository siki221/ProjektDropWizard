package com.mycompany.projektdropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.Principal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Trieda reprezentujuca tabulku user v databaze
 *
 * @author Mato&Pato&Niko
 */
@Entity
public class User implements Principal {

    /**
     * Generovane ID
     */
    @Id
    @GeneratedValue
    private long id;
    /**
     * Uzivatelske meno
     */
    private String name;
    /**
     * Uzivatelske heslo
     */
    private String password;
    /**
     * Uzivatelske prava
     */
    private String role;

    /**
     * Defaultny konstruktor
     */
    public User() {

    }

    /**
     * Konstruktor
     *
     * @param username uzivatelske meno
     * @param password uzivatelske heslo
     * @param role uzivatelske prava
     */
    public User(String username, String password, String role) {
        this.name = username;
        this.password = password;
        this.role = role;
    }

    /**
     * @return parameter name
     */
    @JsonProperty
    public String getName() {
        return this.name;
    }

    /**
     * @return parameter password
     */
    @JsonProperty
    public String getPassword() {
        return this.password;
    }

    /**
     * @return parameter id
     */
    @JsonProperty
    public long getId() {
        return this.id;
    }

    /**
     * @return parameter role
     */
    @JsonProperty
    public String getRole() {
        return this.role;
    }
}
