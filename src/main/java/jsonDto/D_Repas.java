package jsonDto;

import metier.Boisson;
import metier.Plat;
import metier.Repas;
import metier.TypeRepas;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class D_Repas extends Document {
    public D_Repas(Repas repas) {
        List<D_Boisson> boissonsDocument = new ArrayList<>();
        List<D_Plat> platsDocument = new ArrayList<>();

        for (Boisson boisson : repas.getBoissons()) {
            boissonsDocument.add(new D_Boisson(boisson));
        }

        for (Plat plat : repas.getPlats()) {
            platsDocument.add(new D_Plat(plat));
        }

        this.append("_id", repas.getId())
                .append("date", repas.getDate())
                .append("typeRepas", new D_TypeRepas(repas.getTypeRepas()))
                .append("plats", platsDocument)
                .append("boissons", boissonsDocument);
    }

    public D_Repas(Document document) {
        List<Plat> plats = new ArrayList<>();
        List<Boisson> boissons = new ArrayList<>();

        List<Document> platsDocument = (List<Document>) document.get("plats");
        List<Document> boissonsDocument = (List<Document>) document.get("boissons");

        for (Document platDocument : platsDocument) {
            plats.add(new D_Plat(platDocument).getMetier());
        }

        for (Document boissonDocument : boissonsDocument) {
            boissons.add(new D_Boisson(boissonDocument).getMetier());
        }

        this.append("_id", document.getString("_id"))
                .append("date", document.getDate("date"))
                .append("typeRepas", new D_TypeRepas((Document) document.get("typeRepas")).getMetier())
                .append("plats", plats)
                .append("boissons", boissons);
    }

    public Repas getMetier() {
        return new Repas(
                this.getString("_id"),
                new D_TypeRepas((Document) this.get("typeRepas")).getMetier(),
                this.getDate("date"),
                new ArrayList<>((List<Plat>) this.get("plats")),
                new ArrayList<>((List<Boisson>) this.get("boissons"))
        );
    }
}
