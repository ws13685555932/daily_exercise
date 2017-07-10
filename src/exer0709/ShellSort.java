package exer0709;

import java.util.concurrent.ForkJoinPool;

import static exer0709.Utils.getRandomArray;
import static exer0709.Utils.isSorted;
import static exer0709.Utils.printArray;

/**
 * Created by wangsheng on 2017/7/10.
 */
public class ShellSort {

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int[] a) {
        int gap = a.length / 2;

        while (gap >= 1) {
            shellInsert(a, gap);
            gap = gap / 2;
        }
    }

    private static void shellInsert(int[] a, int gap) {
        for (int i = 0; i < gap; i++) {
            for (int j = i+gap; j < a.length; j += gap) {
                int temp = a[j];
                int k = j - gap;
                //插入排序对每个数组进行排序
                for (; k >= i; k-=gap) {
                    if(a[k] >= temp) {
                        a[k + gap] = a[k];
                    }else{
                        break;
                    }
                }
                a[k + gap] = temp;
            }
            printArray(a);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a[] = getRandomArray(10);
        printArray(a);

        System.out.println("-------------------");
        shellSort(a);
        System.out.println("-------------------");

        printArray(a);

        System.out.println(isSorted(a));
    }
}
