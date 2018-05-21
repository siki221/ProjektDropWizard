package com.mycompany.projektdropwizard;

import io.dropwizard.views.View;
import java.util.ArrayList;
import java.util.List;

/**
 * View pre vsetky dostupne data.
 * @author Mato&Pato&Niko
 */
public class DataAllView extends View{
    /**
     * List dat
     */
    private  List<Data> datas = new ArrayList<>();
    
    /**
     * Konstruktor
     * @param datas list dat 
     */
    public DataAllView(List<Data> datas){
        super("alldata.ftl");
        this.datas = datas;
    }
    /**
     * 
     * @return list dat 
     */
    public List<Data> getDatas(){
        return datas;
    }
}