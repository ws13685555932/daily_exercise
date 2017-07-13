package exer0711;


import javafx.application.Preloader;

import java.util.Stack;

/**
 * Created by wangsheng on 2017/7/11.
 *
 *              34
 *           /      \
 *         11       83
 *          \      /  \
 *          29   55   98
 *         /  \   \   /
 *       16   30  74 88
 *             \
 *             32
 *
 */
public class BinTree {

    /**
     * 根据数组创建二叉树
     * @param a
     * @return
     */
    public static BinTreeNode createTreeWithArray(int[] a) {
        BinTreeNode root = new BinTreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            int ele = a[i];

            BinTreeNode p = root;
            while (true) {
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

    /**
     * 先序遍历，非递归
     * @param root
     */
    public static void preOrderTraversal(BinTreeNode root){
        Stack<BinTreeNode> preStack = new Stack<>();
        BinTreeNode p;
        preStack.push(root);
        while (!preStack.isEmpty()){
            p = preStack.pop();
            System.out.print(p.toString() + " ");

            if(p.right != null){
                preStack.push(p.right);
            }
            if(p.left != null){
                preStack.push(p.left);
            }
        }
    }

    /**
     * 先序遍历，递归
     * @param node
     */
    public static void preOrderTraversalRec(BinTreeNode node){
        if(node == null){
            return ;
        }

        System.out.print(node.toString() + " ");
        preOrderTraversalRec(node.left);
        preOrderTraversalRec(node.right);
    }

    /**
     * 中序遍历，非递归
     * @param root
     */
    public static void inOrderTraversal(BinTreeNode root){
        Stack<BinTreeNode> midStack = new Stack<>();
        BinTreeNode p = root;
        while(true){
            while(p!= null){
                midStack.push(p);
                p = p.left;
            }

            if(midStack.isEmpty()){
                break;
            }

            p = midStack.pop();
            System.out.print(p.toString() + " ");

            p = p.right;
        }
    }

    /**
     * 中序遍历，递归
     * @param node
     */
    public static void inOrderTraversalRec(BinTreeNode node){
        if(node == null){
            return ;
        }

        inOrderTraversalRec(node.left);
        System.out.print(node.toString() + " ");
        inOrderTraversalRec(node.right);
    }

    /**
     * 后序遍历，非递归
     * @param root
     */
    public static void postOrderTraversal(BinTreeNode root){
        Stack<BinTreeNode> postStack = new Stack<>();
        Stack<BinTreeNode> outputStack = new Stack<>();
        postStack.push(root);

        while(!postStack.isEmpty()){
            BinTreeNode p = postStack.pop();
            outputStack.push(p);

            if(p.left != null){
                postStack.push(p.left);
            }

            if(p.right != null){
                postStack.push(p.right);
            }
        }

        while(!outputStack.isEmpty()){
            System.out.print(outputStack.pop() + " ");
        }
    }

    /**
     * 后序遍历，递归
     * @param node
     */
    public static void postOrderTraversalRec(BinTreeNode node){
        if(node == null){
            return ;
        }

        postOrderTraversalRec(node.left);
        postOrderTraversalRec(node.right);
        System.out.print(node.toString() + " ");
    }


    public static void main(String[] args) {
        int[] a = new int[]{34, 11, 83, 29, 30, 16, 55, 98, 74, 88, 32};

        BinTreeNode root = createTreeWithArray(a);

        System.out.println("先序遍历：");
        preOrderTraversal(root);
        System.out.println();
        preOrderTraversalRec(root);

        System.out.println();
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraversal(root);
        System.out.println();
        inOrderTraversalRec(root);

        System.out.println();
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraversal(root);
        System.out.println();
        postOrderTraversalRec(root);

    }
}
