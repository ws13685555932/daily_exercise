package exer0709;

import java.util.Random;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class Utils {
    public static void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] getRandomArray(int length){
        Random sc = new Random();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = sc.nextInt(50)+1;
        }
        return a;
    }

    public static boolean isSorted(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }
}
