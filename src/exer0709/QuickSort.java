package exer0709;


import com.sun.media.sound.RIFFReader;
import sun.font.GlyphLayout;

import static exer0709.Utils.*;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class QuickSort {

    /**
     * 快速排序，选取最左边元素作为基准元素
     * @param a
     */
    public static void quickSort(int[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(int[] a,int left,int right){
        if(left>=right){
            return ;
        }
        //返回排序后pivot所在下标位置
        int pivot = partition(a,left, right);
        Utils.printArray(a);
        sort(a,left,pivot-1);
        sort(a,pivot+1,right);
    }


    public static int partition(int[] a,int left,int right){
        //取最左边的元素作为基准元素
        int pivotValue = a[left];
        //左指针
        int i = left+1;
        //右指针
        int j = right;

        while (true) {
            //左指针从左到右找第一个不小于pivot的元素
            while (a[i] <= pivotValue) {
                //指针移到边界
                if(i == right){
                    break;
                }
                i++;
            }
            //右指针从右往左找第一个不大于pivot的元素
            while (a[j] > pivotValue) {
                //指针移到边界
                if(j == left){
                    break;
                }
                j--;
            }
            //左右指针相遇
            if (i>= j){
                break;
            }
            //交换左右指针指向的元素
            Utils.swap(a,i,j);
            System.out.println("swap:"+i+"<-->"+j);
        }
        //最后交换右指针与pivot
        Utils.swap(a,left,j);
        return j;
    }

    /**
     * 快速排序，选取最右边的元素作为基准元素
     * @param a
     */
    public static void quickSort2(int[] a){
        sort2(a,0,a.length-1);
    }

    private static void sort2(int[] a, int left, int right) {
        if(left >= right){
            return ;
        }

        int pivot = partition2(a,left,right);
        Utils.printArray(a);
        sort2(a,left,pivot-1);
        sort2(a,pivot+1,right);

    }

    private static int partition2(int[] a, int left, int right) {
        //最右元素作为基准元素
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
//        int a[] = {40  ,34 , 19 , 18 , 47 , 42 ,  4 , 24 ,  6 , 11 };
        printArray(a);

        System.out.println("-------------------");
        quick_sort(a,0,a.length-1);
        System.out.println("-------------------");

        printArray(a);

        System.out.println(isSorted(a));
    }

    public static void quick_sort(int[] a ,int low , int high){
        if(low < high) {
            int mid = getMiddle(a, low, high);
            quick_sort(a, low, mid - 1);
            quick_sort(a, mid + 1, high);
        }
    }

    private static int getMiddle(int[] a, int low, int high) {
        int index = low;
        int temp = a[low];

        while(true){
            while(low < high && a[high] > temp){
                high --;
            }
            while(low < high && a[low] <= temp){
                low ++;
            }
            if(low >= high){
                break;
            }
            swap(a,low,high);
        }
        swap(a,index,high);
        return high;
    }


}
