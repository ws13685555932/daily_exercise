package exer0709;

import java.util.concurrent.ForkJoinPool;

import static exer0709.Utils.getRandomArray;
import static exer0709.Utils.isSorted;
import static exer0709.Utils.printArray;
import static jdk.nashorn.internal.objects.NativeArray.sort;

/**
 * Created by wangsheng on 2017/7/10.
 */
public class ShellSort {

    /**
     * 希尔排序
     * @param a
     */
    public static void shellSort(int[] a) {
        int h = a.length / 2;

        while (h >= 1) {
            shellInsert(a, h);
            h = h / 2;
        }
    }

    private static void shellInsert(int[] a, int h) {
        //分别对每个子数组操作
        for (int i = 0; i < h; i++) {
            //每个子数组进行插入排序
            for (int j = i+h; j < a.length; j += h) {
                int temp = a[j];
                int k = j - h;
                //找到当前元素应该被插入的位置j
                for (; k >= i; k-=h) {
                    if(a[k] >= temp) {
                        a[k + h] = a[k];
                    }else{
                        break;
                    }
                }
                //将当前元素放入插入位置
                a[k + h] = temp;
            }
            printArray(a);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a[] = getRandomArray(11);
        printArray(a);

        System.out.println("-------------------");
//        shellSort(a);
        shell_sort(a);
        System.out.println("-------------------");

        printArray(a);

        System.out.println(isSorted(a));
    }

    private static void shell_sort(int[] a) {
        int gap = a.length;
        while(true){
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i+gap; j < a.length; j+=gap) {
                    int temp = a[j];
                    while(j>i && temp < a[j-gap]){
                        a[j] = a[j-gap];
                        j-=gap;
                    }
                    a[j] = temp;
                }
            }
            if(gap == 1){
                break;
            }
        }
    }
    
}
