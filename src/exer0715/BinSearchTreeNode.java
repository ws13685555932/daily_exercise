package exer0715;


/**
 * Created by wangsheng on 2017/7/15.
 */
public class BinSearchTreeNode {
    BinSearchTreeNode left;
    BinSearchTreeNode right;
    int data;

    public BinSearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinSearchTreeNode(){

    }

    @Override
    public String toString() {
        return data+"";
    }

    public int getData(){
        return this.data;
    }

    @Override
    public boolean equals(Object obj) {
        BinSearchTreeNode node = ((BinSearchTreeNode) obj);
        return node.data == this.data;
    }
}
