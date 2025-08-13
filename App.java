import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> purchaseMessages = new ArrayList<>();
        // ввод покупателей
        System.out.println("Введите покупателей в формате 'Имя=Сумма денег' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split("=");
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
        // ввод продуктов
        System.out.println("Введите продукты в формате 'Название=Стоимость' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split("=");
                if (parts.length < 2) {
                    System.out.println("Некорректный формат ввода. Используйте 'Название=Стоимость'.");
                    continue;
                }

                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());

                Product product = new Product(name, price);
                products.add(product);
            }  catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректное значение стоимости продукта.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        // выбор продуктов
        System.out.println("Введите покупки в формате 'Имя покупателя-Название продукта' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split("-");
                if (parts.length < 2) {
                    System.out.println("Некорректный формат ввода. Используйте 'Название-Стоимость'.");
                    continue;
                }
                // Имя покупателя — первая часть строки
                String personName = parts[0].trim();
                // Название продукта — вторая часть строки
                String productName = parts[1].trim();
                Person person = null;
                for (Person p : people) {
                    if (p.getName().equals(personName)) {
                        person = p;
                        break;
                    }
                }
                if (person == null) {
                    System.out.println("Покупатель '" + personName + "' не найден.");
                    continue;
                }
                Product product = null;
                for (Product p : products) {
                    if (p.getName().equals(productName)) {
                        product = p;
                        break;
                    }
                }
                if (product == null) {
                    System.out.println("Продукт '" + productName + "' не найден.");
                    continue;
                }
                if (person.addProduct(product)){
                    purchaseMessages.add(person.getName() + " купил " + product.getName() +" ");
                }else {
                    purchaseMessages.add(person.getName() + " не может позволить себе " + product.getName() +" ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный формат ввода.");
            }
        }
        System.out.println("\nРезультаты:");
        for (String message : purchaseMessages) {
            System.out.println(message);
        }
        for (Person person : people) {
            System.out.println(person);}
    }
}