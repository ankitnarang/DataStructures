package arrays;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        int limit = 3;

        int result = numRescueBoats(people,limit);
        System.out.println("No of boats needed to rescue people are " + result);
    }

    private static int numRescueBoats(int[] people, int limit) {
        int numOfBoats = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while (i <= j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            numOfBoats++;
        }

        return numOfBoats;
    }

}
