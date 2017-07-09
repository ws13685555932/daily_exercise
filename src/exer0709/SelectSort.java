package exer0709;

import static exer0709.Utils.*;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class SelectSort {

    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            swap(a, minIndex, i);
            printArray(a);
        }
    }

    public static void selectSortImpv(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i + 1; j < a.length - i; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
                if (a[j] >= a[maxIndex]) {
                    maxIndex = j;
                }
            }
            System.out.println("min:" + minIndex + "---max:" + maxIndex);
            swap(a, minIndex, i);
            if (maxIndex == i) {
                swap(a, a.length - i - 1, minIndex);
            } else {
                swap(a, a.length - i - 1, maxIndex);
            }

            printArray(a);
        }
    }

    public static void main(String[] args) {
        int a[] = getRandomArray(10);
//        int[] a = new int[]{21, 8, 44, 14, 9, 12, 45, 20, 22, 14};
        printArray(a);

        System.out.println("-------------------");
        selectSortImpv(a);
        System.out.println("-------------------");

        printArray(a);

        System.out.println(isSorted(a));
//        if(isSorted(a)){
//            System.out.println("排序成功");
//        }
    }
}
