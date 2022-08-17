package moneyInWords;

import java.util.ArrayList;
import java.util.Collections;

public class ConvertingMoneyInWords {
    private static ArrayList<String[]> segmentKeyWords = new ArrayList<String[]>();
    private static int[] digitSex;
    private static String zero;
    private static String[] ones;
    private static String[] onesForThousands;
    private static String[] tens;
    private static String[] hundreds;

    private void initKeyWords() {
        KeyWords keyWords = new KeyWords();
        keyWords.startInitKeyWords();
        ones = keyWords.getOnes();
        onesForThousands = keyWords.getOnesForThousands();
        tens = keyWords.getTens();
        hundreds = keyWords.getHundreds();
        digitSex = keyWords.getDigitSex();
        segmentKeyWords = keyWords.getSegmentKeyWords();
        zero = keyWords.getZero();
    }

    private static int getCountIterations(long amount)  {
        String amountString = String.valueOf(amount);
        int countOfInteger = amountString.length() / 3;
        int remainderOfTheDivision = amountString.length() % 3;
        int result;

        if (remainderOfTheDivision == 0) {
            result = countOfInteger;
        } else {
            result = countOfInteger + 1;
        }

        return result;
    }

    public String convertMoneyInWords(long amount) {
        ArrayList segments = new ArrayList();
        ArrayList segmentsInWords = new ArrayList();
        int i = 1, segmentLength;
        long segment;
        String[] segKeyWords;
        String segmentDigitText, keyWordDigitSex, segmentInWords = "", moneyInWords = "";
        String segmentText1 = "", segmentText2 = "", segmentText3 = "";

        initKeyWords();

        //нуль вынести в исключение
        if (amount==0 && String.valueOf(amount).length() == 1) {
            segmentInWords = zero + " " + segmentKeyWords.get(0)[digitSex[0]];
            return segmentInWords;
        }

        int countIterations = getCountIterations(amount);

        //разбиение суммы на сегменты по 3 цифры с конца
        while (i <= countIterations) {
            segment = amount/1000;
            segments.add(amount - (segment * 1000));
            amount = segment;
            i++;
        }

        //анализ сегментов
        for (int j = 0; j < segments.size(); j++ ) {
            String[] onesForSegment;
            //для раздела тысяч использовать слова "одна", "две", а не "один", "два"
            if (j==1) {
                onesForSegment = onesForThousands;
            } else {
                onesForSegment = ones;
            }

            segmentDigitText = segments.get(j).toString(); //сегмент из 3-х цифр
            segmentLength = segmentDigitText.length(); //длина сегмента
            segmentText3 = String.valueOf(segmentDigitText.charAt(segmentDigitText.length() - 1)); //последняя цифра в триаде

            if (segmentLength>1) {
                segmentText2 = String.valueOf(segmentDigitText.charAt(segmentDigitText.length() - 2)); //средняя цифра в триаде

                if (segmentText2.equals("1")) {
                    segmentInWords = onesForSegment[Integer.parseInt(segmentText2 + segmentText3)];
                } else {
                    segmentInWords = tens[Integer.parseInt(segmentText2)] + " " + onesForSegment[Integer.parseInt(segmentText3)];
                }
            } else {
                segmentInWords = onesForSegment[Integer.parseInt(segmentText3)];
            }

            if (segmentLength>2) {
                segmentText1 = String.valueOf(segmentDigitText.charAt(segmentDigitText.length() - 3)); //первая цифра в триаде
                segmentInWords = hundreds[Integer.parseInt(segmentText1)] +  " " + segmentInWords;
            }

            segKeyWords = segmentKeyWords.get(j);

            if (segmentDigitText.equals("0")&segmentLength==1&j!=0) {
                segmentInWords = segmentInWords +  " ";
            } else {
                if (segmentText2.equals("1")) {
                    keyWordDigitSex = segKeyWords[digitSex[0]];
                } else {
                    keyWordDigitSex = segKeyWords[digitSex[Integer.parseInt(segmentText3)]];
                }
                segmentInWords = segmentInWords +  " " + keyWordDigitSex;
            }

            segmentsInWords.add(segmentInWords);
        }

        Collections.reverse(segmentsInWords);

        for (int j = 0; j < segmentsInWords.size(); j++ ) {
            moneyInWords = moneyInWords + " " + segmentsInWords.get(j).toString();
        }
        moneyInWords = moneyInWords.trim().replaceAll("\\s+", " ");

        return moneyInWords;
    }
}
