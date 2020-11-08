package stacks;

import java.util.Stack;

/*

    Max element in O(1) time and O(1) space

 */
public class MaximumElementInStack {
    public static void main(String[] args) {
        push(3);
        push(5);
        getMax();
        push(7);
        push(19);
        getMax();
        pop();
        getMax();
        pop();
        peek();
        getMax();
    }

    private static Stack<Integer> stack = new Stack<>();
    private static int maxElem;

    private static void getMax(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return;
        } else {
            System.out.println("Max element is " + maxElem);
        }
    }

    private static void peek(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return;
        } else {
            int temp = stack.peek();
            System.out.print("Topmost element in stack is ");
            if(temp > maxElem){
                System.out.print(maxElem + "\n");
            } else {
                System.out.print(temp + "\n");
            }
        }
    }

    private static void pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty" );
            return;
        } else {
            System.out.print("Element removed is ");
            int temp = stack.peek();
            stack.pop();
            if(temp > maxElem){
                System.out.print(maxElem + "\n");
                maxElem = 2 * maxElem - temp;
            } else {
                System.out.print(temp + "\n");
            }
        }
    }

    private static void push(int elem){
        if(stack.isEmpty()){
            stack.push(elem);
            maxElem = elem;
            System.out.println("Element inserted " + elem);
            return;
        } else if (elem > maxElem){
            stack.push(2 * elem - maxElem);
            maxElem = elem;
        } else {
            stack.push(elem);
        }
        System.out.println("Element inserted " + elem);
    }

}
