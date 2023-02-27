package Models.Packs;

import Models.PackAnimal;

import java.util.Calendar;

public class Camel extends PackAnimal {

    public Camel(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public Camel(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }


    @Override
    public String toString() {
        return "Верблюд: " + super.toString();
    }
}
