package exer0825;

/**
 * Created by wangsheng on 2017/8/25.
 */
public class Prim {
    public static void prim(Graph g){
        int vexNum = g.vertex.length;
        Edge[] mst = new Edge[vexNum-1];

        //init mst
        for (int i = 0; i < mst.length; i++) {
            mst[i] = new Edge();
            mst[i].startVex = 0;
            mst[i].stopVex = i+1;
            mst[i].weight = g.arcs[0][i+1];
        }

        for (int i = 0; i < mst.length; i++) {
            //find mst[min]
            int min = i;
            int minWeight = 99;
            for (int j = i; j < mst.length; j++) {
                if(mst[j].weight < minWeight){
                    min = j;
                    minWeight = mst[j].weight;
                }
            }

            //swap mst[min] and mst[i]
            if(min != i){
                Edge temp = mst[i];
                mst[i] = mst[min];
                mst[min] = temp;
            }

            //vi add to U,sift mst[i+1] to mst[n-2]
            int vx = mst[i].stopVex;

            for (int j = i+1; j < mst.length; j++) {
                int vy = mst[j].stopVex;
                if(mst[j].weight > g.arcs[vx][vy]){
                    mst[j].weight = g.arcs[vx][vy];
                    mst[j].startVex = vx;
                }
            }



            for (int j = 0; j < mst.length; j++) {
                System.out.print(mst[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        prim(graph);
    }
}
