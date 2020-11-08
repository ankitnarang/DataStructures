package arrays;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {
        int[] arrivals = {900,940};// {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910,1200};// {910, 1200, 1120, 1130, 1900, 2000};
        int result = findPlatform(arrivals, departures);
        System.out.println("Minimum number of Platforms needed is : " + result);
    }

    private static int findPlatform(int[] arrivals, int[] departures){
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int n = arrivals.length;
        int platformNeeded = 1;
        int result = 1;
        int i = 0;
        int j = 1;

        while (i < n && j < n){
            if(arrivals[j] <= departures[i]){
                platformNeeded++;
                j++;
            } else if (arrivals[j] > departures[i]){
                platformNeeded--;
                i++;
            }
            result = Math.max(platformNeeded,result);
        }

        return  result;
    }

}
