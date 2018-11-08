/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpj;



import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class  RestaurantService {

    RestaurantDao connect;
    ConnectDB DB;
    PreparedStatement pst ;

    public  RestaurantService() {
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

    public ArrayList<String> searchdRestaurant(String restname) {      
       
       RestaurantDao rest  = new  RestaurantDao() ;
       ArrayList<String> arr = new ArrayList<String>();
       
       arr = rest.findRestaurantByName(restname);
       
       return  arr ;
       
    
    
    }

    

}
