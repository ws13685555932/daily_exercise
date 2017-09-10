package exer0825;

/**
 * Created by wangsheng on 2017/8/25.
 */
public class Graph {
    int[] vertex;
    int[][] arcs;

    public Graph(){
        vertex = new int[]{0,1,2,3,4,5};

        arcs = new int[][]{
                {0,3,99,99,8,9},
                {3,0,1,2,99,4},
                {99,1,0,2,99,99},
                {99,2,2,0,7,6},
                {8,99,99,7,0,10},
                {9,4,99,6,10,0}
        };
    }
}
