package exer0826;

/**
 * Created by wangsheng on 2017/8/25.
 */
public class Graph {
    int[] vertex;
    int[][] arcs;

    public Graph(){
        vertex = new int[]{0,1,2,3,4,5};

        arcs = new int[][]{
                {0,50,10,99,45,99},
                {99,0,15,99,5,99},
                {20,99,0,15,99,99},
                {99,20,99,0,35,99},
                {99,99,99,30,0,99},
                {99,99,99,3,99,0}
        };
    }
}
