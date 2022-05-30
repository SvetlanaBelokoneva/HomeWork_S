import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticОperations {
    public static void main(String[] arguments) {
        try (RemoteCalculation resource = new RemoteCalculation()) {
            startRemoteCalculation(resource);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void startRemoteCalculation(RemoteCalculation resource) {
        int x, y;
        String textForUser = "Для получения результата арифметический действий введите два числа через пробел (например, 3 7): ";
        System.out.println(textForUser);
        Scanner scanner;

        try {
            scanner = new Scanner(System.in);
            x = scanner.nextInt();
            y = scanner.nextInt();

            resource.printMultiply(x, y);
            resource.printDivision(x, y);
            resource.printMinus(x, y);
        }
        //повторный вызов кода, в котором исключение
        catch (InputMismatchException ex){
            System.out.println("Введенные значения должны быть целыми числами: " + ex.toString());
            startRemoteCalculation(resource);
        }
    }
}
