package exer0706;

import java.util.Stack;

/**
 * Created by wangsheng on 2017/7/6.
 */
public class MyQueue<T> {
    private Stack<T> stack1 ;
    private Stack<T> stack2 ;

    public MyQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    public T enQueue(T t){
        stack1.push(t);
        return t;
    }

    public T deQueue(){
        if(stack1.isEmpty()){
            System.out.println("空队列不能执行deQueue操作！");
            return null;
        }else {
            stack2.clear();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            T deQueueEle = stack2.pop();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return deQueueEle;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("空队列！");
        }else {
            stack2.clear();
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            System.out.print("队列头|");
            while (!stack2.isEmpty()) {
                System.out.print(" " + stack2.peek() + " ");
                stack1.push(stack2.pop());
            }
            System.out.print("|队列尾");
            System.out.println();
        }
    }
}
