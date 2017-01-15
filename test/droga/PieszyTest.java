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
public class PieszyTest {
    
    UzytkownikDrogi pieszy;
    Point testPredkosc, testPolozenie;
    
    public PieszyTest() {
        testPredkosc = new Point(1,0);
        testPolozenie = new Point(50,50);
        pieszy = new Pieszy(testPolozenie, testPredkosc);
    }
    
    @Test
    public void testPointConstructor() {
        System.out.println("Point Constructor");
        Pieszy instance = new Pieszy(testPolozenie, testPredkosc);
        assertNotNull(instance);
        assertEquals(instance.polozenie, testPolozenie);
        assertEquals(instance.predkosc, testPredkosc);
    }
    
    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        Pieszy instance = new Pieszy(pieszy);
        assertNotNull(instance);
        assertEquals(instance.polozenie, testPolozenie);
        assertEquals(instance.predkosc, testPredkosc);
    }


    @Test
    public void testGetSymbol() {
        System.out.println("getSymbol");
        Pieszy instance = (Pieszy) pieszy;
        String expResult = "P";
        String result = instance.getSymbol();
        assertEquals(expResult, result);
    }
    
}
