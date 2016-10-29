package droga;



public abstract class Pojazd extends UzytkownikDrogi {

    public Pojazd(UzytkownikDrogi arg) {
        super(arg.polozenie, arg.predkosc);
    }


}
