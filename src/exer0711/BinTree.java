package exer0711;

/**
 * Created by wangsheng on 2017/7/11.
 */
public class BinTree {

    public static BinTreeNode createTreeWithArray(int[] a) {
        BinTreeNode root = new BinTreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            int ele = a[i];

            BinTreeNode p = root;
            while (p != null) {
                if (ele < p.data) {
                    if (p.left != null) {
                        p = p.left;
                    } else {
                        p.left = new BinTreeNode(ele);
                        break;
                    }
                } else {
                    if (p.right != null) {
                        p = p.right;
                    } else {
                        p.right = new BinTreeNode(ele);
                        break;
                    }
                }
            }
        }

        return root;
    }

    public static void displayTree(BinTreeNode root){

    }

    public static void main(String[] args) {
        int[] a = new int[]{34, 11, 83, 29, 30, 16, 55, 98, 74, 88, 32};

        BinTreeNode root = createTreeWithArray(a);

        System.out.println(root.left.toString());
    }
}
