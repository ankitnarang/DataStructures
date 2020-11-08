package strings;

public class SplitStringInBalancedStrings {

    public static void main(String[] args) {
        String str = "RLRRRLLRLL";
        System.out.println("Balanced strings in " + str + " are " + balance(str));
    }

    private static int balance(String str){
        int balanceCount = 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'L'){
                count++;
            } else if (str.charAt(i) == 'R'){
                count--;
            }
            if(count == 0){
                System.out.println("index is " + i);
                balanceCount++;
            }
        }
        return balanceCount;
    }

}
