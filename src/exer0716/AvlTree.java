package exer0716;

import java.util.Stack;

/**
 * Created by wangsheng on 2017/7/16.
 */
public class AvlTree {

    private AvlNode mRoot;

    public AvlTree(AvlNode mRoot) {
        this.mRoot = mRoot;
    }

    public AvlTree(){

    }

    public int height(AvlNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        return Math.max(height(node.left),height(node.right))+1;
    }

    public AvlNode leftLeftRotation(AvlNode node){
        AvlNode left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }

    public AvlNode rightRightRotation(AvlNode node){
        AvlNode right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }

    public AvlNode leftRightRotatioin(AvlNode node){
        node.left = rightRightRotation(node.left);
        return leftLeftRotation(node);
    }

    public AvlNode rightLeftROtation(AvlNode node){
        node.right = leftLeftRotation(node.right);
        return rightRightRotation(node);
    }

    public void insert(int value){
        AvlNode p = mRoot;

        if(p == null){
            mRoot = new AvlNode(value);
            return;
        }

        Stack<AvlNode> pathStack = new Stack<>();
        pathStack.push(mRoot);
        while(true){
            if(value > p.data){
                if(p.right != null) {
                    pathStack.push(p.right);
                    p = p.right;
                }else{
                    p.right = new AvlNode(value);
                    break;
                }
            }else if(value < p.data){
                if(p.left != null) {
                    pathStack.push(p.left);
                    p = p.left;
                }else{
                    p.left = new AvlNode(value);
                    break;
                }
            }else{
                return ;
            }
        }

        while(!pathStack.isEmpty()){
            AvlNode node = pathStack.pop();
            AvlNode parent;
            if(pathStack.isEmpty()){
                parent = mRoot;
            }else{
                parent = pathStack.peek();
            }
            modify(node,parent,value);
        }

    }

    private void modify(AvlNode node,AvlNode parent,int value) {
        if(height(node.left) - height(node.right) == 2){
            if(value < node.left.data){
                if(parent.left == node) {
                    parent.left = leftLeftRotation(node);
                }else{
                    parent.right = leftLeftRotation(node);
                }
            }else{
                if(parent.left == node) {
                    parent.left = leftRightRotatioin(node);
                }else{
                    parent.right = leftRightRotatioin(node);
                }
            }
        }else if(height(node.right) - height(node.left) == 2){
            if(value < node.right.data){
                if(parent.left == node) {
                    parent.left = rightLeftROtation(node);
                }else{
                    parent.right = rightLeftROtation(node);
                }
            }else{
                if(parent.left == node) {
                    parent.right = rightRightRotation(node);
                }else{
                    parent.right = rightRightRotation(node);
                }
            }
        }
    }

    public AvlNode getRoot(){
        return mRoot;
    }
}


























