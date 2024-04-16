package jsonDao;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public abstract class JsonDao<T> {
    protected MongoClient mongoClient;
    protected MongoDatabase database;

    protected JsonDao() {
        this.mongoClient = MongoClients.create(new ConnectionString("mongodb://ctp:ctp@localhost:27017"));
        this.database = mongoClient.getDatabase("test");
    }

    public void close() {
        this.mongoClient.close();
    }
}
