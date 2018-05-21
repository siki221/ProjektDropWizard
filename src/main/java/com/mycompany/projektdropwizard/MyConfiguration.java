package com.mycompany.projektdropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Trieda pociatocnej konfiguracie resources
 *
 * @author Mato&Pato&Niko
 */
public class MyConfiguration extends Configuration {

    /**
     * Zariadenie
     */
    @NotEmpty
    private String device;
    /**
     * Datum
     */
    @NotEmpty
    private String date;
    /**
     * Uzitocne data
     */
    @NotEmpty
    private String data;
    /**
     * Meno
     */
    @NotEmpty
    private String name;
    /**
     * IP
     */
    @NotEmpty
    private String ip = "127.0.0.1";

    /**
     *
     * @return parameter device
     */
    @JsonProperty
    public String getDevice() {
        return this.device;
    }

    /**
     * Set parameter device
     *
     * @param device
     */
    @JsonProperty
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     *
     * @return parameter device
     */
    @JsonProperty
    public String getDate() {
        return this.date;
    }

    @JsonProperty
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return parameter data
     */
    @JsonProperty
    public String getData() {
        return this.data;
    }

    /**
     * Set parameter data
     *
     * @param data
     */
    @JsonProperty
    public void setData(String data) {
        this.data = data;
    }

    /**
     *
     * @return parameter name
     */
    @JsonProperty
    public String getName() {
        return this.name;
    }

    /**
     * Set parameter name
     *
     * @param name
     */
    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return parameter ip
     */
    @JsonProperty
    public String getIP() {
        return this.ip;
    }

    /**
     * Set parameter ip
     *
     * @param ip
     */
    @JsonProperty
    public void setIP(String ip) {
        this.ip = ip;
    }

}
