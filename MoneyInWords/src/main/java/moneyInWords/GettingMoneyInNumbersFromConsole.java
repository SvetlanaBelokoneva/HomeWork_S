package moneyInWords;

import java.util.Scanner;

public class GettingMoneyInNumbersFromConsole implements GettingMoneyInNumbers {
    @Override
    public long getMoneyInNumbers() {
        long amount;

        try {
            amount = askMoneyInNumbers2();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return amount;
    }
    private static long askMoneyInNumbers2() throws Exception {
        long amount;

        try {
            amount = askMoneyInNumbers();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            amount = askMoneyInNumbers();
        }

        return amount;
    }
    private static long askMoneyInNumbers() throws Exception {
        long userNumbers;

        Scanner scan = new Scanner(System.in);
        String textForUser = "Введите сумму цифрами: ";
        System.out.println(textForUser);

        //Считывание с консоли ответа
        while (!scan.hasNextLong()) {
            System.out.println("Введенное значение не является целым числом типа Long.");
            scan.nextLong();
        }
        userNumbers = scan.nextLong();

        if(String.valueOf(userNumbers).length() >= 12) throw new Exception("Введенное число слишком велико для конвертации");
        if(userNumbers < 0) throw new Exception("Введенное число не может быть отрицательным");

        return userNumbers;
    }
}
