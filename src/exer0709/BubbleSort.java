package exer0709;

import javax.rmi.CORBA.Util;
import java.util.Random;
import java.util.Scanner;

import static exer0709.Utils.getRandomArray;
import static exer0709.Utils.printArray;
import static exer0709.Utils.swap;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class BubbleSort {

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
            printArray(array);
        }
    }


    public static void main(String[] args) {
        int[] a = getRandomArray(10);

        printArray(a);
        System.out.println("-----------------");

        bubbleSort(a);

        System.out.println("-----------------");
        printArray(a);
    }
}





















