import unitTests.*;

public class AllTests {
    public static void main(String[] args) {
        System.out.println("----------------------");

        new ConvertingMoneyInWordsTest().testZeroDict();
        new ConvertingMoneyInWordsTest().testZero();
        new ConvertingMoneyInWordsTest().testSingularPluralForOneDict();
        new ConvertingMoneyInWordsTest().testSingularPluralForTwoDict();
        new ConvertingMoneyInWordsTest().testFor806740958241();
    }
}
