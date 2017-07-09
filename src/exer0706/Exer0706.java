package exer0706;

/**
 * Created by wangsheng on 2017/7/6.
 */
public class Exer0706 {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enQueue("hello");
        queue.enQueue("world");
        queue.enQueue("java");

        queue.display();
        System.out.println("size:" + queue.size());
        System.out.println("isEmpty:" + queue.isEmpty());

        System.out.println("----------------------------");

        queue.enQueue("android");
        queue.display();
        System.out.println("size:" + queue.size());
        System.out.println("isEmpty:" + queue.isEmpty());

        System.out.println("----------------------------");

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.display();
        System.out.println("size:" + queue.size());
        System.out.println("isEmpty:" + queue.isEmpty());

        System.out.println("----------------------------");

        MyStack<String> stack = new MyStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("java");

        stack.display();
        System.out.println("size:" + stack.size());
        System.out.println("isEmpty:" + stack.isEmpty());

        System.out.println("----------------------------");

        stack.push("android");
        stack.pop();
        stack.pop();

        stack.display();
        System.out.println("size:" + stack.size());
        System.out.println("isEmpty:" + stack.isEmpty());

        System.out.println("----------------------------");

        stack.pop();
        stack.pop();
        stack.display();
        System.out.println("size:" + stack.size());
        System.out.println("isEmpty:" + stack.isEmpty());

        System.out.println("----------------------------");

        stack.pop();


    }
}
