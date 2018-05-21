package com.mycompany.projektdropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Trieda reprezentujuca tabulku device v databaze
 *
 * @author Mato&Pato&Niko
 */
@Entity
public class Device {

    @Id
    @GeneratedValue
    /**
     * Generovane ID
     */
    private long id;

    /**
     * Nazov zariadenia
     */
    private String name;
    /**
     * IP zariadenia
     */
    private String ip;

    /**
     * Defaultny konstruktor
     */
    public Device() {

    }

    /**
     * Konstruktor
     *
     * @param id generovane id
     * @param name nazov zariadenia
     * @param ip ip zariadenia
     */
    public Device(long id, String name, String ip) {
        this.id = id;
        this.name = name;
        this.ip = ip;
    }

    /**
     * @return parameter id
     */
    @JsonProperty
    public long getId() {
        return this.id;
    }

    /**
     * @return parameter name
     */
    @JsonProperty
    public String getName() {
        return this.name;
    }

    /**
     * @return parameter ip
     */
    @JsonProperty
    public String getIp() {
        return this.ip;
    }

}
