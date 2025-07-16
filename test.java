import java.util.Scanner;


public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ваше имя :");
        String name = scanner.nextLine();
        System.out.println("Привет" + " " + name);

    }
}

class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выбор Васи (0 - камень, 1 - ножницы, 2 - бумага): ");
        int vasyaChoice = scanner.nextInt();
        System.out.print("Введите выбор Пети (0 - камень, 1 - ножницы, 2 - бумага): ");
        int petyaChoice = scanner.nextInt();
        System.out.println("Вася выбрал: " + getChoiceName(vasyaChoice));
        System.out.println("Петя выбрал " + getChoiceName(petyaChoice));
        String result = determineWinner(vasyaChoice, petyaChoice);
        System.out.println(result);
        scanner.close();
    }
    public static String getChoiceName(int choice){
        return switch (choice) {
            case 0 -> "Камень";
            case 1 -> "Ножницы";
            case 2 -> "Бумага";
            default -> "Неизвестно";
        };
    }
    public static String determineWinner(int vasyaChoice, int petyaChoice){
        if (vasyaChoice==petyaChoice){
            return "Ничья!";
        }
        if ((vasyaChoice==0 && petyaChoice==1)||
                (vasyaChoice ==1 && petyaChoice==2)||
                (vasyaChoice==2 && petyaChoice==0)) {
            return "Вася выиграл!";
        } else {
            return "Петя выиграл!";
        }
    }
}
