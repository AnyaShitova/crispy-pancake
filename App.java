import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> purchaseMessages = new ArrayList<>();

        // Ввод покупателей
        System.out.println("Введите покупателей в формате 'Имя=Сумма денег', разделяя их через ; (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] entries = input.split(";"); // Разделяем строку по точке с запятой
            for (String entry : entries) {
                try {
                    String[] parts = entry.split("=");
                    if (parts.length < 2) {
                        System.out.println("Некорректный формат ввода. Используйте 'Имя=Сумма денег'.");
                        continue;
                    }
                    // Имя покупателя — это первая часть строки
                    String name = parts[0].trim();
                    // Сумма денег — это вторая часть строки
                    double money = Double.parseDouble(parts[1].trim());
                    if (money < 0) {
                        System.out.println("Ошибка: Сумма денег не может быть отрицательной. Пожалуйста, введите корректные данные.");
                        continue;
                    }
                    if (name.length() < 3) {
                        System.out.println("Ошибка: Имя покупателя должно содержать не менее 3 символов. Пожалуйста, введите корректные данные.");
                        continue;
                    }

                    Person person = new Person(name, money);
                    people.add(person);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Некорректное значение суммы денег.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // Ввод продуктов
        System.out.println("Введите продукты в формате 'Название=Стоимость', разделяя их через ; (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] entries = input.split(";"); // Разделяем строку по точке с запятой
            for (String entry : entries) {
                try {
                    String[] parts = entry.split("=");
                    if (parts.length < 2) {
                        System.out.println("Некорректный формат ввода. Используйте 'Название=Стоимость'.");
                        continue;
                    }

                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());

                    Product product = new Product(name, price);
                    products.add(product);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Некорректное значение стоимости продукта.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // Выбор продуктов
        System.out.println("Введите покупки в формате 'Имя покупателя Название продукта' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                boolean purchaseFound = false;
                for (Person person : people) {
                    if (input.startsWith(person.getName())) {
                        String personName = person.getName();
                        String productName = input.substring(personName.length()).trim();

                        Product product = null;
                        for (Product p : products) {
                            if (p.getName().equals(productName)) {
                                product = p;
                                break;
                            }
                        }
                        if (product == null) {
                            System.out.println("Продукт '" + productName + "' не найден.");
                            purchaseFound = true;
                            break;
                        }

                        if (person.addProduct(product)) {
                            purchaseMessages.add(person.getName() + " купил " + product.getName() + " ");
                        } else {
                            purchaseMessages.add(person.getName() + " не может позволить себе " + product.getName() + " ");
                        }
                        purchaseFound = true;
                        break;
                    }
                }
                if (!purchaseFound) {
                    System.out.println("Покупатель не найден.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат ввода.");
            }
        }

        // Вывод результатов
        System.out.println("\nРезультаты:");
        for (String message : purchaseMessages) {
            System.out.println(message);
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }
}