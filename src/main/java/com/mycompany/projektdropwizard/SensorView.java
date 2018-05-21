package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 * View pre konkretny senzor na zariadeni
 *
 * @author Mato&Pato&Niko
 */
public class SensorView extends View {

    /**
     * List dat pre senzor
     */
    private List<Data> datas = new ArrayList<>();

    /**
     * Konstruktor
     *
     * @param datas
     */
    public SensorView(List<Data> datas) {
        super("sensor.ftl");
        this.datas = datas;
    }

    /**
     *
     * @return list dat pre senzor na zariadeni
     */
    public List<Data> getDatas() {
        return datas;
    }

}
