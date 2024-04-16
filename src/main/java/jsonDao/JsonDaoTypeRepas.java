package jsonDao;

import com.mongodb.client.MongoCollection;
import dao.DaoTypeRepas;
import jsonDto.D_TypeRepas;
import metier.TypeRepas;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class JsonDaoTypeRepas extends JsonDao<D_TypeRepas> implements DaoTypeRepas {
    @Override
    public TypeRepas find(String id) {
        MongoCollection<Document> collection = this.getCollection();
        Document filter = new Document("_id", id);

        D_TypeRepas documentTypeRepas = new D_TypeRepas(collection.find(filter).first());
        if (documentTypeRepas == null) {
            return null;
        }
        return documentTypeRepas.getMetier();
    }

    @Override
    public List<TypeRepas> findAll() {
        MongoCollection<Document> collection = this.getCollection();
        List<TypeRepas> typeRepas = new ArrayList<>();
        for (Document document : collection.find()) {
            typeRepas.add(new D_TypeRepas(document).getMetier());
        }
        return typeRepas;
    }

    @Override
    public boolean deleteAll() {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteMany(new Document());
        return true;
    }

    @Override
    public TypeRepas create(TypeRepas obj) {
        MongoCollection<Document> collection = this.getCollection();

        D_TypeRepas documentTypeRepas = new D_TypeRepas(obj);
        collection.insertOne(documentTypeRepas);
        return documentTypeRepas.getMetier();
    }

    @Override
    public TypeRepas find(Class<TypeRepas> c, String id) {
        return this.find(id);
    }

    @Override
    public List<TypeRepas> findAll(Class<TypeRepas> c) {
        return this.findAll();
    }

    @Override
    public TypeRepas update(TypeRepas obj) {
        MongoCollection<Document> collection = this.getCollection();
        D_TypeRepas documentTypeRepas = new D_TypeRepas(obj);
        collection.replaceOne(new Document("_id", obj.getId()), documentTypeRepas);
        return documentTypeRepas.getMetier();
    }

    @Override
    public boolean delete(TypeRepas obj) {
        MongoCollection<Document> collection = this.getCollection();
        collection.deleteOne(new Document("_id", obj.getId()));
        return true;
    }

    @Override
    public boolean deleteAll(Class<TypeRepas> c) {
        return this.deleteAll();
    }

    private MongoCollection<Document> getCollection() {
        return this.database.getCollection("typeRepas");
    }

    private JsonDaoTypeRepas() {
        super();
    }

    private static JsonDaoTypeRepas instance;
    public static JsonDaoTypeRepas getInstance() {
        if (instance == null) {
            instance = new JsonDaoTypeRepas();
        }
        return instance;
    }
}
