package Controller;

import Application.IClient;
import Models.Animal;
import Repositories.IRepo;

import java.util.HashMap;

public class Control {
    private IRepo repo;
    private IClient client;
    private HashMap<String, Integer> animalTypes;
    private HashMap<String, Integer> animalSubTypes;


    public Control(IRepo repo, IClient client) {
        animalTypes = new HashMap<>();
        animalSubTypes = new HashMap<>();
        this.repo = repo;
        animalTypes = this.repo.getAnimalTypes();
        animalSubTypes = this.repo.getSubAnimalTypes();
        this.client = client;
    }

    public HashMap<String, Integer> getAnimalTypes() {
        return animalTypes;
    }

    public HashMap<String, Integer> getAnimalSubTypes() {
        return animalSubTypes;
    }

    public void start() {
        int item = 0;
        int id = 0;
        Animal animal;
        do {
            item = client.getMenu();
            switch (item) {
                case 1:
                    client.printResult(repo.getAll());
                    break;
                case 2:
                    client.printResult(repo.getInNursery());
                    break;
                case 3:
                    client.printResult(repo.getYang());
                    break;
                case 4:
                    client.printResult(repo.getYangInNursery());
                    break;
                case 5:
                    repo.add(client.getAnimal(animalSubTypes), animalSubTypes);
                    break;
                case 6:
                    id = client.enterID();
                    animal = repo.getAnimalByID(id);
                    if (animal != null){
                        System.out.println(animal);
                        animal = client.getAnimal(animalSubTypes);
                        animal.setId(id);
                        repo.edit(animal, animalSubTypes);
                    }
                    break;
                case 7:
                    repo.delete(client.enterID());
                    break;
                case 8:
                    id = client.enterID();
                    animal = repo.getAnimalByID(id);
                    if (animal != null){
                        System.out.println(animal);
                        animal.moveAnimal();
                        repo.edit(animal, animalSubTypes);
                    }
                    break;
                case 9:
                    id = client.enterID();
                    animal = repo.getAnimalByID(id);
                    if (animal != null){
                        System.out.println(animal);
                        animal.returnAnimal();
                        repo.edit(animal, animalSubTypes);
                    }
                    break;
            }
        } while (item != -100);
    }
}
