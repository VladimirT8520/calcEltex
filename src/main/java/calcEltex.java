import java.util.Scanner;
public class calcEltex {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num1 = in.nextInt();
        System.out.print("Введите число: ");
        int num2 = in.nextInt();
        System.out.print("Введите операцию:");
        char operation = 0;
        if(scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        }
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана.");
        }
        System.out.println("Результат операции: "+result);
    }
}