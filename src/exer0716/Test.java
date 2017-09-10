package exer0716;

/**
 * Created by wangsheng on 2017/7/16.
 */
public class Test {
    public static void main(String[] args) {
        int a[] = new int[]{3,2,1,4,5,6,7,16,15,14};

        AvlTree tree = new AvlTree();
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
    }
}
