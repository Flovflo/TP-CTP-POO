package jsonDao;

import com.mongodb.client.MongoCollection;
import dao.DaoSymptome;
import jsonDto.D_Symptome;
import metier.Symptome;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonDaoSymptome extends JsonDao<D_Symptome> implements DaoSymptome {
    @Override
    public Symptome find(String id) {
        MongoCollection<Document> collection = this.getCollection();
        Document filter = new Document("_id", id);

        D_Symptome documentSymptome = new D_Symptome(collection.find(filter).first());
        if (documentSymptome == null) {
            return null;
        }
        return documentSymptome.getMetier();
    }

    @Override
    public List<Symptome> findAll() {
        MongoCollection<Document> collection = this.getCollection();
        List<Symptome> symptomes = new ArrayList<>();
        for (Document document : collection.find()) {
            symptomes.add(new D_Symptome(document).getMetier());
        }
        return symptomes;
    }

    @Override
    public boolean deleteAll() {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(new Document());
        return true;
    }

    @Override
    public Symptome create(Symptome obj) {
        MongoCollection<Document> collection = this.getCollection();

        D_Symptome documentSymptome = new D_Symptome(obj);
        // Affecte un uuid random à l'objet
        UUID uuid = UUID.randomUUID();
        documentSymptome.put("_id", uuid.toString());

        collection.insertOne(documentSymptome);
        return documentSymptome.getMetier();
    }

    @Override
    public Symptome find(Class<Symptome> c, String id) {
        return this.find(id);
    }

    @Override
    public List<Symptome> findAll(Class<Symptome> c) {
        return this.findAll();
    }

    @Override
    public Symptome update(Symptome obj) {
        MongoCollection<Document> collection = this.getCollection();
        D_Symptome documentSymptome = new D_Symptome(obj);
        collection.replaceOne(new Document("_id", obj.getId()), documentSymptome);
        return documentSymptome.getMetier();
    }

    @Override
    public boolean delete(Symptome obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteOne(new Document("_id", obj.getId()));
        return true;
    }

    @Override
    public boolean deleteAll(Class<Symptome> c) {
        return this.deleteAll();
    }

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("symptome");
    }

    private JsonDaoSymptome() {
        super();
    }

    private static JsonDaoSymptome instance;
    public static JsonDaoSymptome getInstance() {
        if (instance == null) {
            instance = new JsonDaoSymptome();
        }
        return instance;
    }
}
