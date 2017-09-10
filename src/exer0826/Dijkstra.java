package exer0826;


/**
 * Created by wangsheng on 2017/8/26.
 */
public class Dijkstra {

    public static void dijkstra(Graph g){
        Path[] dist = new Path[g.vertex.length];

        //init dist[0]
        dist[0] = new Path();
        dist[0].length = 0;
        dist[0].prevex = -1;

        //add v0
        g.arcs[0][0] = 1;

        //init v1-vn
        for (int i = 1; i < dist.length; i++) {
            dist[i] = new Path();
            dist[i].length = g.arcs[0][i];
            if(dist[i].length != 99){
                dist[i].prevex = 0;
            }else{
                dist[i].prevex = -1;
            }
        }

        
        for (int i = 0; i < dist.length; i++) {
            //find min in dist[]
            int minWeight = 99;
            int min = 0;
            for (int j = 1; j < dist.length; j++) {
                if(g.arcs[j][j] == 0 &&
                        dist[j].length < minWeight){
                    minWeight = dist[j].length;
                    min = j;
                }
            }

            if(min == 0){
                break;
            }
            
            //add vmin
            g.arcs[min][min] = 1;
            
            //sift path by vmin
            for (int j = 1; j < dist.length; j++) {
                if(g.arcs[j][j] == 0 &&
                        dist[min].length + g.arcs[min][j] < dist[j].length){
                    dist[j].length =  dist[min].length + g.arcs[min][j];
                    dist[j].prevex = min;
                }
            }

            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[j].toString());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        dijkstra(g);
    }
}
