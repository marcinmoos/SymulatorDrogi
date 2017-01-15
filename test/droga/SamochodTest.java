/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droga;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcin
 */
public class SamochodTest {
    
    UzytkownikDrogi pieszy;
    Point testPredkosc, testPolozenie;
    
    public SamochodTest() {
        testPredkosc = new Point(1,0);
        testPolozenie = new Point(50,50);
        pieszy = new Pieszy(testPolozenie, testPredkosc);
    }
    
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        Samochod instance = new Samochod(pieszy);
        assertNotNull(instance);
        assertEquals(instance.polozenie, testPolozenie);
        assertEquals(instance.predkosc, testPredkosc);
    }
    
        @Test
    public void testGetPredkosc() {
        System.out.println("Getter");
        Samochod instance = new Samochod(pieszy);
        assertNotNull(instance);
        assertEquals(instance.getPredkosc().x, testPredkosc.x*5);
        assertEquals(instance.getPredkosc().y, testPredkosc.y*5);
    }


   @Test
    public void testGetSymbol() {
        System.out.println("getSymbol");
        Samochod instance = new Samochod(pieszy);
        String expResult = "S";
        String result = instance.getSymbol();
        assertEquals(expResult, result);
    }
    
}