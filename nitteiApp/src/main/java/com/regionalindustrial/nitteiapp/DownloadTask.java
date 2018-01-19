package com.regionalindustrial.nitteiapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.PowerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

// usually, subclasses of AsyncTask are declared inside the activity class.
// that way, you can easily modify the UI thread from here
public class DownloadTask extends AsyncTask<String, Integer, String> {

    private Context context;
    private PowerManager.WakeLock mWakeLock;

    public DownloadTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... sUrl) {
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            // expect HTTP 200 OK, so we don't mistakenly save error report
            // instead of the file
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }
            connection.setConnectTimeout(60000);
            // this will be useful to display download percentage
            // might be -1: server did not report the length
            int fileLength = connection.getContentLength();

            // download the file
            input = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String csvLine;

            MyProperties.getInstance().setCsvStream(in);
            CSVReader csvReader = new CSVReader(in);
            List<AtividadeEntity> atividadeEntityList = csvReader.getAtividadeEntityList(in);

            MyProperties.getInstance().setAtividadeEntityList(atividadeEntityList);

            if (MyProperties.getInstance().getAtividadeEntityList() == null){
                readFromFile(context);

            }

        } catch (Exception e) {
            e.printStackTrace();
            readFromFile(context);
            return e.toString();
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
        }
        return null;
    }

    private void readFromFile(Context context) {
        AssetManager assetManager = context.getAssets();

        InputStream csvStream = null;

        try {
            csvStream = assetManager.open("nittei.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
        CSVReader csvReader2 = new CSVReader(csvStreamReader);

        MyProperties.getInstance().setAtividadeEntityList(csvReader2.getAtividadeEntityList(csvStreamReader));
    }
}