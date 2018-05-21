package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 * View pre zoznam zariadeni
 *
 * @author Mato&Pato&Niko
 */
public class DeviceView extends View {

    /**
     * List zariadeni
     */
    private List<Device> devices = new ArrayList<>();

    /**
     * Konstruktor
     *
     * @param devices list zariadeni
     */
    public DeviceView(List<Device> devices) {
        super("devices.ftl");
        this.devices = devices;
    }

    /**
     *
     * @return list zariadeni
     */
    public List<Device> getDevices() {
        return devices;
    }

}
