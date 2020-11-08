package arrays;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] array = {4,1,2,1,2,4,6};
        System.out.println("The number which appears only once is " + singleNumber(array));

    }

    private static int singleNumber(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        for (int index = 0; index < array.length; index++) {
            if(numbers.contains(array[index])){
                numbers.remove(array[index]);
            } else {
                numbers.add(array[index]);
            }
        }

        for (int num : numbers){
            return num;
        }

        return -1;
    }
}
