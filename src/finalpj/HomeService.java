/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpj;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class HomeService {

    RestaurantDao connect;
    MongoClientURI uri;
    MongoClient client;
    MongoDatabase db;
    MongoCollection collectionLobby;
    ConnectDB DB;
    PreparedStatement pst ;

    public HomeService() {
        connect = new RestaurantDao();
        DB = new ConnectDB();
    }

    public boolean checkLenghtChar(String restname) {
        if (restname.length() <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public void findData(JTable tablerest,String restname) {      
       String[] columnNames = {"NameRestaurant"};
       DefaultTableModel model = new DefaultTableModel(columnNames, 0);
       BasicDBObject fields = new BasicDBObject("name", new BasicDBObject("$regex", restname));
       MongoCursor<Document> c = DB.getdatabase().getCollection("Restaurant").find(fields).iterator();
       
       if (c.hasNext() == true) {
            while (c.hasNext()) {
                model.addRow(new Object[]{c.next().get("name").toString()});
            }
        } else {
            model.addRow(new Object[]{"ไม่พบร้านอาหารที่ต้องการ"});
        }
        tablerest.setModel(model);
        
    }
    
    public boolean getRestaurant(String name) {
        int count = 0;
        MongoCollection<Document> col = DB.getdatabase().getCollection("Restaurant");
        Document doc = new Document("name", name);
        try {
            count = (int) col.count(doc);
        } finally {

        }
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
    

}
