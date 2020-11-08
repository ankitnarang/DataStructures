package stacks;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println("Are the strings equal ? " + backspace(S,T));

    }

    private static boolean backspace(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != '#'){
                sStack.push(c);
            } else if(!sStack.isEmpty()){
                sStack.pop();
            }
        }

        for(char c : t.toCharArray()){
            if(c != '#'){
                tStack.push(c);
            } else if(!tStack.isEmpty()){
                tStack.pop();
            }
        }

        while (!sStack.isEmpty()){
            char current = sStack.pop();
            if(tStack.isEmpty() || tStack.peek() != current){
                return false;
            } else {
                tStack.pop();
            }
        }

        return  sStack.isEmpty() && tStack.isEmpty();
    }
}
