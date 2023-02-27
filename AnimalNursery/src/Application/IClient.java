package Application;

import Models.Animal;

import java.util.HashMap;
import java.util.List;

public interface IClient {
    public Animal getAnimal(HashMap<String, Integer> animalSubTypes);
    public int getMenu();
    public int chooseItem (List<String> menu);
    public void printResult(List<Animal> animals);
    public int enterID();
    public void start();
}
