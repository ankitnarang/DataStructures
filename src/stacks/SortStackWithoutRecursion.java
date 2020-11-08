package stacks;

import java.util.Stack;

public class SortStackWithoutRecursion {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		
		System.out.println("Stack elements before sorting: "); 
		stack.forEach((elem) -> System.out.print(elem + " "));
        
		sortStack(stack);
        
        System.out.println(" \n\nStack elements after sorting:"); 
        stack.forEach((elem) -> System.out.print(elem + " "));
	}
	
	private static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		else {
			int temp = stack.pop();
			sortStack(stack);
			sortedInsert(stack,temp);
		}
	}

	private static void sortedInsert(Stack<Integer> stack,int element) {
		if(stack.isEmpty() || element > stack.peek())
			stack.push(element);
		else {
			int temp = stack.pop();
			sortedInsert(stack, element);
			stack.push(temp);
		}
	}

}
