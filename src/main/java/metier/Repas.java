package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repas {
    private final String id;
    private Date date;
    private TypeRepas typeRepas;
    private List<Plat> plats;
    private List<Boisson> boissons;

    public Repas(String id, TypeRepas typeRepas, Date date, List<Plat> plats, List<Boisson> boissons) {
        this.id = id;
        this.typeRepas = typeRepas;
        this.date = date;
        this.plats = List.copyOf(plats);
        this.boissons = List.copyOf(boissons);
    }

    public Repas(TypeRepas typeRepas, Date date, List<Plat> plats, List<Boisson> boissons) {
        this.id = null;
        this.date = date;
        this.typeRepas = typeRepas;
        this.plats = List.copyOf(plats);
        this.boissons = List.copyOf(boissons);
    }

    public Repas(TypeRepas typeRepas, Date date) {
        this.id = null;
        this.date = date;
        this.typeRepas = typeRepas;
        this.plats = new ArrayList<>();
        this.boissons = new ArrayList<>();
    }

    public Repas(String id, TypeRepas typeRepas, Date date) {
        this.id = id;
        this.typeRepas = typeRepas;
        this.date = date;
        this.plats = new ArrayList<>();
        this.boissons = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public TypeRepas getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(TypeRepas typeRepas) {
        this.typeRepas = typeRepas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Plat> getPlats() {
        return plats;
    }

    public void setPlats(List<Plat> plats) {
        this.plats = List.copyOf(plats);
    }

    public List<Boisson> getBoissons() {
        return boissons;
    }

    public void setBoissons(List<Boisson> boissons) {
        this.boissons = List.copyOf(boissons);
    }

    public void addPlat(Plat plat) {
        this.plats.add(plat);
    }

    public void addBoisson(Boisson boisson) {
        this.boissons.add(boisson);
    }

    @Override
    public String toString() {
        return "Repas{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", typeRepas=" + typeRepas +
                ", plats=" + plats +
                ", boissons=" + boissons +
                '}';
    }
}
