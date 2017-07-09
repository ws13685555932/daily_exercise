package exer0707;

import sun.invoke.empty.Empty;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.function.DoubleToIntFunction;

/**
 * Created by wangsheng on 2017/7/7.
 */

public class Stack <T>{
    //数组用来存放数据
    T[] a;
    //栈顶指针
    int index;
    //当前数组的大小
    int maxLength;

    //构造方法，设定数组大小初始值为4，栈顶指针指向空
    public Stack(){
        maxLength = 4;
        a = (T[]) new Object[maxLength];
        index = -1;
    }

    //栈是否为空
    public boolean isEmpty(){
        return a.length ==0;
    }

    //栈当前大小
    public int size(){
        return index+1;
    }

    //压栈操作
    public T push(T t){
        //当栈的大小已经达到数组的大小，将数组大小扩大一倍
        if(size() == maxLength){
            maxLength*=2;
            T[] temp = (T[]) new Object[maxLength];
            for(int i=0;i<size();i++){
                temp[i] = a[i];
            }
            a = temp;
        }
            index++;
            a[index] = t;
            return t;

    }

    //出栈操作
    public T pop(){
        //空栈时不能出栈，报错
        if(index < 0){
            try {
                throw new EmptyStackException();
            } catch (EmptyStackException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            //当栈的大小不及数组大小的1/4，将数组大小缩小一倍
            if(size() == maxLength/4){
                maxLength/=2;
                T[] temp = (T[]) new Object[maxLength];
                for(int i=0;i<size();i++){
                    temp[i] = a[i];
                }
                a = temp;
            }
            T top = a[index];
            a[index] = null;
            index--;
            return top;
        }
    }

    //查看栈顶元素（不出栈）
    public T peek() {
        //空栈时为null
        if(index < 0){
            return null;
        }else {
            return a[index];
        }
    }

    //显示栈中元素，倒序遍历数组
    public void display(){
            System.out.println("top of stack");
            System.out.println("---------------");
            for (int i=size()-1;i>=0;i--) {
                System.out.println(a[i].toString());
            }
            System.out.println("---------------");
        System.out.println("bottom of stack");
    }

    //得到数组大小
    public int getMaxLength(){
        return maxLength;
    }

    //得到迭代器，实例化迭代器返回
    public Iterator iterator(){
        return new Itr();
    }

    //迭代器
    class Itr implements Iterator<T> {

        int itIndex = size()-1;

        @Override
        public boolean hasNext() {
            return itIndex>=0;
        }

        @Override
        public T next() {
            T t = a[itIndex];
            itIndex --;
            return t;
        }
    }

    //测试
    public static void main(String[] args) {
        Stack<String>  stringStack = new Stack<>();
        stringStack.push("hello");
        stringStack.push("world");
        stringStack.push("java");
        stringStack.push("android");
        stringStack.push("while");

        stringStack.display();

        System.out.println("top->" + stringStack.peek());

        //使用迭代器遍历栈输出元素
        System.out.println("display with iterator:");
        Iterator it = stringStack.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(stringStack.getMaxLength());
        for (int i = 0; i < 5; i++) {
            stringStack.pop();
        }
        stringStack.display();
        System.out.println(stringStack.getMaxLength());

    }

}
//迭代器接口
interface Iterator<T>{
    //是否还有下一个元素
    boolean hasNext();
    //取一个元素
    T next();
}

//自定义异常类，当栈为空时执行出栈操作时抛出异常
class EmptyStackException extends Exception {
    public EmptyStackException(){
        super("EmptyStackException: stack is empty!");
    }
}
