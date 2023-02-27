package Models;

import java.util.Calendar;

public abstract class Pet extends Animal {
    public Pet(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
    public Pet(String name, Calendar birthDate) {
        super(name, birthDate);
    }

}
