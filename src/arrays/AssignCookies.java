package arrays;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] greed = {1,2,3}; //{1,2};
        int[] cookies = {1,1}; //{1,2,3};
        System.out.println("Maximum no. of children that can have cookies " + assign(greed,cookies));
    }

    private static int assign(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int i = greed.length - 1;
        int j = cookies.length - 1;
        int noOfChildren = 0;
        while(i >= 0 && j >= 0){
            if(cookies[j] >= greed[i]){
                noOfChildren++;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return noOfChildren;
    }
}
