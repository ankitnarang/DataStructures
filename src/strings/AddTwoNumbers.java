package strings;
/*
    Add 2 numbers : num1 and num2
    numbers will contain 0-9 digits
    num1 and num2 will not contain leading zeroes
    should not use any library function to convert to integers
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "9786";
        System.out.println("Result of summation of numbers, " + num1 + " and " + num2 + " are " + sum(num1,num2));
    }

    private static String sum(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while(i >=0 || j >= 0){
            sum = carry;
            if(i>=0){
                sum += num1.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                sum += num2.charAt(j) - '0';
                j--;
            }
            sb.append(sum%10);
            carry = sum/10;
        }
        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
