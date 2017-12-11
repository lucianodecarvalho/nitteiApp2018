package com.example.ldecarvalho.nittei2018.provider;

import com.example.ldecarvalho.nittei2018.AtividadeEntity;
import com.example.ldecarvalho.nittei2018.CVSReader;

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

    static {
        // Add some sample items.
        CVSReader cvsReader = new CVSReader();

        List<AtividadeEntity> atividadeEntityList = cvsReader.getAtividadeEntityList();

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
        builder.append("Divisão: ").append(atividadeEntity.getDivision());
        builder.append("\n");
        builder.append("Atividade: ").append(atividadeEntity.getSubject());
        builder.append("\n");
        builder.append("Data: ").append(atividadeEntity.getStartDate());
        builder.append("\n");
        builder.append("Início: ").append(atividadeEntity.getStartTime());
        builder.append("\n");
        builder.append("Término: ").append(atividadeEntity.getEndTime());
        builder.append("\n");
        builder.append("Data Final: ").append(atividadeEntity.getEndDate());
        builder.append("\n");
        builder.append("Local: ").append(atividadeEntity.getLocation());
        builder.append("\n");
        builder.append("Nível de participação: ").append(atividadeEntity.getLevel());
        builder.append("\n");
        builder.append("Realizado por: ").append(atividadeEntity.getOrganization());
        builder.append("\n");
        builder.append("Grupo: ").append(atividadeEntity.getGroup());
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
