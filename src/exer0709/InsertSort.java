package exer0709;

import javax.rmi.CORBA.Util;

/**
 * Created by wangsheng on 2017/7/9.
 */
public class InsertSort {

    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            if(a[i] > a[i- 1]){
                continue;
            }else{
                int ele = a[i];
                for (int j = 0; j < i; j++) {
                    if(a[j] >= ele){
                        for (int k = i; k > j ; k--) {
                            a[k] = a[k-1];
                        }
                        a[j] = ele;
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
        insertSort(a);
        System.out.println("----------------");

        Utils.printArray(a);
        System.out.println(Utils.isSorted(a));
    }
}
