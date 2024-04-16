package jsonDto;

import org.bson.Document;
import metier.Plat;

public class D_Plat extends Document {
    public D_Plat(Plat plat) {
        this.append("_id", plat.getId())
                .append("lib", plat.getLib());
    }

    public D_Plat(Document document) {
        this.append("_id", document.getString("_id"))
                .append("lib", document.getString("lib"));
    }

    public Plat getMetier() {
        return new Plat(
                this.getString("_id"),
                this.getString("lib")
        );
    }
}
