package math;

public class AddBinaryNumbers {
    public static void main(String[] args) {
        String num1 = "01"; // "1010"; // "11";
        String num2 = "10"; // ""1011"; // "1";
        String result = addBinary(num1,num2);
        System.out.println("After addition of " + num1 + " and " + num2 + ", result is " + result);
    }

    private static String addBinary(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += num1.charAt(i--) - '0';
            }

            if(j >= 0){
                sum += num2.charAt(j--) - '0';
            }
            sb.insert(0,sum%2);
            carry = sum / 2;
        }

        if(carry > 0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
