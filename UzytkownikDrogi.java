package droga;

import java.awt.Point;
import java.util.Random;


public abstract class UzytkownikDrogi {

//  int SzerokoscPlanszy = 585;
//  int wysokoscPlanszy = 365; 
    Point polozenie;
    Point predkosc;
    
    public UzytkownikDrogi(Point polozenie, Point predkosc) {
        this.polozenie = polozenie;
        this.predkosc = predkosc;
    }

    public Point getPolozenie() {
        Point temp = (Point) polozenie.clone();
        temp.y += 90;
        return temp;
    }

    public Point getPredkosc() {
        return predkosc;
    }


    void poruszajSie(){
        polozenie.x += getPredkosc().x;
        polozenie.y += getPredkosc().y;
        odbijSie();
    }
    
    void odbijSie(){
        if(predkosc.x>0 && polozenie.x >=580){
            predkosc.x = -1;
            predkosc.y = new Random().nextInt(3)-1;
        }
        if(predkosc.x<0 && polozenie.x <=5){
            predkosc.x = 1;
            predkosc.y = new Random().nextInt(3)-1;
        }
        if(predkosc.y>0 && polozenie.y >=360){
            predkosc.y = -1;
            predkosc.x = new Random().nextInt(3)-1;
        }
        if(predkosc.y<0 && polozenie.y <=5){
            predkosc.y = 1;
            predkosc.x = new Random().nextInt(3)-1;
        }
    }


    public abstract String getSymbol();
 
}
