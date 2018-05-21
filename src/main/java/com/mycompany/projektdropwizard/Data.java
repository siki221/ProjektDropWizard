
package com.mycompany.projektdropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Trieda reprezentujuca tabulku data v databaze.
 *
 * @author Mato&Pato&Niko
 */
@Entity
public class Data {

    @Id
    @GeneratedValue
    /**
     * Generovane ID
     */
    private long id;

    /**
     * Nazov zariadenia, ku ktoremu data patria.
     */
    private String device;
    /**
     * Casova informacia dat.
     */
    private String date;
    /**
     * Uzitocne data.
     */
    private String data;
    /**
     * Info ku datam - resp. nazov senzora, ktory ich nameral.
     */
    private String info;

    /**
     * Defaultny konstruktor
     */
    public Data() {

    }

    /**
     * Konstruktor
     *
     * @param id generovana hodnota
     * @param device zariadenie, ku ktoremu patria data
     * @param date casova informacia k datam
     * @param data uzitocne data
     * @param info info ku datam, resp. nazov senzora, ktory ich nameral
     */
    public Data(long id, String device, String date, String data, String info) {
        this.id = id;
        this.device = device;
        this.date = date;
        this.data = data;
        this.info = info;
    }
    /**
     *
     * @return parameter id
     */
    @JsonProperty
    public long getId() {
        return this.id;
    }

    /**
     * @return parameter device
     */
    @JsonProperty
    public String getDevice() {
        return this.device;
    }

    /**
     * @return parameter date
     */
    @JsonProperty
    public String getDate() {
        return this.date;
    }

    /**
     * @return parameter data
     */
    @JsonProperty
    public String getData() {
        return this.data;
    }

    /**
     * @return parameter info
     */
    @JsonProperty
    public String getInfo() {
        return this.info;
    }

}
