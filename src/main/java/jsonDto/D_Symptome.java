package jsonDto;

import metier.Symptome;
import org.bson.Document;

public class D_Symptome extends Document {

    public D_Symptome(Symptome symptome) {
        this.append("_id", symptome.getId())
                .append("date", symptome.getDate())
                .append("description", symptome.getDescription())
                .append("duree", symptome.getDuree())
                .append("heureSaisie", symptome.isHeureSaisie());
    }

    public D_Symptome(Document document) {
        this.append("_id", document.getString("_id"))
                .append("date", document.getDate("date"))
                .append("description", document.getString("description"))
                .append("duree", document.getInteger("duree"))
                .append("heureSaisie", document.getBoolean("heureSaisie"));
    }

    public Symptome getMetier() {
        return new Symptome(
                this.getString("_id"),
                this.getDate("date"),
                this.getString("description"),
                this.getInteger("duree"),
                this.getBoolean("heureSaisie")
        );
    }

}
