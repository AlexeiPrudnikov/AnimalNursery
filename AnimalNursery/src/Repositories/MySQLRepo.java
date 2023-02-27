package Repositories;

import Models.Animal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MySQLRepo extends Repo {
    private String conStr;
    public MySQLRepo(String server, String database, String user, String password) {
        super(server, database, user, password);
        this.conStr = "jdbc:mysql://" + getServer() + ":3306/" + getDatabase();
    }
    public String getMySqlDate(Calendar calendar) {
        String result = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        result = df.format(calendar.getTime());
        return result;
    }
    @Override
    public List<Animal> getAll() {
        List<Animal> result = super.getAll(conStr, false, false);
        return result;
    }

    @Override
    public List<Animal> getInNursery() {
        List<Animal> result = super.getAll(conStr, true, false);
        return result;
    }

    @Override
    public List<Animal> getYang() {
        List<Animal> result = super.getAll(conStr, false, true);
        return result;
    }

    @Override
    public List<Animal> getYangInNursery() {
        List<Animal> result = super.getAll(conStr, true, true);
        return result;
    }

    @Override
    public void add(Animal animal, HashMap<String, Integer> animalSubTypes) {
        super.add(conStr, animalSubTypes, animal, getMySqlDate(animal.getBirthDate()));
    }

    @Override
    public void delete(int id) {
        super.delete(conStr, id);
    }

    @Override
    public HashMap<String, Integer> getAnimalTypes() {
        HashMap<String, Integer> result = super.getAnimalTypes(conStr);
        return result;
    }

    @Override
    public HashMap<String, Integer> getSubAnimalTypes() {
        HashMap<String, Integer> result = super.getAnimalSubTypes(conStr);
        return result;
    }

}
