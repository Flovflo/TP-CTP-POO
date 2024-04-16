package metier;

import java.util.Date;

public class Symptome {
    private final String id;
    private Date date;
    private String description;
    private Integer duree;
    private boolean heureSaisie;

    public Symptome(String id, Date date, String description, Integer duree, boolean heureSaisie) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.duree = duree;
        this.heureSaisie = heureSaisie;
    }

    public Symptome(Date date, String description, Integer duree, boolean heureSaisie) {
        this.id = null;
        this.date = date;
        this.description = description;
        this.duree = duree;
        this.heureSaisie = heureSaisie;
    }

    public Symptome(String id, Date date, String description, boolean heureSaisie) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.duree = null;
        this.heureSaisie = heureSaisie;
    }

    public Symptome(Date date, String description, boolean heureSaisie) {
        this.id = null;
        this.date = date;
        this.description = description;
        this.duree = null;
        this.heureSaisie = heureSaisie;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public boolean isHeureSaisie() {
        return heureSaisie;
    }

    public void setHeureSaisie(boolean heureSaisie) {
        this.heureSaisie = heureSaisie;
    }

    @Override
    public String toString() {
        return "Symptome{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", duree=" + duree +
                ", heureSaisie=" + heureSaisie +
                '}';
    }
}
