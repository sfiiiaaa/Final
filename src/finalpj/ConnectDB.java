/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpj;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author DELL
 */
public class ConnectDB {
    
    static MongoClientURI uri;
    static MongoClient client;
    static MongoDatabase db;
    static MongoCollection collection;

    ConnectDB() {
       
        uri = new MongoClientURI("mongodb://final:A12345678@ds147723.mlab.com:47723/restaurant");
        client = new MongoClient(uri);
    }

    public MongoCollection getCollection(String collections) {
        return collection = db.getCollection(collections);
    }

    public MongoDatabase getdatabase() {
        db = client.getDatabase(uri.getDatabase());
        return db;
    }
    
}
