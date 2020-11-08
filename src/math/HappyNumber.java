package math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 22; // 19
        System.out.println("Is number " + n + ", a happy number? " + isHappy(n));
    }

    private static boolean isHappy(int num){
        Set<Integer> seen = new HashSet<>();
        while (num != 1){
            int current = num;
            int sum = 0;
            while (current != 0){
                sum += (current%10) *(current%10);
                current /= 10;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            num = sum;
        }

        return true;
    }

}
