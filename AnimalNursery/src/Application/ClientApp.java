package Application;

import Models.Animal;
import Models.Packs.Camel;
import Models.Packs.Horse;
import Models.Packs.Mule;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClientApp implements IClient {
    List<String> mainMenu;

    public ClientApp() {
        mainMenu = new ArrayList<>();
        mainMenu.add("Все животные");
        mainMenu.add("Все животные в приюте");
        mainMenu.add("Все молодые животные");
        mainMenu.add("Все молодые животные в приюте");
        mainMenu.add("Добавить животное");
        mainMenu.add("Изменить данные животного");
        mainMenu.add("Удалить животное из списка приюта");
        mainMenu.add("Выход");
    }


    private void printMenu(List<String> menu) {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + 1 + ". " + menu.get(i));
        }
    }

    private int chooseItem() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Выберете пункт: ");
            return scanner.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    public int chooseItem(List<String> menu) {
        printMenu(menu);
        int numItem;
        numItem = chooseItem();
        if (numItem <= 0 || numItem > menu.size()) {
            do {
                System.out.println("Ошибка ввода.");
                printMenu(menu);
                numItem = chooseItem();
            } while (numItem <= 0 || numItem > menu.size());
        }
        if (numItem == menu.size()) return -100;
        return numItem;
    }
    private Calendar getDate(String date){
        try{
            String[] parts = date.split("\\.");
            Calendar result = new GregorianCalendar(Integer.parseInt(parts[2]),
                    Integer.parseInt(parts[1]) - 1,
                    Integer.parseInt(parts[0]));
            return result;

        } catch (Exception ex) {
            System.out.println("Дата введена ошибочно.");
            return null;
        }
    }
    @Override
    public Animal getAnimal(HashMap<String, Integer> animalSubTypes) {
        Scanner scanner = new Scanner(System.in);
        String type = "";
        do {
            System.out.print("Введит вид животного: ");
            type = scanner.next();
            if (!animalSubTypes.containsKey(type)) {
                System.out.println("Ошибка ввода!");
            }
        } while (!animalSubTypes.containsKey(type));
        System.out.print("Введит имя животного: ");
        String name = scanner.next();
        Calendar date;
        do {
            System.out.print("Введите дату рождения животного в формате ДД.ММ.ГГГГ: ");
            String dateStr = scanner.next();
            date = getDate(dateStr);
        }while (date == null);
        Animal animal = null;
        switch (type){
            case "Собака":
                animal = new Dog(name, date);
                break;
            case "Кошка":
                animal = new Cat(name, date);
                break;
            case "Хомяк":
                animal = new Hamster(name, date);
                break;
            case "Лошадь":
                animal = new Horse(name, date);
                break;
            case "Осел":
                animal = new Mule(name, date);
                break;
            case "Верблюд":
                animal = new Camel(name, date);
                break;
        }
        return animal;
    }

    public int getMenu() {
        return chooseItem(mainMenu);
    }
    @Override
    public void printResult(List<Animal> animals) {
        System.out.println();
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).toString());
        }
        System.out.println();

    }

    @Override
    public int enterID() {
        System.out.print("Введите ID:");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return -1;
        }

    }

    public void start() {

    }
}
