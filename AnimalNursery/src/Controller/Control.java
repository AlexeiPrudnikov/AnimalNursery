package Controller;

import Repositories.IRepo;

import java.util.HashMap;

public class Control {
    private IRepo repo;
    private HashMap<String, Integer> animalTypes;
    private HashMap<String, Integer> animalSubTypes;

    public Control(IRepo repo) {
        animalTypes = new HashMap<>();
        animalSubTypes = new HashMap<>();
        this.repo = repo;
        animalTypes = this.repo.getAnimalTypes();
        animalSubTypes = this.repo.getSubAnimalTypes();
        System.out.println("");
    }

    public HashMap<String, Integer> getAnimalTypes() {
        return animalTypes;
    }

    public HashMap<String, Integer> getAnimalSubTypes() {
        return animalSubTypes;
    }
}
