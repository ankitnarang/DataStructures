package stacks;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "[(])"; //"[()]{}{[()()]()}"; //"([{}]){}"; //"{()}[";
        if(balanced(str)){
            System.out.println(str + " is a balanced string");
        } else {
            System.out.println(str + " is not a balanced string");
        }
    }

    private static boolean balanced(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            switch(ch){
                case '}' :
                    if(stack.peek() == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']' :
                    if(stack.peek() == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')' :
                    if(stack.peek() == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}
