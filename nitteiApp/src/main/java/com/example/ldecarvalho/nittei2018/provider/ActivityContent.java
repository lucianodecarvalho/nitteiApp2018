package com.example.ldecarvalho.nittei2018.provider;

import android.content.Context;

import com.example.ldecarvalho.nittei2018.AtividadeEntity;
import com.example.ldecarvalho.nittei2018.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ActivityContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ActivityItem> ITEMS = new ArrayList<ActivityItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ActivityItem> ITEM_MAP = new HashMap<String, ActivityItem>();

    private static final int COUNT = 25;

    public ActivityContent(Context context) {
        // Add some sample items.
        if (ITEMS.size() == 0) {
            CSVReader cvsReader = new CSVReader();

            List<AtividadeEntity> atividadeEntityList = cvsReader.readCsv(context);

            for (AtividadeEntity atividadeEntity : atividadeEntityList) {
                addItem(createAtividadeItem(atividadeEntity));
            }
        }
    }

    static {
        // Add some sample items.
//        CSVReader cvsReader = new CSVReader();
//
//        List<AtividadeEntity> atividadeEntityList = cvsReader.getAtividadeEntityList();
//
//        for (AtividadeEntity atividadeEntity: atividadeEntityList) {
//            addItem(createAtividadeItem(atividadeEntity));
//        }
    }

    public ActivityContent(List<AtividadeEntity> atividadeEntityList) {
        for (AtividadeEntity atividadeEntity: atividadeEntityList) {
            addItem(createAtividadeItem(atividadeEntity));
        }
    }

    private static void addItem(ActivityItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ActivityItem createAtividadeItem(AtividadeEntity atividadeEntity) {
        return new ActivityItem(atividadeEntity.getStartDate(), "("+atividadeEntity.getDivision()+") "+atividadeEntity.getSubject(), makeDetails(atividadeEntity));
    }

    private static String makeDetails(AtividadeEntity atividadeEntity) {
        StringBuilder builder = new StringBuilder();
        builder.append("Divisão: ").append(atividadeEntity.getDivision() != null ? atividadeEntity.getDivision() : "");
        builder.append("\n");
        builder.append("Atividade: ").append(atividadeEntity.getSubject()!= null ? atividadeEntity.getSubject() : "");
        builder.append("\n");
        builder.append("Data: ").append(atividadeEntity.getStartDate()!= null ? atividadeEntity.getStartDate() : "");
        builder.append("\n");
        builder.append("Início: ").append(atividadeEntity.getStartTime()!= null ? atividadeEntity.getStartTime() : "");
        builder.append("\n");
        builder.append("Término: ").append(atividadeEntity.getEndTime()!= null ? atividadeEntity.getEndTime() : "");
        builder.append("\n");
        builder.append("Data Final: ").append(atividadeEntity.getEndDate()!= null ? atividadeEntity.getEndDate() : "");
        builder.append("\n");
        builder.append("Local: ").append(atividadeEntity.getLocation()!= null ? atividadeEntity.getLocation() : "");
        builder.append("\n");
        builder.append("Nível de participação: ").append(atividadeEntity.getLevel()!= null ? atividadeEntity.getLevel() : "");
        builder.append("\n");
        builder.append("Realizado por: ").append(atividadeEntity.getOrganization()!= null ? atividadeEntity.getOrganization() : "");
        builder.append("\n");
        builder.append("Grupo: ").append(atividadeEntity.getGroup()!= null ? atividadeEntity.getGroup() : "");
        builder.append("\n");

        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ActivityItem {
        public String getId() {
            return id;
        }

        public final String id;

        public String getContent() {
            return content;
        }

        public final String content;

        public String getDetails() {
            return details;
        }

        public final String details;

        public ActivityItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
