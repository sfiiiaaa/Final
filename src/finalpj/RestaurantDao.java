/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpj;

import com.mongodb.client.MongoCursor;
import javax.swing.JOptionPane;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author DELL
 */
public class RestaurantDao {

    MongoClientURI uri;
    MongoClient client;
    MongoDatabase db;
    BasicDBObject insert = new BasicDBObject();
    MongoCollection collection;
    ConnectDB connectData;

    RestaurantDao() {
        connectData = new ConnectDB();
        db = connectData.getdatabase();
    }

    public ArrayList<String> findRestaurantByName(String restname) {

     
        BasicDBObject fields = new BasicDBObject("name", new BasicDBObject("$regex", restname));
        MongoCursor<Document> c = connectData.getdatabase().getCollection("Restaurant").find(fields).iterator();
        ArrayList<String> arr = new ArrayList<String>();

        if (c != null) {
            while (c.hasNext()) {
                arr.add(c.next().get("name").toString());
            }
        }

        return arr;
    }

}
