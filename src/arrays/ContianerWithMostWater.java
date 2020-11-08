package arrays;

public class ContianerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println("Result is " + area);
    }

    private static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int min = Math.min(height[i],height[j]);
            max = Math.max(max, min * (j - i));
            if(height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }

        return max;
    }

}
