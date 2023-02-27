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
        List<Animal> result = super.getAll(conStr, false, false, 0);
        return result;
    }

    @Override
    public List<Animal> getInNursery() {
        List<Animal> result = super.getAll(conStr, true, false, 0);
        return result;
    }

    @Override
    public List<Animal> getYang() {
        List<Animal> result = super.getAll(conStr, false, true, 0);
        return result;
    }

    @Override
    public List<Animal> getYangInNursery() {
        List<Animal> result = super.getAll(conStr, true, true, 0);
        return result;
    }

    @Override
    public void add(Animal animal, HashMap<String, Integer> animalSubTypes) {
        super.add(conStr, animalSubTypes, animal, getMySqlDate(animal.getBirthDate()));
    }

    @Override
    public void edit(Animal animal, HashMap<String, Integer> animalSubTypes) {
        super.edit(conStr, animalSubTypes, animal, getMySqlDate(animal.getBirthDate()));
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

    @Override
    public Animal getAnimalByID(int id) {
       List<Animal> animals = super.getAll(conStr, false, false, id);
       if (animals != null) {
           Animal animal = animals.get(0);
           return animal;
       }
       return null;
    }

}
