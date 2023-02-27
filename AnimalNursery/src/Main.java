import Controller.Control;
import Models.Animal;
import Models.Packs.Camel;
import Models.Pets.Dog;
import Repositories.IRepo;
import Repositories.MySQLRepo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void printList(List<Animal> animals){
        System.out.println();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
    }
    public static void main(String[] args) {
        IRepo repo = new MySQLRepo("localhost", "AnimalNursery", "root", "qwer1234");
        Control control = new Control(repo);
        HashMap<String, Integer> sub = control.getAnimalSubTypes();
        printList(repo.getAll());
        Animal animal = new Camel("Федя",new GregorianCalendar(2010, Calendar.AUGUST, 22));
        repo.delete(2);

    }
}