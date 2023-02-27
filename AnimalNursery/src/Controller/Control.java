package Controller;

import Repositories.IRepo;

import java.util.HashMap;

public class Controller {
    private IRepo repo;
    private HashMap<String, Integer> animalTypes;
    private HashMap<String, Integer> animalSubTypes;

    public Controller(IRepo repo) {
        animalTypes = new HashMap<>();
        animalSubTypes = new HashMap<>();
        this.repo = repo;
    }
}
