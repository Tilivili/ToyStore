package UI;

import java.util.List;
import java.util.Scanner;

import Configs.Config;
import Core.MVP.IView;
import Core.Models.Toy;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public int getToyId() {
        System.out.print("Идентификатор игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public String getToyNaming() {
        System.out.print("Название игрушки: ");
        return in.nextLine();
    }

    @Override
    public int getToyWeight() {
        System.out.print("Вес игрушки: ");
        return Integer.parseInt(in.nextLine());
    }

    @Override
    public void showAll(List<Toy> toys) {
        System.out.println("\nВсе игрушки для розыгрыша:");
        for (Toy toy : toys) {
            System.out.println(toy);
        }

    }

    @Override
    public void showGetToy(Toy toy) {
        System.out.print("\nРезультаты розыгрыша: ");
        System.out.println(toy);
    }

    @Override
    public void loadMessage() {
        System.out.println("\nФайл загружен");
    }

    @Override
    public boolean clearAllDecision() {
        boolean f = false;
        System.out.print("\nВы уверены, что хотите удалить все записи? (y/n): ");
        if (in.nextLine().equalsIgnoreCase("Y")) {
            f = true;
        }
        return f;
    }

    @Override
    public void savedAll() {
        System.out.println("\nСохранено в файл: " + Config.pathDb);
    }

    @Override
    public void savedItem() {
        System.out.println("\nУспешно ");
    }

    @Override
    public void saveError() {
        System.out.println("\nНе удалось ");
    }

    @Override
    public void emptyListMessage() {
        System.out.println("Список игрушек пуст!");
    }

    @Override
    public int getDrawTimes() {
        System.out.print("Сколько раз вы хотите провести розыгрыш: ");
        return Integer.parseInt(in.nextLine());
    }

}
