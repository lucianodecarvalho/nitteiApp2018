package com.regionalindustrial.nitteiapp;

import java.io.BufferedReader;
import java.util.List;

/**
 * Created by ldecarvalho on 1/10/18.
 */


public class MyProperties {
    private static MyProperties mInstance= null;

    protected MyProperties(){}

    public static synchronized MyProperties getInstance(){
        if(null == mInstance){
            mInstance = new MyProperties();
        }
        return mInstance;
    }

    public BufferedReader getCsvStream() {
        return csvStream;
    }

    public void setCsvStream(BufferedReader csvStream) {
        this.csvStream = csvStream;
    }

    private BufferedReader csvStream;

    public List<AtividadeEntity> getAtividadeEntityList() {
        return atividadeEntityList;
    }

    public void setAtividadeEntityList(List<AtividadeEntity> atividadeEntityList) {
        this.atividadeEntityList = atividadeEntityList;
    }

    private List<AtividadeEntity> atividadeEntityList;
}