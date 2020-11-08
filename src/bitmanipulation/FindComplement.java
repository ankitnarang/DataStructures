package bitmanipulation;

public class FindComplement {
    public static void main(String[] args) {
        int num = 14;
        int result = findComplement(num);
        System.out.println("The complement of " + num + " is " + result);
    }

    private static int findComplement(int num){
        int result = 0;
        int power = 1;
        while (num > 0){
            int leastSignificantBit = num & 1; // To take last leastSignificantBit
            result += (leastSignificantBit ^ 1) * power; //Take compliment of LSB by XORing and multiplying with 2.
            power = power << 1; // increasing power for next bit
            num = num >> 1; // moving number right side to get next digit starting from LSB in 1st iteration
        }
        return result;
    }

}
