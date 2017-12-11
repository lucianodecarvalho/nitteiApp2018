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
import java.text.ParseException;
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
            br.append("Gongyo de Ano Novo (Comem. 90º aniv. Pres. Ikeda) 10h - CCDI (c/ convite) + CC/SR ,01/01/2018,10:00:00 AM,,,,,Sede Regional Vila Prudente,,5D,,Todos,RM Vila Prudente,");
            br.append("\\\n");
            br.append("(Período de Recesso de Atividades),01/01/2018,,01/07/2018,,'TRUE',,,,,,,");
            br.append("\\\n");
            br.append("Resp. Comunidade acima – matéria do Grupo Coração das Mulheres Soka– 19 h -Neves Kaikan,01/10/2018,07:00:00 PM,,,,,Neves Kaikan,,DF,,Comunidade,RM Vila Prudente,");
            br.append("\\\n");
            br.append("Conselho líderes RM + Sub (RM's Vila Ema e Vila Prudente) - 19h30 as 20h30 - KK Vila Prudente,01/11/2018,07:30:00 PM,,08:30:00 PM,,,Sede Regional Vila Prudente,,5D,,RM,Sub,");
            br.append("\\\n");
            br.append("DAIMOKU TOSSU DOS LÍDERES DA REGIONAL INDUSTRIAL - 19:00,01/12/2018,07:00:00 PM,,,,Somente para LíFderes de Regional,Manoel Kaikan,,5D,,Regional,Regional,");
            br.append("\\\n");
            br.append("Reunião de Líderes de Comunidade e acima da CCLP - 15hs - CCDI,01/14/2018,03:00:00 PM,,,,,CCDI,,5D,,Comunidade,CCLP,");
            br.append("\\\n");
            br.append("Mamorukai Educacional,01/15/2018,,,,,,Educacional,,DF,Mamorukai,,BSGI,");
            br.append("\\\n");
            br.append("Diálogo com Tikutans – 19:00 – Manoel Kaikan (Regional Industrial),01/15/2018,07:00:00 PM,,,,,Manoel Kaikan,,DF,,Comunidade,Regional Industrial,");
            br.append("\\\n");
            br.append("Reunião de Líderes Regional e Acima de Organização +Grupo Alvorada + Ohjokai + Campestre - Sede regional 19 horas.,01/15/2018,07:00:00 PM,,,,,Sede Regional Vila Prudente,,DS,,Regional,RM Vila Prudente,");
            br.append("\\\n");
            br.append("(Aula 1)  -  Curso de Capacitação para Líderes de RM da CCLP (Por inscrição) 19hs (Sala Fukuchi/ CCDI),01/16/2017,07:00:00 PM,,,,,Sala Fukuchi/ CCDI,,DS DF,,RM,CCLP,");
            br.append("\\\n");
            br.append("Reunião das comissões  para a Convenção Cultural da Regional Industrial,01/16/2018,07:00:00 PM,,,,,Manoel Kaikan,,5D,Comissões,,Regional,");
            br.append("\\\n");
            br.append("Diálogo líderes RM + Sub - 19h - KK Sonoda,01/17/2018,07:00:00 PM,,,,,Sonoda Kaikan,,DF,,RM,Sub,");
            br.append("\\\n");
            br.append("(Aula 2)  -  Curso de Capacitação para Líderes de RM da CCLP (Por inscrição) 19hs (Sala Fukuchi/ CCDI),01/18/2018,07:00:00 PM,,,,,Sala Fukuchi/ CCDI,,DS DF,,RM,CCLP,");
            br.append("\\\n");
            br.append("Mamorukai Josho,01/18/2018,07:00:00 PM,,,,,Josho,,DF,Mamorukai,,BSGI,");
            br.append("\\\n");
            br.append("Reunião de Líderes de Sub - 19h - Seinenkaikan,01/18/2018,07:00:00 PM,,,,,Seinenkaikan,,DMJ,,Sub,BSGI,");
            br.append("\\\n");
            br.append("HOMBUTYOKAI DA REGIONAL INDUSTRIAL - 19:00,01/19/2018,07:00:00 PM,,,,,Manoel Kaikan,,5D,,Regional,Regional,");
            br.append("\\\n");
            br.append("Diálogo líderes RM + Sub - 15h - local a confirmar,01/20/2018,03:00:00 PM,,,,,,,DFJ,,RM,Sub,");
            br.append("\\\n");
            br.append("DIA DO SUCESSOR IKEDA – POR LOCALIDADE,01/20/2018,,,,TRUE,,,,DE,,Todos,por Localidade,");
            br.append("\\\n");
            br.append("(DUNI) ENCONTRO DAS JOVENS ÁGUIAS – POR LOCALIDADE,01/20/2018,,,,,,,,DJ,DUNI,Todos,por Localidade,");
            br.append("\\\n");
            br.append("8a Academia dos Sucessores Ikeda 2030 da CGESP - representantes - CCCamp,01/20/2018,,,,TRUE,,,,DE,,Representantes,CGESP,");
            br.append("\\\n");
            br.append("8a Academia dos Sucessores Ikeda 2030 da CGESP - representantes - CCCamp,01/21/2018,,,,TRUE,,,,DE,,Representantes,CGESP,");
            br.append("\\\n");
            br.append("ACADEMIVIA DO GRUPO ALVORADA por Regional – Movimento de Visitas – 9:00 – Manoel Kaikan,01/21/2018,07:00:00 PM,,,TRUE,,,,DS,,,,");
            br.append("\\\n");
            br.append("REUNIÃO EM LINGUA JAPONESA - 13:45 HS - AUDITORIO MONARCA - CCDI,01/21/2018,07:00:00 PM,,,,,,,,,,,");
            br.append("\\\n");
            br.append("(DS - DF) (Aula 3)  -  Curso de Capacitação para Líderes de RM da CCLP  (9hs ás 12hs)  (Por inscrição) Salas Fukuchi Kossen 1 2 e 3,01/21/2018,09:00:00 AM,,12:00:00 AM,,,Sala Fukuchi/ CCDI,,DS DF,,RM,CCLP,");
            br.append("\\\n");
            br.append("DIA DOS GRUPOS HORIZONTAIS,01/21/2018,,,,TRUE,,,,5D,,Todos,,");
            br.append("\\\n");
            br.append("Reunião de expladores de comunidade – 19:00 – Manoel Kaikan (Regional Industrial),01/22/2018,07:00:00 PM,,,,,Manoel Kaikan,,5D,,Comunidade,Regional,");
            br.append("\\\n");
            br.append("(semana da organização de base),01/22/2018,,01/28/2018,,TRUE,,,,,,,,");
            br.append("\\\n");
            br.append("(Feriado - Cidade de São Paulo),01/25/2018,07:00:00 PM,,,TRUE,,,,,,,,");
            br.append("\\\n");
            br.append("Gongyo Comem. 43º aniv. fundação SGI-19h/Aud.Paz c/convite + CC/SR,01/26/2018,07:00:00 PM,,,,,por Localidade,,5D,,Todos,Distrito,");
            br.append("\\\n");
            br.append("(DEB) Curso Avançado do Budismo - para Grau de Professor Adjunto + Professor Adjunto e Líderes da DJ de RM/RE e acima - 14h às 17h - CCDI,01/27/2018,02:00:00 PM,,05:00:00 PM,,,,,5D,DEB,RM,,");
            br.append("\\\n");
            br.append("Líderes do Grupo Alvorada de Sub e RM da CCLP  (19h) Sala Fukuchi/CCDI,01/29/2018,07:00:00 PM,,,,,Sala Fukuchi/ CCDI,,DS,Alvorada,RM,CCLP,");
            br.append("\\\n");
            br.append("(DS - DF) (Aula 1)  -  Curso de Capacitação para Líderes de RM da CCLP (Por inscrição) 19hs (Sala Fukuchi/ CCDI) ,01/30/2018,07:00:00 PM,,,,,Sala Fukuchi/ CCDI,,DS DF,,RM,CCLP,");
            br.append("\\\n");
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
            String[] lines = br.toString().split("\\n");
            for(String line: lines){

                // use comma as separator
                String[] activity = line.split(cvsSplitBy);
                AtividadeEntity atividadeEntity = new AtividadeEntity();

                atividadeEntity.setSubject(activity[0]);
                try {
                    if (activity[1]!=null && activity[1] != ""){
                        atividadeEntity.setStartDate(newFormat.format(df.parse(activity[1])));
                    }
                    atividadeEntity.setStartTime(activity[2]);
                    if (activity[3]!=null && activity[3] != "") {
                        atividadeEntity.setEndDate(newFormat.format(df.parse(activity[3])));
                    }
                } catch (ParseException e) {
                    //e.printStackTrace();
                }
                atividadeEntity.setEndTime(activity[4]);
                atividadeEntity.setAllDayEvent(activity[5]);
                atividadeEntity.setDescription(activity[6]);
                atividadeEntity.setLocation(activity[7]);
                atividadeEntity.setPrivateEvent(activity[8]);
                atividadeEntity.setDivision(activity[9]);
                atividadeEntity.setLevel(activity[10]);
            //    atividadeEntity.setOrganization(activity[11]);
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
