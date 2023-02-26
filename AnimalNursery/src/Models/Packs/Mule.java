package Models.Packs;

import Models.PackAnimal;

import java.util.Calendar;

public class Mule extends PackAnimal {

    public Mule(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public Mule(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    @Override
    public void sendToWinter() {

    }

    @Override
    public void returnFromWinter() {

    }

    @Override
    public String toString() {
        return "Осел: " + super.toString();
    }
}
