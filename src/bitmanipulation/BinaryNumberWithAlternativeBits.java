package bitmanipulation;

public class BinaryNumberWithAlternativeBits {
    public static void main(String[] args) {
        int n = 10; // 5 // 4
        boolean result = solve(n);
        System.out.println("Does the number " + n + " contains alternative bits? " + result);
    }

    private static boolean solve(int n){
        int last = n % 2;
        n = n >> 1;
        while (n > 0){
            int current = n%2;
            if(current == last){
                return false;
            }
            last = current;
            n = n >>1;
        }
        return true;
    }

}
