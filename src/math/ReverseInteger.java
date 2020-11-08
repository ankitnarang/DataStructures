package math;

public class ReverseInteger {

    public static void main(String[] args) {
        int num = 1234;
        System.out.println("The reverse of number is " + solve(num));
    }

    private static int solve(int num){
        boolean flag = false;
        if(num < 0){
            flag = true;
            num = -1 * num;
        }
        int reversed = 0;
        while (num > 0){
            reversed = (reversed * 10) + num % 10;
            num /= 10;
        }
        if(reversed > Integer.MAX_VALUE){
            return 0;
        }

        return flag ? (-1 * reversed) : reversed;
    }
}
