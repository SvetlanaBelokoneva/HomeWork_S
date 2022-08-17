package unitTests;

import moneyInWords.*;
import java.util.ArrayList;

public class ConvertingMoneyInWordsTest {
    private ConvertingMoneyInWords convertingMoneyInWords = new ConvertingMoneyInWords();
    String actualValue, expectedValue;
    long amountInNumbers ;

    public void testZeroDict() {
        amountInNumbers = 0;
        KeyWords keyWords = new KeyWords();
        keyWords.startInitKeyWords();

        ArrayList<String[]> segmentKeyWords = keyWords.getSegmentKeyWords();
        int[] digitSex = keyWords.getDigitSex();
        String zero = keyWords.getZero();

        final String scenario = "Тест для числа нуль (согласно заполненным ключевым словам)";
        expectedValue = zero + " " + segmentKeyWords.get(0)[digitSex[0]];

        try {
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);
                if (!actualValue.equals(expectedValue)) {
                    throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
                }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
    public void testZero() {
        amountInNumbers = 0;

        final String scenario = "Тест для числа нуль ";
        expectedValue = "нуль рублей";

        try {
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);
            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testSingularPluralForOneDict() {
        KeyWords keyWords = new KeyWords();
        keyWords.startInitKeyWords();

        ArrayList<String[]> segmentKeyWords = keyWords.getSegmentKeyWords();
        int[] digitSex = keyWords.getDigitSex();
        String[] onesForThousandsIn = keyWords.getOnesForThousands();
        String[] onesIn = keyWords.getOnes();

        final String scenario = "Тест единственного/множественного чесла для цифр ОДИН/ОДНА (согласно заполненным ключевым словам)";

        try {
            amountInNumbers = 1000;
            expectedValue = onesForThousandsIn[1] + " " + segmentKeyWords.get(1)[digitSex[1]] + " " + segmentKeyWords.get(0)[digitSex[0]];
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);

            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }

            amountInNumbers = 1000000;
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);
            expectedValue = onesIn[1] + " " + segmentKeyWords.get(2)[digitSex[1]] + " " + segmentKeyWords.get(0)[digitSex[0]];
            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testSingularPluralForTwoDict() {
        KeyWords keyWords = new KeyWords();
        keyWords.startInitKeyWords();

        ArrayList<String[]> segmentKeyWords = keyWords.getSegmentKeyWords();
        int[] digitSex = keyWords.getDigitSex();
        String[] onesForThousandsIn = keyWords.getOnesForThousands();
        String[] onesIn = keyWords.getOnes();

        final String scenario = "Тест единственного/множественного чесла для цифр ДВА/ДВЕ (согласно заполненным ключевым словам)";

        try {
            amountInNumbers = 2000;
            expectedValue = onesForThousandsIn[2] + " " + segmentKeyWords.get(1)[digitSex[2]] + " " + segmentKeyWords.get(0)[digitSex[0]];
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);

            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }

            amountInNumbers = 2000000;
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);
            expectedValue = onesIn[2] + " " + segmentKeyWords.get(2)[digitSex[2]] + " " + segmentKeyWords.get(0)[digitSex[0]];
            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }
            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }


    public void testFor806740958241() {
        final String scenario = "Тест для суммы 6 740 958 241";

        try {
            amountInNumbers = Long.parseLong("806740958241");
            expectedValue = "восемьсот шесть миллиардов семьсот сорок миллионов девятьсот пятьдесят восемь тысяч двести сорок один рубль";
            actualValue = convertingMoneyInWords.convertMoneyInWords(amountInNumbers);

            if (!actualValue.equals(expectedValue)) {
                throw new RuntimeException("Получено [" + expectedValue + "] вместо [" + actualValue + "]");
            }

            System.out.printf("\"%s\" passed %n", scenario);
        }
        catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
