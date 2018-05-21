package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 * View trieda pre data ku konkretnemu zariadeniu
 *
 * @author Mato&Pato&Niko
 */
public class DataView extends View {

    /**
     * List dat
     */
    private List<Data> datas = new ArrayList<>();
    /**
     * List senzorov pre dane zariadenie
     */
    private List<String> sensors = new ArrayList<>();
    /**
     * Nazov zariadenia
     */
    private String device;

    /**
     * Konstruktor
     *
     * @param datas list dat
     * @param sensors list senzorov
     * @param device nazov zariadenia
     */
    public DataView(List<Data> datas, ArrayList<String> sensors, String device) {
        super("data.ftl");
        this.datas = datas;
        this.sensors = sensors;
        this.device = device;
    }

    /**
     *
     * @return parameter datas
     */
    public List<Data> getDatas() {
        return datas;
    }

    /**
     *
     * @return parameter sensors
     */
    public List<String> getSensors() {
        return sensors;
    }

    /**
     *
     * @return parameter device
     */
    public String getDevice() {
        return device;
    }

}
