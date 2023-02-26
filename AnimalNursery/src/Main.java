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
    public static void main(String[] args) throws SQLException {
         Repo repo = new MySQLRepo("localhost", "AnimalNursery", "root", "qwer1234");
        List<Animal> animals = repo.getAll();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
        System.out.println();
        animals = repo.getYang();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
    }
}