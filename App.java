import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        // ввод покупателей
        System.out.println("Введите покупателей в формате 'Имя Сумма денег' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split(" ");
                String name = parts[0];
                double money = Double.parseDouble(parts[1]);
                Person person = new Person(name, money);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный формат ввода. Используйте 'Имя Сумма денег'.");
            }
        }
        // ввод продуктов
        System.out.println("Введите продукты в формате 'Название Стоимость' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split(" ");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                Product product = new Product(name, price);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный формат ввода. Используйте 'Название Стоимость'.");
            }
        }
        // выбор продуктов
        System.out.println("Введите покупки в формате 'Имя покупателя Название продукта' (для завершения введите END):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                String[] parts = input.split(" ");
                String personName = parts[0];
                String productName = parts[1];
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
                person.addProduct(product);
            } catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Некорректный формат ввода. Используйте 'Имя покупателя Название продукта'.");
            }
        }
        System.out.println("\nРезультаты:");
        for (Person person : people){
            System.out.println(person);
        }
    }
}
