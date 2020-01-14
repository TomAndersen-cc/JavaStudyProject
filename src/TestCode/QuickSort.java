package TestCode;

import java.util.Arrays;

/**
 * @Author TomAndersen
 * @Date 2020/1/8
 * @Version
 * @Description
 */
public class QuickSort {

    // 从小到大
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int p = core(array, start, end);
            quickSort(array, start, p - 1);
            quickSort(array, p + 1, end);
        }
    }

    private static int core(int[] a, int start, int end) {

        int i = start, j = end - 1;
        int x = a[end];
        while (i < j) {
            while (a[i] <= x && i < j) i++;
            while (a[j] >= x && i < j) j--;
            swap(a, i, j);
        }
        swap(a, i, end);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 从大到小
    public static void quickSort_1(int[] array, int start, int end) {
        if (start < end) {
            int p = core_1(array, start, end);
            quickSort_1(array, start, p - 1);
            quickSort_1(array, p + 1, end);
        }
    }

    private static int core_1(int[] a, int start, int end) {
        int i = start;
        int x = a[end];
        for (int j = end - 1; j >= i; ) {
            if (a[j] > x) {
                swap(a, i, j);
                i++;
            } else j--;
        }
        swap(a, i, end);
        return i;
    }

    public static void main(String[] args) {
        int a[] = {3, 24, 11, 55, 32, 43, 11};
        int a1[] = {3, 24, 11, 55, 32, 43, 11};
        quickSort(a, 0, a.length - 1);
        quickSort_1(a1, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a1));
        double x = 13;
        int y = 13;
        System.out.println(x == y);

    }
}
