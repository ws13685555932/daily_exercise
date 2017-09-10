package exer0709;

import javax.rmi.CORBA.Util;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class InsertSort {

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a){
        //第一个元素不用操作，循环从1开始
        for (int i = 1; i < a.length; i++) {
            //如果当前元素大于前一个元素，那么已经是有序的，不作处理
            if(a[i] > a[i- 1]){
                continue;
            }else{
                //将当前元素取出
                int temp = a[i];
                //在当前元素前逐个查找该元素应该放置的位置
                for (int j = 0; j < i; j++) {
                    if(a[j] >= temp){
                        //当前元素应该被放在下标j的位置，将下标j之后的所有元素往后移位，以把下标j位置空出来
                        for (int k = i; k > j ; k--) {
                            a[k] = a[k-1];
                        }
                        //将当前元素放在下标j位置
                        a[j] = temp;
                        break;
                    }
                }
            }

            Utils.printArray(a);
        }
    }

    public static void main(String[] args) {
        int[] a = Utils.getRandomArray(10);

        Utils.printArray(a);
        System.out.println("----------------");
        insert_sort(a);
        System.out.println("----------------");

        Utils.printArray(a);
        System.out.println(Utils.isSorted(a));
    }

    public static void insert_sort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            if(a[i] < a[i-1]){
                while(i>0 && temp < a[i-1]){
                    a[i] = a[i-1];
                    i--;
                }
            }
            a[i] = temp;
        }
    }
}
