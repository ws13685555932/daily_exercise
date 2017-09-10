package exer0730;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by wangsheng on 2017/7/30.
 */

class MoveAction {
    private int from;
    private int to;
    private int water;

    public MoveAction(int from, int to, int water) {
        this.from = from;
        this.to = to;
        this.water = water;
    }

    @Override
    public String toString() {
        return  from + " ->" + to + ":" + water;
    }
}

class State {
    int[] glass;
    MoveAction action;

    public State(int[] glass ,MoveAction action) {
        this.glass = glass;
        this.action = action;
    }

    public State() {
    }

    @Override
    public String toString() {
        return "State{" +
                "glass=" + Arrays.toString(glass) +
                ", action=" + action +
                '}';
    }
}

class TreeNode {
    State data;
    TreeNode next;
    TreeNode child;

    public TreeNode(State data) {
        this.data = data;
    }

    public TreeNode() {
        this.data = new State();
    }
}


public class exer730 {
    public static void main(String[] args) {
        List<State> stateList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode root = new TreeNode();

        root.data.action = new MoveAction(-1, 1, 8);
        root.data.glass = new int[]{8, 0, 0};

        TreeNode p = root;

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] glass = p.data.glass;
                int water = pourWater(p.data.glass, i, j);
                if(water != -1) {
                    count++;
                    MoveAction action = new MoveAction(i,j,water);
                    State state = new State(p.data.glass,action);
                    stateList.add(state);
                    TreeNode node = new TreeNode(state);
                    if(count == 1){
                        p.child = node;
                    }else{
                        p.next = node;
                    }
                    p = node;
                }
            }
        }

        int b = 1;

    }

    public static int pourWater(int[] data, int from, int to) {
        if (data[to] >= capacity(to) || from == to || data[from] == 0) {
            return -1;
        } else {
            int left = capacity(to) - data[to];
            int water = Math.min(left,data[from]);
            data[from] -= water;
            data[to] += water;

            return water;
        }
    }

   public static int capacity(int index){
        if(index == 0){
            return 8;
        }else if(index == 1){
            return 5;
        }else if(index == 2){
            return 3;
        }
        return -1;
   }


}
































