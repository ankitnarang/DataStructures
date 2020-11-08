package arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] array = {1,9,9,9};
        System.out.println("Before adding one to array");
        for(int i : array){
            System.out.print(i + " ");
        }
        int[] result = solve(array);
        System.out.println("\nAfter adding one to array");
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    private static int[] solve(int[] array) {

        for(int i = array.length - 1; i >=  0; i--){
            if(array[i] < 9){
                array[i] += 1;
                return array;
            }
            array[i] = 0;
        }

        int[] result = new int[array.length + 1];
        result[0] = 1;
        return result;
    }
}
