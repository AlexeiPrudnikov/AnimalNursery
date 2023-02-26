package Models;

import java.util.Calendar;

public abstract class PackAnimal extends Animal implements IPack{
    public PackAnimal(String name, Calendar birthDate) {
        super(name, birthDate);
    }
    public PackAnimal(int id, String name, Calendar birthDate) {
        super(id, name, birthDate);
    }
}
