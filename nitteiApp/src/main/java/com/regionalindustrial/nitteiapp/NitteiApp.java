package com.regionalindustrial.nitteiapp;

import android.app.Application;

import java.io.InputStream;

/**
 * Created by ldecarvalho on 1/10/18.
 */

public class NitteiApp extends Application {
    public InputStream getCsvStream() {
        return csvStream;
    }

    public void setCsvStream(InputStream csvStream) {
        this.csvStream = csvStream;
    }

    private InputStream csvStream;
}
