package stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "{[(})]";
        System.out.println("String " + str + " contains valid parenthesis ? "  + isValid(str));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()){
            if(c == '(' || c == '[' ||c == '{'){
                stack.add(c);
            } else if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            } else if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            } else if(c == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            } else {
                return false;
            }

        }

        return stack.isEmpty();
    }

}
