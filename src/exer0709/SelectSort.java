package exer0709;

import static exer0709.Utils.*;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class SelectSort {

    /**
     * 选择排序，每次循环选择最小的进行交换
     * @param a
     */
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
//            Utils.printArray(a);
            //记录当前循环中最小元素的下标
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //交换
            Utils.swap(a, minIndex, i);
            Utils.printArray(a,minIndex,i);
        }
    }

    /**
     * 选择排序优化，一次循环选择最小值和最大值做两次交换
     * @param a
     */
    public static void selectSortImpv(int[] a) {
        //循环次数为原先的一半
        for (int i = 0; i < a.length / 2; i++) {
            //最小元素的下标
            int minIndex = i;
            //最大元素的下标
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
            //交换最小元素
            Utils.swap(a, minIndex, i);
            /**
             * 如果maxIndex处于当前循环被交换位置，比如：
             *          2 | 45 23 4 15 | 87
             * 已排序部分  | 未排序部分   |已排序部分
             * minIndex = 3 , maxIndex = 1
             * 先将45与最小值4交换，交换后，
             *          2  4  23  45  15  87
             * 这时最大值下标1就不是最大值了，最大值应该是minIndex所在位置
             */
            if (maxIndex == i) {
                Utils.swap(a, a.length - i - 1, minIndex);
            } else {
                Utils.swap(a, a.length - i - 1, maxIndex);
            }

            Utils.printArray(a);
        }
    }

    public static void main(String[] args) {
//        int a[] = Utils.getRandomArray(10);
        int a[] = {40  ,34 , 19 , 18 , 47 , 42 ,  4 , 24 ,  6 , 11 };
        Utils.printArray(a);

        System.out.println("-------------------");
//        selectSort(a);
        select_sort(a);
        System.out.println("-------------------");

        Utils.printArray(a);

        System.out.println(isSorted(a));
    }

    public static void select_sort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a,min,i);
        }
    }
}
