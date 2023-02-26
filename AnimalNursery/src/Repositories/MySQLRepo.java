package Repositories;

import Models.Animal;
import Models.Packs.Camel;
import Models.Packs.Horse;
import Models.Packs.Mule;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MySQLRepo extends Repo {
    private String conStr;
    public MySQLRepo(String server, String database, String user, String password) {
        super(server, database, user, password);
        this.conStr = "jdbc:mysql://" + getServer() + ":3306/" + getDatabase();
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

}
