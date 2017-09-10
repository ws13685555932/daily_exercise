package exer0709;

import java.util.Random;

/**
 * 工具类，常用的方法
 * Created by wangsheng on 2017/7/9.
 */
public class Utils {
    /**
     * 交换数组下标i和j的值
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array,int min,int iIndex){
        System.out.printf(" %1d ",iIndex);
        System.out.printf("  %1d  ",min);
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %2d ",array[i]);
        }
        System.out.println();
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %2d ",array[i]);
        }
        System.out.println();
    }

    /**
     * 产生一个随机数组
     * @param length 数组长度
     * @return
     */
    public static int[] getRandomArray(int length){
        Random sc = new Random();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = sc.nextInt(50)+1;
        }
        return a;
    }

    /**
     * 判断数组是否是从小打大有序的
     * @param a
     * @return
     */
    public static boolean isSorted(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){
                return false;
            }
        }
        return true;
    }
}

