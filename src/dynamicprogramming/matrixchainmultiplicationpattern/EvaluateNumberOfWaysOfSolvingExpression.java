package dynamicprogramming.matrixchainmultiplicationpattern;

import java.util.HashMap;
import java.util.Map;

public class EvaluateNumberOfWaysOfSolvingExpression {
    // Question Link : https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
    // Reference Link : https://www.youtube.com/watch?v=pGVguAcWX4g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=39&ab_channel=AdityaVerma
    static Map<String,Integer> map;
    public static void main(String[] args) {
        char[] symbols = "TTFT".toCharArray(); // "TFF".toCharArray(); // "TFT".toCharArray();
        char[] operators = "|&^".toCharArray(); // "^|".toCharArray(); // "^&".toCharArray();
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < operators.length;){
            sb.append(symbols[j]).append(operators[i]);
            i++;
            j++;
        }
        sb.append(symbols[symbols.length-1]);
        //System.out.println(sb.toString());
        String str = sb.toString();

        int result = numberOfWaysToEvaluateExpression(str,0,str.length()-1,true);
        System.out.println("The number of ways to evaluate expression is " + result);

        map = new HashMap<>();
        result = numberOfWaysToEvaluateExpressionTopDown(str,0,str.length()-1,true);
        System.out.println("The number of ways to evaluate expression is " + result);
    }

    private static int numberOfWaysToEvaluateExpressionTopDown(String str, int i, int j, boolean isTrue) {
        {
            if(i > j){
                return 0;
            }
            if(i == j){
                if(isTrue == true){
                    if(str.charAt(i) == 'T'){
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    if(str.charAt(i) == 'F'){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
            StringBuilder temp = new StringBuilder();
            temp.append(i).append(' ').append(j).append(' ').append(isTrue);
            String key = temp.toString();
            if(map.containsKey(key)){
                return map.get(key);
            }

            int answer = 0;

            for(int k = i+1 ; k <= j-1 ; k = k + 2){
                int leftTrue = numberOfWaysToEvaluateExpressionTopDown(str,i,k-1,true);
                int leftFalse = numberOfWaysToEvaluateExpressionTopDown(str,i,k-1,false);
                int rightTrue = numberOfWaysToEvaluateExpressionTopDown(str,k+1,j,true);
                int rightFalse = numberOfWaysToEvaluateExpressionTopDown(str,k+1,j,false);

                if(str.charAt(k) == '&'){
                    if(isTrue == true){
                        answer = answer + (leftTrue * rightTrue);
                    } else {
                        answer = answer + (leftTrue * rightFalse)
                                + (leftFalse * rightTrue)
                                + (leftFalse * rightFalse);
                    }
                } else if(str.charAt(k) == '|'){
                    if(isTrue == true){
                        answer = answer + (leftTrue * rightTrue)
                                + (leftTrue * rightFalse)
                                + (leftFalse * rightTrue);
                    } else {
                        answer = answer + (leftFalse * rightFalse);
                    }
                } else if(str.charAt(k) == '^'){
                    if(isTrue == true){
                        answer = answer + (leftTrue * rightFalse)
                                + (leftFalse * rightTrue);
                    } else {
                        answer = answer + (leftTrue * rightTrue)
                                + (leftFalse * rightFalse);
                    }
                }

            }
            map.put(key,answer);
            return answer;
        }
    }

    private static int numberOfWaysToEvaluateExpression(String str, int i, int j, boolean isTrue) {
        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue == true){
                if(str.charAt(i) == 'T'){
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if(str.charAt(i) == 'F'){
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        int answer = 0;

        for(int k = i+1 ; k <= j-1 ; k = k + 2){
            int leftTrue = numberOfWaysToEvaluateExpression(str,i,k-1,true);
            int leftFalse = numberOfWaysToEvaluateExpression(str,i,k-1,false);
            int rightTrue = numberOfWaysToEvaluateExpression(str,k+1,j,true);
            int rightFalse = numberOfWaysToEvaluateExpression(str,k+1,j,false);

            if(str.charAt(k) == '&'){
                if(isTrue == true){
                    answer = answer + (leftTrue * rightTrue);
                } else {
                    answer = answer + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue)
                            + (leftFalse * rightFalse);
                }
            } else if(str.charAt(k) == '|'){
                if(isTrue == true){
                    answer = answer + (leftTrue * rightTrue)
                            + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue);
                } else {
                    answer = answer + (leftFalse * rightFalse);
                }
            } else if(str.charAt(k) == '^'){
                if(isTrue == true){
                    answer = answer + (leftTrue * rightFalse)
                            + (leftFalse * rightTrue);
                } else {
                    answer = answer + (leftTrue * rightTrue)
                            + (leftFalse * rightFalse);
                }
            }

        }

        return answer;
    }
}
