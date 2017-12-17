package com.example.ldecarvalho.nittei2018;

/**
 * Created by ldecarvalho on 12/8/17.
 */


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends ContentProvider {

//    public static final Uri CONTENT_URI=Uri.parse("content://com.example.ldecarvalho.nittei2018/");

    public final List<AtividadeEntity> readCsv(Context context) {

        AssetManager assetManager = context.getAssets();

        InputStream csvStream = null;
        try {
            csvStream = assetManager.open("nittei.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
        CSVReader csvReader = new CSVReader(csvStreamReader);


        return csvReader.getAtividadeEntityList(csvStreamReader);


    }

    public CSVReader(InputStreamReader csvStreamReader) {
        // getAtividadeEntityList();
    }

    public CSVReader() {
        // getAtividadeEntityList();
    }


    public static List<AtividadeEntity> getAtividadeEntityList(InputStreamReader csvStreamReader) {
        List<AtividadeEntity> atividadeEntityList = new ArrayList<AtividadeEntity>();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM");
        String cvsSplitBy = ",";
        BufferedReader reader = new BufferedReader(csvStreamReader);
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                // use comma as separator
                String[] activity;
                activity = csvLine.split(cvsSplitBy);
                AtividadeEntity atividadeEntity = new AtividadeEntity();

                atividadeEntity = populateAtividade(df, newFormat, activity, atividadeEntity);
                atividadeEntityList.add(atividadeEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return atividadeEntityList;
    }

    private static AtividadeEntity populateAtividade(DateFormat df, SimpleDateFormat newFormat, String[] activity, AtividadeEntity atividadeEntity) {
        atividadeEntity.setSubject(activity[0]);
        try {
            try {
                if (activity[1] != null && activity[1] != "") {
                    atividadeEntity.setStartDate(newFormat.format(df.parse(activity[1])));
                }
                atividadeEntity.setStartTime(activity[2]);
                if (activity[3] != null && activity[3] != "") {
                    atividadeEntity.setEndDate(newFormat.format(df.parse(activity[3])));
                }
            } catch (ParseException e) {
                //e.printStackTrace();
            }

            atividadeEntity.setEndTime(activity[4] != null ? activity[4] : "");
            atividadeEntity.setAllDayEvent(activity[5] != null ? activity[5] : "");
            atividadeEntity.setDescription(activity[6] != null ? activity[6] : "");
            atividadeEntity.setLocation(activity[7] != null ? activity[7] : "");
            atividadeEntity.setPrivateEvent(activity[8] != null ? activity[8] : "");
            atividadeEntity.setDivision(activity[9] != null ? activity[9] : "");
            atividadeEntity.setGroup(activity[10] != null ? activity[10] : "");
            atividadeEntity.setLevel(activity[11] != null ? activity[11] : "");
            atividadeEntity.setOrganization(activity[12] != null ? activity[12] : "");
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return atividadeEntity;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
