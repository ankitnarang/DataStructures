package strings;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
    public static void main(String[] args) {
        String time = "19:34";
        String nextTime = nextClosestTime(time);
        System.out.println("Next Closest time is " + nextTime);
    }

    private static String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0,2))*60;
        minutes += Integer.parseInt(time.substring(3));

        Set<Integer> digits = new HashSet<>();

        for(char c : time.toCharArray()){
            if(c != ':'){
                digits.add(c - '0');
            }
        }

        while (true) {
            minutes = (minutes + 1) % (24*60);

            int[] nextTime = {
                    (minutes/60)/10,
                    (minutes/60)%10,
                    (minutes%60)/10,
                    (minutes%60)%10
            };

            boolean isValid = true;
            for(int digit : nextTime ){
                if(!digits.contains(digit)){
                    isValid = false;
                }
            }

            if(isValid){
                return new StringBuilder()
                        .append(minutes/60)
                        .append(":")
                        .append(minutes%60)
                        .toString();
            }
        }

    }
}
