package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 * View trieda pre zobrazenie zoznamu uzivatelov
 *
 * @author Mato&Pato&Niko
 */
public class UserView extends View {

    /**
     * List uzivatelov
     */
    private List<User> users = new ArrayList<>();

    /**
     * Konstruktor
     *
     * @param datas list uzivatelov
     */
    public UserView(List<User> datas) {
        super("user.ftl");
        this.users = datas;
    }

    /**
     *
     * @return parameter users - list uzivatelov
     */
    public List<User> getUsers() {
        return users;
    }

}
