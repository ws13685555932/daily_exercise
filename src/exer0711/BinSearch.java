package exer0711;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import exer0709.BubbleSort;
import exer0709.Utils;

/**
 * Created by wangsheng on 2017/7/11.
 */
public class BinSearch {
    /**
     * 二分查找的非递归实现
     * @param a
     * @param value
     * @return
     */
    public static int binSearch(int[] a,int value){
        int left = 0;
        int right = a.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(a[mid] == value){
                return mid;
            }else if(a[mid] > value){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     * @param a
     * @param value
     * @return
     */
    public static int binSearch2(int[] a ,int value){
        return binSort(a,0,a.length-1,value);
    }

    public static int binSort(int[] a,int left , int right , int value){
        if (left <= right){
            int mid = (left+right)/2;
            if(a[mid] == value){
                return mid;
            }else if(a[mid] > value){
                return binSort(a,left,mid-1,value);
            }else{
                return binSort(a,mid+1,right,value);
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int a[] = new int[]{34, 11, 83, 29, 30, 16, 55, 98, 74, 88, 32};

        BubbleSort.bubbleSort(a);

        Utils.printArray(a);

        System.out.println(binSearch2(a,74));
    }
}
