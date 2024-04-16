package jsonDto;

import metier.Boisson;
import org.bson.Document;

public class D_Boisson extends Document {
    public D_Boisson(Boisson boisson) {
        this.append("_id", boisson.getId())
                .append("lib", boisson.getLib());
    }

    public D_Boisson(Document document) {
        this.append("_id", document.getString("_id"))
                .append("lib", document.getString("lib"));
    }

    public Boisson getMetier() {
        return new Boisson(
                this.getString("_id"),
                this.getString("lib")
        );
    }
}
