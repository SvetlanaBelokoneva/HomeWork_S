import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class CollectionsSort {

    public static void main(String[] args) {
    }

    //сортировка массива c демонстрацией временных затрат---------------------------------------------------------------
    static void sortArrayWithTimePrint(ArrayList<Integer> notSortedArrayList) {
        Date start_time = new Date();
        //сортировка массива
        //сортировка массива
        Collections.sort(notSortedArrayList);
        Date end_time = new Date();

        System.out.println("Java sort time by collections sort = " + (end_time.getTime() - start_time.getTime()));
    }
}
