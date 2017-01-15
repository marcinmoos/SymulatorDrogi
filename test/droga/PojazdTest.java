/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droga;

import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcin
 */
public class PojazdTest {
    
    UzytkownikDrogi pojazd;
    Point testPredkosc, testPolozenie;
    
    public PojazdTest() {
        testPredkosc = new Point(1,0);
        testPolozenie = new Point(50,50);
        pojazd = new Pieszy(testPolozenie, testPredkosc);
    }

    @Test
    public void testConstructor() {
        System.out.println("Constructor");
        Pieszy instance = new Pieszy(pojazd);
        assertNotNull(instance);
        assertEquals(instance.polozenie.x, testPolozenie.x);
        assertEquals(instance.polozenie.y, testPolozenie.y);
        assertEquals(instance.predkosc.x, testPredkosc.x);
        assertEquals(instance.predkosc.y, testPredkosc.y);
    }

    
}