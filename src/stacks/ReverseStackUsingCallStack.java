package stacks;

import java.util.Stack;

public class ReverseStackUsingCallStack {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		
		System.out.println("Stack elements before sorting: "); 
		stack.forEach((elem) -> System.out.print(elem + " "));
        
		reverse();
        
        System.out.println(" \n\nStack elements after sorting:"); 
        stack.forEach((elem) -> System.out.print(elem + " "));
	}

	private static void reverse() {
		if(stack.isEmpty())
			return;
		else {
			int temp = stack.pop();
			reverse();
			insertAtBottom(temp);
		}
	}

	private static void insertAtBottom(int elem) {
		if(stack.isEmpty())
			stack.push(elem);
		else {
			int temp = stack.peek();
			stack.pop();
			insertAtBottom(elem);
			stack.push(temp);
		}
	}

}
