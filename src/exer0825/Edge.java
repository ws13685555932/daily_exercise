package exer0825;

/**
 * Created by wangsheng on 2017/8/25.
 */
public class Edge {
    int startVex;
    int stopVex;
    int weight;

    @Override
    public String toString() {
        return "(" + startVex +
                "," + stopVex +
                "," + weight +
                ')';
    }
}
