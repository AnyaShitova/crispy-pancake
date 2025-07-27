import java.util.Scanner;

public class Arrows {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность символов: ");
        String input = scanner.nextLine();
        int count = countArrows(input);
        System.out.println("Количество стрелок: " + count);
        scanner.close();
    }
    public static int countArrows(String input){
        int count = 0;
        int n = input.length();
        for (int i=0; i<n-5; i++){
            String substring = input.substring(i, i+5);
            if (substring.equals(">>-->")|| substring.equals("<--<<")){
                count ++;
            }
        }
        return count;
    }
}
