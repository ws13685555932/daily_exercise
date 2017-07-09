package exer0706;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangsheng on 2017/7/6.
 */
public class MyStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }

    public int size(){
        return queue1.size();
    }

    public T push(T t){
        queue1.offer(t);
        return t;
    }

    public T pop(){
        if(queue1.size()<1){
            System.out.println("空栈不能执行pop操作！");
            return null;
        }else {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            T top = queue1.poll();
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            return top;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("空栈");
        }else {
            System.out.print("栈顶|");
            for (int i = 0; i < queue1.size(); i++) {
                while (queue1.size() != 1) {
                    queue2.offer(queue1.poll());
                }
                System.out.print(" " + queue1.peek() + " ");
                while (!queue2.isEmpty()) {
                    queue1.offer(queue2.poll());
                }
            }
            System.out.print("|栈底");
            System.out.println();
        }
    }
}
