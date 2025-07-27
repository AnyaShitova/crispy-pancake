import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву английского алфавита: ");
        char inputChar = scanner.next().charAt(0);
        char leftChar = getLeftChar(inputChar);
        System.out.println("Символ слева: " + leftChar);
        scanner.close();
    }
    public static char getLeftChar(char c){
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        int index = keyboard.indexOf(c);
        if (index!=-1){
            int leftIndex = (index -1 + keyboard.length())%keyboard.length();
            return keyboard.charAt(leftIndex);
        } else {
            return '?';
        }
    }
}
