package moneyInWords;

public class MoneyInWords {
    private static long amountInNumbers;
    private static String amountInWords;

    public static void main(String[] args) {
        try {
            GettingMoneyInNumbersFromConsole gettingMoneyInNumbersFromConsole = new GettingMoneyInNumbersFromConsole();
            amountInNumbers = gettingMoneyInNumbersFromConsole.getMoneyInNumbers();

            ConvertingMoneyInWords convertingMoneyInWords = new ConvertingMoneyInWords();
            amountInWords = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);

            System.out.println(amountInWords);
        }
        //повторный вызов кода, в котором исключение
        catch (Exception ex){
            System.out.println( ex.toString());
        }
    }
}
