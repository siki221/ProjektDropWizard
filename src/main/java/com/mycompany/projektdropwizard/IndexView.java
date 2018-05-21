package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;

/**
 * View pre zobrazenie uvodnej stranky
 *
 * @author Mato&Pato&Niko
 */
public class IndexView extends View {

    /**
     * Konstruktor
     */
    public IndexView() {
        super("index.ftl");
    }

}
