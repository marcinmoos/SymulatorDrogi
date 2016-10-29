package droga;

import java.awt.Point;


public class Rower extends Pojazd{

    public Rower(UzytkownikDrogi arg) {
        super(arg);
    }

    @Override
    public Point getPredkosc() {
        Point temp = (Point) predkosc.clone();
        temp.x *= 2;
        temp.y *= 2;
        return temp;
    }


    @Override
    public String getSymbol() {
        return "R";
    }


    
}
