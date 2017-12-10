package com.example.ldecarvalho.nittei2018;

/**
 * Created by ldecarvalho on 12/8/17.
 */


import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CVSReader extends ContentProvider{

//    public static final Uri CONTENT_URI=Uri.parse("content://com.example.ldecarvalho.nittei2018/");


    public CVSReader() {
       // getAtividadeEntityList();
    }

    public static void main (String[] args){
        final List<AtividadeEntity> atividadeEntityList = getAtividadeEntityList();
    }
    public static List<AtividadeEntity>  getAtividadeEntityList() {
        StringBuilder   br = new StringBuilder();

        String cvsSplitBy = ",";
        List<AtividadeEntity> atividadeEntityList = new ArrayList<>();

        try {


            br.append("HERDEIROS 18 HORAS SEDE VP,09/02/2017,06:00:00 PM,,,,por RM,Sede Regional Vila Prudente,,DE,");
            br.append("\\\n");
            br.append("DUNI 18 HORAS SEDE VP,09/02/2017,06:00:00 PM,,,,por RM,Sede Regional Vila Prudente,,DE,");
            br.append("\\\n");
            br.append("Dia dos Sucessores Ikeda 2030,09/02/2017,,,,TRUE,,,,DE,");
            br.append("\\\n");
            br.append("CBB 10 Hs SR - SOBRE O GOHONZON,09/03/2017,10:00:00 AM,,,,por RM,Sede Regional Vila Prudente,,5D,");
            br.append("\\\n");
            br.append("DIA DOS GRUPOS HORIZONTAIS,09/03/2017,,,,TRUE,,,,DJ,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – Segundo Grau – 18:00 – Manoel Kaikan (POR REGIONAL),09/09/2017,06:00:00 PM,,,,Regional Industrial,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – Primeiro Grau – 19:00 – Manoel Kaikan (DISTRITO SETÚBAL),09/14/2017,07:00:00 PM,,,,Distrito Setúbal,Manoel Kaikan,,5D,");
            br.append("\\n");
            br.append("Estudo para Exame do Budismo – Admissao – REVISÃO GERAL – 15:00 – Manoel Kaikan (DISTRITO SETÚBAL),09/17/2017,03:00:00 PM,,,,Distrito Setúbal,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – Primeiro Grau – 19:00 – Manoel Kaikan (DISTRITO SETÚBAL),09/21/2017,07:00:00 PM,,,,Distrito Setúbal,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – Primeiro e Segundo Grau – REVISÃO GERAL – 18:00 – Manoel Kaikan (POR REGIONAL),09/23/2017,06:00:00 PM,,,,Regional Industrial,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Reuniões para Explanadores de Comunidade (pela regional),10/23/2017,07:00:00 PM,,,,Regional Industrial,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Reuniões para Explanadores de Comunidade (pela regional),13/11/2017,07:00:00 PM,,,,Regional Industrial,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Reuniões para Explanadores de Comunidade (pela regional),12/11/2017,07:00:00 PM,,,,Regional Industrial,Manoel Kaikan,,5D,");
            br.append("\\\n");
            br.append("Conselho de Distrito (shibutyokai Regional+Distrito),09/25/2017,07:00:00 PM,,,,Regional Industrial,À confirmar,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – ADMISSÃO – por comunidade,09/12/2017,07:00:00 PM,,,,Distrito Industrial,por Comunidade,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – PRIMEIRO GRAU – 19:00 – Casa da Gabi (DISTRITO INDUSTRIAL) - (Aberto para levar os convidados e recém-convertidos),09/14/2017,07:00:00 PM,,,,Distrito Industrial - (Aberto para levar os convidados e recém-convertidos),Casa da Gabi,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – ADMISSÃO – por comunidade,09/19/2017,07:00:00 PM,,,,Distrito Industrial,por Comunidade,,5D,");
            br.append("\\\n");
            br.append("Estudo para Exame do Budismo – PRIMEIRO GRAU – 19:00 – Casa da Gabi (DISTRITO INDUSTRIAL) - (Aberto para levar os convidados e recém-convertidos),09/21/2017,07:00:00 PM,,,,Distrito Industrial - (Aberto para levar os convidados e recém-convertidos),Casa da Gabi,,5D,");
            br.append("\\\n");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
            String[] lines = br.toString().split("\\n");
            for(String line: lines){

                // use comma as separator
                String[] activity = line.split(cvsSplitBy);
                AtividadeEntity atividadeEntity = new AtividadeEntity();

                atividadeEntity.setSubject(activity[0]);
                atividadeEntity.setStartDate(newFormat.format(df.parse(activity[1])));
                atividadeEntity.setStartTime(activity[2]);
                atividadeEntity.setEndDate(activity[3]);
                atividadeEntity.setEndTime(activity[4]);
                atividadeEntity.setAllDayEvent(activity[5]);
                atividadeEntity.setDescription(activity[6]);
                atividadeEntity.setLocation(activity[7]);
                atividadeEntity.setPrivateEvent(activity[8]);
                atividadeEntity.setDivision(activity[9]);
                atividadeEntityList.add(atividadeEntity);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return atividadeEntityList;
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
