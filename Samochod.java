package droga;

import java.awt.Point;



public class Samochod extends Pojazd{

    public Samochod(UzytkownikDrogi arg) {
        super(arg);
    }

    @Override
    public Point getPredkosc() {
        Point temp = (Point) predkosc.clone();
        temp.x *= 5;
        temp.y *= 5;
        return temp;
    }

   
    @Override
    public String getSymbol() {
        return "S";
    }


    
}
