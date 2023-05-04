import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestSorted {

    @Test
    public void insertionSort() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        List<Integer> listSorted = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt((10 - 0) + 1) + 0);
        }

        listSorted.addAll(list);
        listSorted.sort(Comparator.naturalOrder());

        list = Main.insertionSort(list);

        Assert.assertTrue(list.equals(listSorted));
    }

    @Test
    public void generateBestCase() {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}));
        List<Integer> listBest = Main.getSortList(5);

        Assert.assertTrue(list.equals(listBest));
    }

    @Test
    public void generateList() {
        List<Integer> listBest = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}));
        List<Integer> listWorst = listBest;
        listWorst.sort(Comparator.reverseOrder());

        List<Integer> randList = Main.generateList(10, 5, 0);

        Assert.assertFalse(randList.equals(listBest));
        Assert.assertFalse(randList.equals(listWorst));
    }

    @Test
    public void worstList() {
        List<Integer> listWorst = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4}));
        listWorst.sort(Comparator.reverseOrder());
        List<Integer> list = Main.getReversList(5);

        Assert.assertTrue(list.equals(listWorst));
    }
}
