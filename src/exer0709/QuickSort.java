package exer0709;


import com.sun.media.sound.RIFFReader;

import static exer0709.Utils.getRandomArray;
import static exer0709.Utils.isSorted;
import static exer0709.Utils.printArray;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class QuickSort {

    public static void quickSort(int[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(int[] a,int left,int right){
        if(left>=right){
            return ;
        }

        int pivot = partition(a,left, right);
        sort(a,left,pivot-1);
        sort(a,pivot+1,right);
    }


    public static int partition(int[] a,int left,int right){
        int pivotValue = a[left];
        int pivot = left;

        while (left < right) {
            while (left < right && a[right] > pivotValue) {
                right--;
            }
            while (left < right && a[left] <= pivotValue) {
                left++;
            }
            Utils.swap(a,left,right);
        }
        Utils.swap(a,pivot,right);
        return right;
    }


    public static void quickSort2(int[] a){
        sort2(a,0,a.length-1);
    }

    private static void sort2(int[] a, int left, int right) {
        if(left >= right){
            return ;
        }

        int pivot = partition2(a,left,right);
        sort2(a,left,pivot-1);
        sort2(a,pivot+1,right);

    }

    private static int partition2(int[] a, int left, int right) {
        int pivotValue = a[right];
        int pivot = right;

        while(left < right){
            while(left < right && a[left] < pivotValue) {
                left++;
            }
            while(left < right && a[right] >= pivotValue){
                right -- ;
            }
            Utils.swap(a,left,right);
        }
        Utils.swap(a,left,pivot);
        return right;
    }

    public static void main(String[] args) {
        int a[] = getRandomArray(10);
        printArray(a);

        System.out.println("-------------------");
        quickSort2(a);
        System.out.println("-------------------");

        printArray(a);

        System.out.println(isSorted(a));
    }
}
