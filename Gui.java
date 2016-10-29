package droga;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.abs;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Gui extends JFrame implements ActionListener{

    JButton przycisk[] = new JButton[9];
    JLabel[] znaczek = new JLabel[3];
    UzytkownikDrogi[] uzythownikDrogi = new UzytkownikDrogi[3];

    public static void main(String[] args) throws InterruptedException {
        Gui okno = new Gui();
        okno.setTitle("Droga");
        okno.setBounds(200, 100, 600, 500);
        okno.setDefaultCloseOperation(EXIT_ON_CLOSE);
        okno.setVisible(true);
        okno.setLayout(null);
        okno.setResizable(false);

        
         int polx = 0, poly = 60;
        for(int i = 0;i<9; i++){
            if(i<3){
                okno.przycisk[i] = new JButton("Samochód");
                okno.przycisk[i].setBounds(polx, poly, 200, 30);
                polx += 200;
                if(i==2){
                    polx = 0;
                    poly -=30;
                }
            }
            if(i>=3 && i<6){
                okno.przycisk[i] = new JButton("Rower");
                okno.przycisk[i].setBounds(polx, poly, 200, 30);
                polx += 200; 
                    if(i==5){
                    polx = 0;
                    poly -=30;
                }
            }        
            if(i>=6){
                okno.przycisk[i] = new JButton("Pieszy");
                okno.przycisk[i].setBounds(polx, poly, 200, 30);
                polx += 200; 
            }       
            okno.przycisk[i].addActionListener(okno);        
            okno.add(okno.przycisk[i]);
        }
        
        for(int i=0;i<3;i++){
        okno.znaczek[i]= new JLabel();
        okno.znaczek[i].setVisible(true);
        okno.add(okno.znaczek[i]);
        }

        Point polozenie1 = new Point(10, 10);
        Point polozenie2 = new Point(10, 170);
        Point polozenie3 = new Point(10, 350);
        Point predkosc1 = new Point(1, 0);
        Point predkosc2 = new Point(1, 0);
        Point predkosc3 = new Point(1, 0);
        
        okno.uzythownikDrogi[0] = new Pieszy(polozenie1, predkosc1);
        okno.uzythownikDrogi[1] = new Pieszy(polozenie2, predkosc2);
        okno.uzythownikDrogi[2] = new Pieszy(polozenie3, predkosc3);
            
        int j = 0;
        while(!okno.detekcjaKolizji()){
            okno.uzythownikDrogi[j].poruszajSie();
            okno.znaczek[j].setText(okno.uzythownikDrogi[j].getSymbol());
            okno.znaczek[j].setBounds(okno.uzythownikDrogi[j].getPolozenie().x, okno.uzythownikDrogi[j].getPolozenie().y, 15, 15);

               if(j<2)j++;
               else j=0;
            Thread.sleep(5);
            }
    }
    
    boolean detekcjaKolizji(){
        if(porownanie(uzythownikDrogi[0].polozenie, uzythownikDrogi[1].polozenie))return true;
        else if(porownanie(uzythownikDrogi[0].polozenie, uzythownikDrogi[2].polozenie))return true;
        else return porownanie(uzythownikDrogi[0].polozenie, uzythownikDrogi[2].polozenie);
    }
    
    boolean porownanie(Point a, Point b){
        int tempa = abs(a.x - b.x); 
        int tempb = abs(a.y - b.y); 
        return(tempa >= 0 && tempa <=10 && tempb >= 0 && tempb <=10);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int j = 0;j<9;j++){
            if(e.getSource() == przycisk[j]){
            if(j < 3)uzythownikDrogi[j%3] = new Samochod(uzythownikDrogi[j%3]);
            if(j>=3 && j<6)uzythownikDrogi[j%3] = new Rower(uzythownikDrogi[j%3]);  
            if(j >= 6)uzythownikDrogi[j%3] = new Pieszy(uzythownikDrogi[j%3]);  
            }
        }
    } 
}