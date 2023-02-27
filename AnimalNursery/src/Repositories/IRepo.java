package Repositories;

import Models.Animal;

import java.util.HashMap;
import java.util.List;

public interface IRepo {
    public List<Animal> getAll();
    public List<Animal> getInNursery();
    public List<Animal> getYang();
    public List<Animal> getYangInNursery();
    public void add(Animal animal, HashMap<String, Integer> animalSubTypes);
    public void delete(int id);
    public HashMap<String, Integer> getAnimalTypes();
    public HashMap<String, Integer> getSubAnimalTypes();
}
