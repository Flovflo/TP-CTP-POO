package jsonDao;

import com.mongodb.client.MongoCollection;
import dao.DaoRepas;
import jsonDto.D_Repas;
import metier.Repas;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonDaoRepas extends JsonDao<Repas> implements DaoRepas {
    @Override
    public Repas find(String id) {
        MongoCollection<Document> collection = this.getCollection();
        Document filter = new Document("_id", id);

        D_Repas documentRepas = new D_Repas(collection.find(filter).first());
        if (documentRepas == null) {
            return null;
        }
        return documentRepas.getMetier();
    }

    @Override
    public List<Repas> findAll() {
        MongoCollection<Document> collection = this.getCollection();
        List<Repas> repas = new ArrayList<>();
        for (Document document : collection.find()) {
            repas.add(new D_Repas(document).getMetier());
        }
        return repas;
    }

    @Override
    public boolean deleteAll() {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(new Document());
        return true;
    }

    @Override
    public Repas create(Repas obj) {
        MongoCollection<Document> collection = this.getCollection();

        D_Repas documentRepas = new D_Repas(obj);

        // Affecte un uuid random à l'objet
        UUID uuid = UUID.randomUUID();
        documentRepas.put("_id", uuid.toString());

        // Affecte un uuid random pour chaque boisson
        List<Document> boissons = (List<Document>) documentRepas.get("boissons");
        for (Document boisson : boissons) {
            UUID uuidBoisson = UUID.randomUUID();
            boisson.put("_id", uuidBoisson.toString());
        }

        // Affecte un uuid random pour chaque plat
        List<Document> plats = (List<Document>) documentRepas.get("plats");
        for (Document plat : plats) {
            UUID uuidPlat = UUID.randomUUID();
            plat.put("_id", uuidPlat.toString());
        }

        // Affecte un uuid random pour le type de repas
        Document typeRepas = (Document) documentRepas.get("typeRepas");
        UUID uuidTypeRepas = UUID.randomUUID();
        typeRepas.put("_id", uuidTypeRepas.toString());

        collection.insertOne(documentRepas);

        // TODO: Ajouter le type de repas s'il n'existe pas déjà !

        return documentRepas.getMetier();
    }

    @Override
    public Repas find(Class<Repas> c, String id) {
        return this.find(id);
    }

    @Override
    public List<Repas> findAll(Class<Repas> c) {
        return this.findAll();
    }

    @Override
    public Repas update(Repas obj) {
        MongoCollection<Document> collection = this.getCollection();
        D_Repas documentRepas = new D_Repas(obj);
        collection.replaceOne(new Document("_id", obj.getId()), documentRepas);
        return documentRepas.getMetier();
    }

    @Override
    public boolean delete(Repas obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteOne(new Document("_id", obj.getId()));
        return true;
    }

    @Override
    public boolean deleteAll(Class<Repas> c) {
        return this.deleteAll();
    }

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("repas");
    }

    private JsonDaoRepas() {
        super();
    }

    private static JsonDaoRepas instance;
    public static JsonDaoRepas getInstance() {
        if (instance == null) {
            instance = new JsonDaoRepas();
        }
        return instance;
    }
}
