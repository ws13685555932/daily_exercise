package exer0715;

import javax.security.auth.kerberos.DelegationPermission;

/**
 * Created by wangsheng on 2017/7/15.
 */
public class Test {
    public static void main(String[] args) {
        BinSearchTree tree = new BinSearchTree();

        int[] a = {18,10,73,5,27,90,25,41,80,99,32,51,45};

        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }

//        System.out.println(tree.search(18).toString());

//        if(tree.delete(5)){
//            System.out.println("删除成功！");
//        }
//
//        if(tree.delete(10)){
//            System.out.println("删除成功！");
//        }
//
//        if(tree.delete(18)){
//            System.out.println("删除成功！");
//        }

        for (int i = 0; i < a.length-1; i++) {
            tree.delete(a[i]);
        }

    }
}
