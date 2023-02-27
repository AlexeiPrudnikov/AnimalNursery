package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Animal implements IMove{
    private int id;
    private String name;
    private Calendar birthDate;
    private boolean inNursery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isInNursery() {
        return inNursery;
    }

    public void setInNursery(boolean inNursery) {
        this.inNursery = inNursery;
    }

    public Animal(int id, String name, Calendar birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.inNursery = true;
    }

    public Animal(String name, Calendar birthDate) {
        this(0, name, birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        Animal animal = (Animal) obj;
        if (this.id > 0 && this.id == animal.id) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String result = "id = " + getId() + " -> " + getName() + " " + df.format(getBirthDate().getTime());
        if (isInNursery()) {
            result += ", в приюте.";
        } else {
            result += ", не в приюте.";
        }
        return result;
    }
    @Override
    public void moveAnimal() {
        inNursery = false;
    }

    @Override
    public void returnAnimal() {
        inNursery = true;
    }
}
