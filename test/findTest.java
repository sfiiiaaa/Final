/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import finalpj.RestaurantDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frosty
 */
public class findTest {
    
    public findTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void TestCheckFindName() {
        RestaurantDao dao = new RestaurantDao();
        boolean test = dao.getRestaurant("มู๋กะชีส");
        assertEquals(true, test);
    }

    @Test
    public void TestCheckFindName2() {
        RestaurantDao dao = new RestaurantDao();
        boolean test = dao.getRestaurant("พุงกาง");
        assertEquals(false, test);
    }

    @Test
    public void TestCheckFindName3() {
        RestaurantDao dao = new RestaurantDao();
        boolean test = dao.getRestaurant("หนมนำแหนม");
        assertEquals(false, test);
    }

    @Test
    public void TestCheckFindName4() {
        RestaurantDao dao = new RestaurantDao();
        boolean test = dao.getRestaurant("ชาบูตัวดูด");
        assertEquals(false, test);
    }

    @Test
    public void TestCheckFindName5() {
        RestaurantDao dao = new RestaurantDao();
        boolean test = dao.getRestaurant("ติ๋มส้มตำ");
        assertEquals(false, test);
    }

}
