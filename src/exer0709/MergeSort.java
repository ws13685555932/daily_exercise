package exer0709;

/**
 * Created by wangsheng on 2017/7/10.
 */
public class MergeSort {

    /**
     * 归并排序
     * @param a
     */
    public static void mergeSort(int[] a){
        sort(a,0,a.length-1);
    }


    private static void sort(int[] a,int left,int right){
        if(left == right){
            return ;
        }
        System.out.println("sort(a," + left + "," + right +")");
        int mid = (left + right) / 2;

        //对左半边进行排序
        sort(a,left,mid);
        //右半边
        sort(a,mid+1,right);
        //将左右两个数组合并
        merge(a,left,mid,right);
    }

    /**
     * 归并操作
     * @param a     数组
     * @param left  第一个子数组首元素下标
     * @param mid   第一个子数组尾元素下标
     * @param right 第二个子数组尾元素下标
     */
    private static void merge(int[] a, int left, int mid, int right) {
        System.out.println("merge(a,"+left+","+mid+","+right+")");
        //临时数组用于保存合并后的数组
        int[] temp = new int[right - left +1];
        //指向左边数组的指针
        int first  = left;
        //指向右边数组的指针
        int second = mid+1;
        //临时数组的指针
        int tempIndex = 0;

        while(first <= mid && second <= right) {
            if (a[first] <= a[second]) {
                temp[tempIndex] = a[first];
                tempIndex++;
                first++;
            } else {
                temp[tempIndex] = a[second];
                second++;
                tempIndex++;
            }
        }

        //如果一个数组已经全部加入到临时数组中，另一个数组剩下的部分直接放到临时数组后
        if(first == (mid+1)){
            for(;second<= right;second++){
                temp[tempIndex] = a[second];
                tempIndex++;
            }
        }

        if(second == (right+1)){
            for(;first<= mid;first ++){
                temp[tempIndex] = a[first];
                tempIndex++;
            }
        }

        //将临时数组的值赋给原数组
        for (int i = 0; i < temp.length; i++) {
            a[i+left] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = Utils.getRandomArray(16);

        Utils.printArray(a);
        System.out.println("----------------");
        mergeSort(a);
        System.out.println("----------------");

        Utils.printArray(a);
        System.out.println(Utils.isSorted(a));
    }
}
