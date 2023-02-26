package Models.Pets;

import Models.Pet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cat extends Pet {
    public Cat(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public Cat(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    @Override
    public String toString() {
        return "Кошка: " + super.toString();
    }
}
