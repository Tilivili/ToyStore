import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final String file_name = "C:\\Users\\tiliv\\IdeaProjects\\ToyStore\\src\\main\\java\\Winners";
    private static final Queue<Lot> prizes = new LinkedList<Lot>();
    private static final Lototron lototron = new Lototron();

    public static void main(String[] args) {
        String menu = """
                Комманды:
                0 - Показать команды
                1 - Добавить новый лот в лототрон
                2 - Изменить количество игрушек в лоте
                3 - Показать что в лототроне
                4 - Начать розыгрыш!
                5 - Достать игрушку из лототрона и поместить в выдачу
                6 - Записать игрушку в файл из выдачи
                7 - Завершить программу
                """;

        System.out.print("Розыгрыш игрушек!\n");
        System.out.print(menu);
        boolean run = true;
        Lot lot;
        String command;
        while (run) {
            command = input("Введите команду: ");
            switch (command) {
                case "0" -> System.out.print(menu);
                case "1" -> lototron.addLot();
                case "2" -> lototron.changeAmtForLot();
                case "3" -> System.out.print(lototron);
                case "4" -> lototron.startRaffl();
                case "5" -> {
                    lot = lototron.getPrize();
                    if (lot != null) {
                        prizes.add(lot);
                    }
                }
                case "6" -> writePrize();
                case "7" -> run = false;
                default -> System.out.print("Нет такой команды. Введите 0 для просмотра всех команд!\n");
            }
        }
    }

    public static void writePrize() {
        if (prizes.size() > 0) {
            Lot lot = prizes.poll();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name, true))) {
                writer.write(lot.getItem().toString() + "\n");
                System.out.print("Игрушка успешно записана в файл\n");
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
        } else {
            System.out.print("В выдаче нет игрушек!\n");
        }
    }

    private static String input(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
