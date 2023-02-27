package Repositories;

import Models.Animal;
import Models.Packs.*;
import Models.Pets.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public abstract class Repo implements IRepo{
    private String server;
    private String database;
    private String user;
    private String password;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Repo(String server, String database, String user, String password) {
        this.server = server;
        this.database = database;
        this.user = user;
        this.password = password;
    }
    private Calendar getDate(String date) {
        try {
            String[] parts = date.split("-");
            Calendar result = new GregorianCalendar(Integer.parseInt(parts[0]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[2]));
            return result;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    protected List<Animal> getAll(String conStr,boolean isNursery, boolean isYang){
        List<Animal> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(conStr, getUser(), getPassword())) {
            String query = "select ant.atID, ant.atName, ast.astID, ast.astName, a.aID, a.aName, a.aBirthDate, a.aInNursery \n" +
                    "from AnimalTypes ant \n" +
                    "join AnimalSubTypes ast on (ant.atID = ast.atID)\n" +
                    "join Animals a on (a.astID = ast.astID)\n" +
                    "where (1=1)";
            if (isNursery) {
                query += "and a.aInNursery = true";
            }
            if (isYang) {
                query += " and TIMESTAMPDIFF(YEAR, a.aBirthDate, CURDATE()) < 3";
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Animal animal = null;
            while (resultSet.next()) {
                animal = null;
                Calendar date = getDate(resultSet.getString(7));
                switch (resultSet.getString(4)){
                    case "Собака":
                        animal = new Dog(resultSet.getInt(5), resultSet.getString(6), date);
                        break;
                    case "Кошка":
                        animal = new Cat(resultSet.getInt(5),resultSet.getString(6), date);
                        break;
                    case "Хомяк":
                        animal = new Hamster(resultSet.getInt(5),resultSet.getString(6), date);
                        break;
                    case "Лошадь":
                        animal = new Horse(resultSet.getInt(5),resultSet.getString(6), date);
                        break;
                    case "Осел":
                        animal = new Mule(resultSet.getInt(5),resultSet.getString(6), date);
                    case "Верблюд":
                        animal = new Camel(resultSet.getInt(5),resultSet.getString(6), date);
                        break;
                    default:
                        animal = new Animal(resultSet.getInt(5),resultSet.getString(6), date);
                        break;
                }
                animal.setInNursery(resultSet.getBoolean(8));
                if (animal != null) {
                    result.add(animal);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    protected HashMap<String, Integer> getAnimalSubTypes(String conStr){
        HashMap<String, Integer> result = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(conStr, getUser(), getPassword())){
            String query = "select astName, astID  from AnimalSubTypes order by astName";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                result.put(resultSet.getString(1), resultSet.getInt(2));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    protected HashMap<String, Integer> getAnimalTypes(String conStr){
        HashMap<String, Integer> result = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(conStr, getUser(), getPassword())){
            String query = "select atName, atID  from AnimalTypes order by atName";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                result.put(resultSet.getString(1), resultSet.getInt(2));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    protected void add (String conStr,HashMap<String, Integer> animalSubTypes,  Animal animal, String date) {
        String query = "insert into animals (aName, astID, aBirthDate, aInNursery) values (";
        try (Connection connection = DriverManager.getConnection(conStr, getUser(), getPassword())){
            Statement statement = connection.createStatement();
            String[] types = animal.getClass().toString().split("\\.");
            query += "'" + animal.getName() + "', ";
            switch (types[types.length - 1]) {
                case "Dog":
                    query +=  animalSubTypes.get("Собака") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
                case "Cat":
                    query += animalSubTypes.get("Кошка") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
                case "Hamster":
                    query += animalSubTypes.get("Хомяк") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
                case "Mule":
                    query += animalSubTypes.get("Осел") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
                case "Horse":
                    query += animalSubTypes.get("Лошадь") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
                case "Camel":
                    query += animalSubTypes.get("Верблюд") + ", '" + date + "', true)";
                    statement.executeUpdate(query);
                    break;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    protected void delete (String conStr, int id) {
        String query = "delete from animals where aID = " + id;
        try (Connection connection = DriverManager.getConnection(conStr, getUser(), getPassword())){
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
