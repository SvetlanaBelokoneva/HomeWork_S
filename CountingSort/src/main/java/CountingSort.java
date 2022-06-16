import java.util.ArrayList;
import java.util.Date;

//сортировка методом подсчета
public class CountingSort {

    public static void main(String[] args) {
        ArrayList<Integer> randomArray;
        ArrayList<Integer> sortedArrayList;

        //определение размерности массива
        int arrayDimension = RandomArray.getArrayDimension();

        //формирование массива случайных чисел заданной величины
        randomArray = RandomArray.setRandomArray(arrayDimension);

        //вывод на экран несортированного массива
        RandomArray.printArray(randomArray);

        //сортировка массива + вывод на экран ортированного массива
        sortArrayWithTimePrint(randomArray);

        //сортировка массива + вывод на экран ортированного массива
        CollectionsSort.sortArrayWithTimePrint(randomArray);
    }

    //сортировка массива------------------------------------------------------------------------------------------------
    private static ArrayList<Integer> getSortArray(ArrayList<Integer> notSortedArrayList) {
        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        ArrayList<Integer> sortRandomArray = new ArrayList<Integer>();

        for (int i = 0; i < notSortedArrayList.stream().count(); i++) {
            indexArray.add(i,0);
            sortRandomArray.add(i,null);
        }

        //в indexArray[i] записывается позиция i-го элемента в отсортированнм массиве
        for (int i = 0; i < notSortedArrayList.stream().count() - 1; i++) {
            for (int j = i + 1; j < notSortedArrayList.stream().count(); j++) {
                if (notSortedArrayList.get(i) > notSortedArrayList.get(j)) {
                    indexArray.set(i, indexArray.get(i) + 1);
                }
                else {
                    indexArray.set(j, indexArray.get(j) + 1);
                }
            }

        }

        for (int i = 0; i < notSortedArrayList.stream().count(); i++) {
            sortRandomArray.set(indexArray.get(i), notSortedArrayList.get(i));
        }

        return sortRandomArray;
    }


    //сортировка массива c демонстрацией временных затрат---------------------------------------------------------------
    private static void sortArrayWithTimePrint(ArrayList<Integer> notSortedArrayList) {
        Date start_time = new Date();
        //сортировка массива
        ArrayList<Integer> sortedArrayList = getSortArray(notSortedArrayList);
        Date end_time = new Date();

        //вывод на экран ортированного массива
        RandomArray.printArray(sortedArrayList);

        System.out.println("Java sort time by counting sort = " + (end_time.getTime() - start_time.getTime()));
    }
}
