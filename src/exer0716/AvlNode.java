package exer0716;

/**
 * Created by wangsheng on 2017/7/16.
 */
public class AvlNode {

    int data;
    AvlNode left;
    AvlNode right;

    public AvlNode(int data) {
        this.data = data;
    }

    public AvlNode(){

    }

    @Override
    public String toString() {
        return data+"";
    }
}
