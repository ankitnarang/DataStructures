package stacks;

import java.util.Stack;

public class DecodeString {
	
	public static void main(String[] args) {
		String input = "3[b2[ca]]";
		System.out.println("Input is " + input);
		String output = solve(input);
		System.out.println("Output is " + output);
	}

	private static String solve(String input) {
        int number = 0;
        Stack<Integer> numstack = new Stack<>();
        Stack<String> charstack = new Stack<>();
        String characterCopy ="";
        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                    number = number * 10 + (input.charAt(i) - '0');
            }
            else if(input.charAt(i) == '['){
                    numstack.push(number);
                    number = 0;
                    charstack.push(characterCopy);
                    characterCopy = "";
            }
            else if(input.charAt(i) == ']'){
                    String temp = "";
                    int n = numstack.peek();
                    numstack.pop();
                    for(int j = 0; j < n; j++)
                        temp += characterCopy;
                    characterCopy = charstack.peek() + temp;
                    charstack.pop();
                }
            else
                characterCopy += input.charAt(i);
            }
        return characterCopy;
	}

}
