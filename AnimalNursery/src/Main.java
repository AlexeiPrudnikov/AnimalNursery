import Models.Animal;
import Models.Packs.Camel;
import Models.Pets.Dog;
import Repositories.Repo;
import Repositories.MySQLRepo;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void printList(List<Animal> animals){
        System.out.println();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
    }
    public static void main(String[] args) throws SQLException {
         Repo repo = new MySQLRepo("localhost", "AnimalNursery", "root", "qwer1234");
        List<Animal> animals = repo.getAll();
        printList(animals);
        animals = repo.getInNursery();
        printList(animals);
        animals = repo.getYang();
        printList(animals);
        animals = repo.getYangInNursery();
        printList(animals);

    }
}