package stacks;

import java.util.Stack;

/*

    Max element in O(1) time and O(1) space

 */
public class MinimumElementInStack {
    public static void main(String[] args) {
        push(3);
        push(5);
        getMin();
        push(2);
        push(1);
        getMin();
        pop();
        getMin();
        pop();
        peek();
        getMin();
    }

    private static Stack<Integer> stack = new Stack<>();
    private static int minElem;

    private static void getMin(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return;
        } else {
            System.out.println("Min element is " + minElem);
        }
    }

    private static void peek(){
        if(stack.isEmpty() || stack == null){
            System.out.println("Stack is empty");
            return;
        } else {
            int temp = stack.peek();
            System.out.print("Topmost element in stack is ");
            if(temp < minElem){
                System.out.print(minElem + "\n");
            } else {
                System.out.print(temp + "\n");
            }
        }
    }

    private static void pop(){
        if(stack.isEmpty() || stack == null){
            System.out.println("Stack is empty" );
            return;
        } else {
            System.out.print("Element removed is  ");
            int temp = stack.peek();
            stack.pop();
            if(temp < minElem){
                System.out.print(minElem + "\n");
                minElem = 2 * minElem - temp;
            } else {
                System.out.print(temp + "\n");
            }
        }
    }

    private static void push(int elem){
        if(stack.isEmpty() || stack == null){
            stack.push(elem);
            minElem = elem;
            System.out.println("Element inserted " + elem);
            return;
        } else if (elem < minElem){
            stack.push(2 * elem - minElem);
            minElem = elem;
        } else {
            stack.push(elem);
        }
        System.out.println("Element inserted " + elem);
    }

}
