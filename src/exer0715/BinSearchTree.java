package exer0715;

import java.lang.management.PlatformLoggingMXBean;
import java.time.temporal.ValueRange;

/**
 * Created by wangsheng on 2017/7/15.
 */
public class BinSearchTree {

    BinSearchTreeNode mRoot;

    public BinSearchTree(BinSearchTreeNode mRoot) {
        this.mRoot = mRoot;
    }

    public BinSearchTree() {
    }

    public void insert(int value) {

        if (mRoot == null) {
            mRoot = new BinSearchTreeNode(value);
        }

        BinSearchTreeNode p = mRoot;

        while (true) {
            if (value == p.data) {
                return;
            } else if (value < p.data) {
                if (p.left == null) {
                    p.left = new BinSearchTreeNode(value);
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = new BinSearchTreeNode(value);
                } else {
                    p = p.right;
                }
            }
        }
    }

    public BinSearchTreeNode search(int value) {

        if (mRoot == null) {
            return null;
        }

        BinSearchTreeNode p = mRoot;

        while (p != null) {
            if (value == p.data) {
                return p;
            } else if (value < p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return null;

    }

    public boolean delete(int value) {
        if (search(value) == null) {
            return false;
        }

        BinSearchTreeNode p = mRoot;
        BinSearchTreeNode parent = mRoot;

        while (true) {
            if (value == p.data) {
                break;
            } else if (value < p.data) {
                parent = p;
                p = p.left;
            } else {
                parent = p;
                p = p.right;
            }
        }
        if (p.left == null && p.right == null) {
            if (parent.left == p) {
                parent.left = null;
            } else if (parent.right == p) {
                parent.right = null;
            } else if(parent == p){
                mRoot = null;
            }
        }else if(p.left != null && p.right == null){
            if(parent == p){
                mRoot = p.left;
            }else if(parent.left == p){
                parent.left = p.left;
            }else if(parent.right == p){
                parent.right = p.left;
            }
        }else if(p.right != null && p.left == null){
            if(parent == p){
                mRoot = p.right;
            }else if(parent.left == p){
                parent.left = p.right;
            }else if(parent.right == p){
                parent.right = p.right;
            }
        }else{
            BinSearchTreeNode q = p.left;
            while (q.right != null) {
                q = q.right;
            }
            q.right = p.right;
            if(parent == p) {
                mRoot = p.left;
            } else if(parent.left == p){
                parent.left = p.left;
            } else if(parent.right == p){
                parent.right = p.left;
            }
        }
        return true;
    }
}

























