package Models.Packs;

import Models.PackAnimal;

import java.util.Calendar;

public class Horse extends PackAnimal {

    public Horse(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public Horse(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    @Override
    public String toString() {
        return "Лошадь: " + super.toString();
    }
}
