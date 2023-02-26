package Models.Pets;

import Models.Pet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hamster extends Pet {
    public Hamster(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public Hamster(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    @Override
    public String toString() {
        return "Хомяк: " + super.toString();
    }
}
