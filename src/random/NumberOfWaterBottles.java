package random;

// Leet code (easy): https://leetcode.com/problems/water-bottles/submissions/
/*
    Given
        - Total filled bottles
        - number of bottles that can be exchanged to get 1 new filled bottle
        - find maximum number of filled bottles which can be consumed
 */
public class NumberOfWaterBottles {

    public static void main(String[] args) {
        int numOfBottles = 15; //9;
        int numOfBottlesExchanged = 4; //3;
        int result = numWaterBottles(numOfBottles,numOfBottlesExchanged);
        System.out.println("The number of bottles  that be consumed are " + result);
    }

    private static int numWaterBottles(int numOfBottles, int numOfBottlesExchanged) {
        int total = 0;
        int emptyBottles = numOfBottles;
        total += numOfBottles;

        while (emptyBottles >= numOfBottlesExchanged){
            int newFilledBottles = emptyBottles/numOfBottlesExchanged;
            int newEmptyBottles = emptyBottles/numOfBottlesExchanged;
            total += newFilledBottles;
            emptyBottles = newFilledBottles + newEmptyBottles;
        }

        return total;
    }

}
