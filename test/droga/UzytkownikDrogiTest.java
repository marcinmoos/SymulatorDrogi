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
public class UzytkownikDrogiTest {
    
    UzytkownikDrogi[] uzytkownik = new UzytkownikDrogi[3];
    Point testPredkosc, testPolozenie;
    
    public UzytkownikDrogiTest() {
        testPredkosc = new Point(1,0);
        testPolozenie = new Point(50,50);
        uzytkownik[0] = new Pieszy(testPolozenie, testPredkosc);
        uzytkownik[1] = new Rower(uzytkownik[0]);
        uzytkownik[2] = new Samochod(uzytkownik[0]);
    }
    

    @Test
    public void testGetPolozenie() {
        System.out.println("getPolozenie");
        UzytkownikDrogi instance = uzytkownik[0];
        Point expResult = new Point(testPolozenie.x, testPolozenie.y + 90);
        Point result = instance.getPolozenie();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPredkosc() {
        System.out.println("getPredkosc");
        UzytkownikDrogi instance = uzytkownik[0];
        Point expResult = testPredkosc;
        Point result = instance.getPredkosc();
        assertEquals(expResult, result);
    }

    @Test
    public void testPoruszajSie() {
        System.out.println("poruszajSie");
        for(int i = 0; i<=2; i++){
            UzytkownikDrogi instance = uzytkownik[i];
            Point tempPolozenie = new Point(testPolozenie);
            Point tempPredkosc = new Point(instance.getPredkosc());
            instance.poruszajSie();
            Point expResult = new Point(tempPolozenie.x + tempPredkosc.x, tempPolozenie.y + tempPredkosc.y);
            Point result = instance.polozenie;
            assertEquals(expResult, result);
        }
    }
    
    @Test
    public void testOdbijSie() {
        Point[] krawedzPolozenie = new Point[8];
        krawedzPolozenie[0] = new Point(0,50);
        krawedzPolozenie[1] = new Point(580,50);
        krawedzPolozenie[2] = new Point(50,0);
        krawedzPolozenie[3] = new Point(50,360);
        krawedzPolozenie[4] = new Point(0,0);
        krawedzPolozenie[5] = new Point(0,360);
        krawedzPolozenie[6] = new Point(580,0);
        krawedzPolozenie[7] = new Point(580,360);

        Point[] krawedzPredkosc = new Point[8];
        krawedzPredkosc[0] = new Point(-1,0);
        krawedzPredkosc[1] = new Point(1,0);
        krawedzPredkosc[2] = new Point(0,-1);
        krawedzPredkosc[3] = new Point(0,1);
        krawedzPredkosc[4] = new Point(-1,-1);
        krawedzPredkosc[5] = new Point(-1,1);
        krawedzPredkosc[6] = new Point(1,-1);
        krawedzPredkosc[7] = new Point(1,1);

        for(int j=0; j<3; j++){
            UzytkownikDrogi instance = uzytkownik[j];
            for(int i = 0; i<8; i++){
                instance.predkosc = krawedzPredkosc[i];
                instance.polozenie = krawedzPolozenie[i];
                instance.odbijSie();
                assertEquals(0,instance.predkosc.x,1);
                assertEquals(0,instance.predkosc.y,1);
                instance.poruszajSie();
                Point wynik = instance.polozenie;
                assertTrue(wynik.x <= 580 && wynik.x>=0 && wynik.y <= 360 && wynik.y>=0);
            } 
        }

    }
}
