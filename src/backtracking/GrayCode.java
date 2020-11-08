package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        int digit = 3;
        List<String> strList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        strList = generateString(digit);
        for(String str : strList){
            result.add(Integer.parseInt(str,2));
        }
        result.forEach((x) -> System.out.print(x + " "));
    }

    private static List<String> generateString(int digit) {
        List<String> strList = new ArrayList<>();
        if(digit == 0){
            return new ArrayList<String>();
        } else if(digit == 1){
            strList.add("0");
            strList.add("1");
            return strList;
        } else {
            List<String> prev = generateString(digit - 1);
            strList.addAll(prev);
            for(int i = prev.size() - 1; i >= 0; i--){
                String bit = strList.get(i);
                String temp1 = "0" + bit;
                String temp2 = "1" + bit;
                strList.set(i,temp1);
                strList.add(temp2);
            }
            return strList;
        }
    }
}
