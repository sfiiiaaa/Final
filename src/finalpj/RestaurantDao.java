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
    
    RestaurantDao(){
        connectData = new ConnectDB();
        db = connectData.getdatabase();
    }
    
    public String getRestaurant(String restname){
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject("name", restname);
        MongoCursor<Document> c = connectData.getdatabase().getCollection("Restaurant").find(fields).iterator();
       
        if (c != null) {
            while (c.hasNext()) {
                return c.next().get("name").toString();
            }
        }
        
        return "";
    }
    
}
