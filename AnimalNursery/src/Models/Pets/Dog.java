package Models.Pets;

import Models.Pet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dog extends Pet {

    public Dog(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    public Dog(String name, Calendar birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Собака: " + super.toString();
    }
}
