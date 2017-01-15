/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droga;

import java.awt.Point;
import java.awt.event.ActionEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcin
 */
public class GuiTest {
    
        static Point[] kolizyjny = new Point[9];
        static Point[] nieKolizyjny = new Point[4];
        static Point a = new Point(50,50);

            
    public GuiTest() {
        kolizyjny[0] = new Point(40,40);
        kolizyjny[1] = new Point(40,50);
        kolizyjny[2] = new Point(40,60);
        kolizyjny[3] = new Point(50,40);
        kolizyjny[4] = new Point(50,50);
        kolizyjny[5] = new Point(50,60);
        kolizyjny[6] = new Point(60,40);
        kolizyjny[7] = new Point(60,50);
        kolizyjny[8] = new Point(60,60);
        
        nieKolizyjny[0] = new Point(50,39);
        nieKolizyjny[1] = new Point(50,61);
        nieKolizyjny[2] = new Point(39,50);
        nieKolizyjny[3] = new Point(80,61);
    }

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Gui.main(args);

    }

    @Test
    public void testDetekcjaKolizji() {
        System.out.println("detekcjaKolizji");
        Gui instance = new Gui();
        instance.uzytkownikDrogi[0] = new Pieszy(a, new Point(0,0));
        instance.uzytkownikDrogi[1] = new Pieszy(nieKolizyjny[0], new Point(0,0));
        instance.uzytkownikDrogi[2] = new Pieszy(nieKolizyjny[1], new Point(0,0));
        assertEquals(instance.detekcjaKolizji(),false);
        
        instance.uzytkownikDrogi[0] = new Pieszy(a, new Point(0,0));
        instance.uzytkownikDrogi[1] = new Pieszy(kolizyjny[0], new Point(0,0));
        instance.uzytkownikDrogi[2] = new Pieszy(nieKolizyjny[1], new Point(0,0));
        assertEquals(instance.detekcjaKolizji(),true);
        
        instance.uzytkownikDrogi[0] = new Pieszy(a, new Point(0,0));
        instance.uzytkownikDrogi[1] = new Pieszy(nieKolizyjny[0], new Point(0,0));
        instance.uzytkownikDrogi[2] = new Pieszy(kolizyjny[1], new Point(0,0));
        assertEquals(instance.detekcjaKolizji(),true);
        
        instance.uzytkownikDrogi[0] = new Pieszy(a, new Point(0,0));
        instance.uzytkownikDrogi[1] = new Pieszy(kolizyjny[0], new Point(0,0));
        instance.uzytkownikDrogi[2] = new Pieszy(kolizyjny[1], new Point(0,0));
        assertEquals(instance.detekcjaKolizji(),true);
    }

    @Test
    public void testPorownanie() {
        System.out.println("porownanie");

        Gui instance = new Gui();
        for(int i = 0; i<9; i++){
            assertEquals(instance.porownanie(a, kolizyjny[i]), true);;
        }
        for(int i = 0; i<4; i++){
            assertEquals(instance.porownanie(a, nieKolizyjny[i]), false);;
        }
    }

    
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        Gui instance = new Gui();
        ActionEvent e = new ActionEvent(instance, 0, "aaa");
        instance.actionPerformed(e);
    }
    
}
