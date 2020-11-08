package bitmanipulation;

public class HammingDistance {
    public static void main(String[] args) {
        int num1 = 4; //9;
        int num2 = 8; //14;
        int result = hammingDistance(num1,num2);
        System.out.println("Hamming distance between " + num1 + " and " + num2 + " is " + result);
    }

    private static  int hammingDistance(int num1, int num2){
        int count = 0;

        int result = num1 ^ num2;
        while (result > 0){
            count += (result & 1);
            result = result >> 1;
        }

        return count;
    }

}
