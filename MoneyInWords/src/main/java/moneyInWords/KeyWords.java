package moneyInWords;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyWords implements InitializationKeyWords{

    static final int DIGITS_COUNT = 10, ONES_COUNT = 20;
    static String[] currencyByCases = {"рубль","рубля","рублей"}; //валюта

    static String[] firstThreeDigitsKeyword = currencyByCases; //ключевые слова для первой справа триады цифр
    static String[] secondThreeDigitsKeyword = {"тысяча","тысячи","тысяч"}; //ключевые слова для второй справа триады цифр
    static String[] thirdThreeDigitsKeyword = {"миллион","миллиона","миллионов"}; //ключевые слова для третьей справа триады цифр
    static String[] fourthThreeDigitsKeyword = {"миллиард","миллиарда","миллиардов"}; //ключевые слова для четвертой справа триады цифр

    static ArrayList<String[]> segmentKeyWords = new ArrayList<String[]>();
    static int[] digitSex = new int[DIGITS_COUNT];
    static  String zero = "нуль";
    static String[] ones = new String[ONES_COUNT];
    static String[] onesForThousands = new String[ONES_COUNT];
    static String[] tens = { "",  "",  "двадцать", "тридцать",  "сорок", "пятьдесят", "шестьдесят",  "семьдесят", "восемьдесят", "девяносто"};
    static String[] hundreds = {"", "сто", "двести",  "триста", "четыреста",  "пятьсот", "шестьсот", "семьсот",  "восемьсот", "девятьсот"};

    static void initDigitWords() {
        List<String> ArrayList1 = new ArrayList<>(Arrays.asList("", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"));

        String[] onesIn = ArrayList1.toArray(new String[0]);
        String[] onesForThousandsIn = ArrayList1.toArray(new String[0]);

        ones = onesIn;
        onesForThousandsIn[1] = "одна";
        onesForThousandsIn[2] = "две";
        onesForThousands = onesForThousandsIn;
    }

    static void initSegmentsKeyWords() {
        segmentKeyWords.add(firstThreeDigitsKeyword);
        segmentKeyWords.add(secondThreeDigitsKeyword);
        segmentKeyWords.add(thirdThreeDigitsKeyword);
        segmentKeyWords.add(fourthThreeDigitsKeyword);
    }

    private static void initDigitSex() {
        digitSex[0] = 2;
        digitSex[1] = 0;
        digitSex[2] = 1;
        digitSex[3] = 1;
        digitSex[4] = 1;
        digitSex[5] = 2;
        digitSex[6] = 2;
        digitSex[7] = 2;
        digitSex[8] = 2;
        digitSex[9] = 2;
    }

    @Override
    public void startInitKeyWords() {
        initSegmentsKeyWords();
        initDigitSex();
        initDigitWords();
    }

    public String[] getOnes() {
        return ones;
    }
    public String[] getOnesForThousands() {
        return onesForThousands;
    }
    public String[] getTens() {
        return tens;
    }
    public String[] getHundreds() {
        return hundreds;
    }
    public int[] getDigitSex() {
        return digitSex;
    }
    public ArrayList<String[]> getSegmentKeyWords() {
        return segmentKeyWords;
    }
    public String getZero() {
        return zero;
    }
}
