package exer0711;

/**
 * Created by wangsheng on 2017/7/11.
 */
public class BinTreeNode {
    BinTreeNode left;
    BinTreeNode right;
    int data;

    public BinTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinTreeNode(){
        this(0);
    }

    @Override
    public String toString() {
        return "data:" + this.data;
    }
}
