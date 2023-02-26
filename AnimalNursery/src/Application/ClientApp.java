package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientApp {
    List<String> mainMenu;

    public ClientApp() {
        mainMenu = new ArrayList<>();
        mainMenu.add("Все животные в приюте");
        mainMenu.add("Вывести всех животных по типу");
        mainMenu.add("Добавить животное");
        mainMenu.add("Удалить животное из списка приюта");
        mainMenu.add("Изменить данные животного");
        mainMenu.add("Выход");
    }
    private void printMenu(List<String> menu){
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
        }
        catch (Exception e) {
            return -1;
        }
    }
    public int chooseItem (List<String> menu) {
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
        return numItem;
    }
    public void start(){
        chooseItem(mainMenu);
    }
}
