package droga;

import java.awt.Point;


public class Pieszy extends UzytkownikDrogi{

    public Pieszy(Point polozenie, Point predkosc) {
        super(polozenie, predkosc);
    }
    
    public Pieszy(UzytkownikDrogi arg) {
        super(arg.polozenie, arg.predkosc);
    }


    @Override
    public String getSymbol() {
        return "P";
    }


}
