package jsonDto;

import metier.TypeRepas;
import org.bson.Document;

public class D_TypeRepas extends Document {

    public D_TypeRepas(TypeRepas typeRepas) {
        this.append("_id", typeRepas.getId())
                .append("lib", typeRepas.getLib());
    }

    public D_TypeRepas(Document document) {
        this.append("_id", document.getString("_id"))
                .append("lib", document.getString("lib"));
    }

    public TypeRepas getMetier() {
        return new TypeRepas(
                this.getString("_id"),
                this.getString("lib")
        );
    }
}
