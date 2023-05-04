import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = generateList(50, 1000, 0);
        long start = System.currentTimeMillis();
        List<Integer> listSort = insertionSort(list);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println("Exp1 random list:");
        System.out.println(list);
        System.out.println("Sorted: ");
        System.out.println(listSort);
        System.out.println("Время сортировки: " + elapsed + " mils");

        System.out.println();
        System.out.println("Exp2 sort list:");
        list = getSortList(1000);
        System.out.println(list);
        System.out.println("Sorted: ");
        start = System.currentTimeMillis();
        listSort = insertionSort(list);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println(listSort);
        System.out.println("Время сортировки: " + elapsed + " mils");

        System.out.println();
        System.out.println("Exp3 revers list:");
        list = getReversList(1000);
        System.out.println(list);
        System.out.println("Sorted: ");
        start = System.currentTimeMillis();
        listSort = insertionSort(list);
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println(listSort);
        System.out.println("Время сортировки: " + elapsed + " mils");
    }

    public static List<Integer> insertionSort(List<Integer> sortArr) {
        List<Integer> list = new ArrayList<>(sortArr);

        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < list.size(); i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = list.get(i);
            for (j = i; j > 0 && swap < list.get(j - 1); j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                list.set(j, list.get(j - 1));
            }
            list.set(j, swap);
        }
        return list;
    }

    public static List<Integer> getSortList(int size) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        return list;
    }

    public static List<Integer> getReversList(int size) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(size - i);
        }

        return list;
    }

    public static List<Integer> generateList(int max, int size, int repeat) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < repeat + 1; i++) {
            list.clear();
            for (int j = 0; j < size; j++) {
                list.add(rand.nextInt((max - 0) + 1) + 0);
            }
        }

        return list;
    }
}
