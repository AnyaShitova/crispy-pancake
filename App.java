import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание экземпляра класса Телевизор
        System.out.println("Создание нового телевизора:");
        System.out.print("Введите марку телевизора: ");
        String brand = scanner.nextLine();
        System.out.print("Введите размер диагонали (в дюймах): ");
        int size = 0;
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите корректное число: ");
            }
        }

        TV tv = new TV(brand, size);

        // Меню управления телевизором
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Включить телевизор");
            System.out.println("2. Выключить телевизор");
            System.out.println("3. Переключить канал");
            System.out.println("4. Выйти");
            System.out.print("Ваш выбор: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
                continue;
            }

            switch (choice) {
                case 1:
                    tv.turnOn();
                    break;
                case 2:
                    tv.turnOff();
                    break;
                case 3:
                    if (tv.isOn()) {
                        System.out.print("Введите номер канала: ");
                        int channel = 0;
                        try {
                            channel = Integer.parseInt(scanner.nextLine());
                            tv.changeChannel(channel);
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка! Введите корректный номер канала.");
                        }
                    } else {
                        System.out.println("Телевизор выключен. Включите его для смены канала.");
                    }
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}

