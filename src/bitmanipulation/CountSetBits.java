package bitmanipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int num = 2047; //9; //5;
        int result = setBits(num);
        System.out.println("Number of set bits in " + num + " is " + result);
    }

    private static int setBits(int num) {
        int count = 0;

        while (num > 0 ){
            count += (num & 1);
            num = num >> 1;
        }

        return  count;
    }
}
