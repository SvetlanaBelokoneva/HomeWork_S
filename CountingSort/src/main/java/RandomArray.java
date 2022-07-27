import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class RandomArray {
    private final static int MIN_ARRAY_DIMENSION = 1, MAX_ARRAY_DIMENSION = 1000000;
    private static int userOpinion;

    public static void main(String[] args) {
    }

    //определение размерности массива-----------------------------------------------------------------------------------
    static int getArrayDimension() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Задайте величину массива (от "+MIN_ARRAY_DIMENSION+" до "+MAX_ARRAY_DIMENSION+"): ");
        try {
            //Считывание с консоли ответа
            while (!scan.hasNextInt()) {
                System.out.println("Вы ввели не целое число. Задайте величину массива: ");
                scan.next();
            }
            userOpinion = scan.nextInt();

            if(userOpinion > MAX_ARRAY_DIMENSION || userOpinion < MIN_ARRAY_DIMENSION) throw new Exception("Число должно быть в диапазоне от "+MIN_ARRAY_DIMENSION+" до "+MAX_ARRAY_DIMENSION);

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return userOpinion;
    }

    //формирование массива случайных чисел заданной величины------------------------------------------------------------
    static ArrayList<Integer> setRandomArray(int arrayDimension) {
        Random rnd = new Random();
        ArrayList<Integer> notSortedArrayList = new ArrayList<Integer>();

        for (int i = 0; i < arrayDimension; i++)
        {
            notSortedArrayList.add(rnd.nextInt(100));
        }
        return notSortedArrayList;
    }

    //вывод на экран массива---------------------------------------------------------------------------
    static void printArray(ArrayList<Integer> arrayList) {
        System.out.println(arrayList);
    }
}
