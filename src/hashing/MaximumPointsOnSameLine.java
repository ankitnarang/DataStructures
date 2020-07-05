package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnSameLine {
	
	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Point[] points = new Point[A.size()];
        for(int i = 0 ; i < A.size(); i++){
            points[i] = new Point(A.get(i),B.get(i));
        }
        if(points == null || points.length == 0)
            return 0;
        int result = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < points.length; i++){
            int max = 0;
            int overlap = 0;
            map.clear();
            for(int j = i+1 ; j < points.length; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x ==0 && y == 0){
                    overlap++;
                    continue;
                }
                int gcd = findGCD(x,y);
                if(gcd != 0){
                    x = x / gcd;
                    y = y / gcd;
                }
                String key = x + "@" + y;
                if(map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key,1);
                max = Math.max(max, map.get(key));    
            }
            result = Math.max(result, max + overlap + 1); 
        }
        return result;
    }
	
    static int findGCD(int a, int b){
            if(b == 0)
                return a;
            return findGCD(b, a%b);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrList1 = new ArrayList<Integer>(Arrays.asList(-1, 0, 1, 2, 3, 3));
		ArrayList<Integer> arrList2 = new ArrayList<Integer>(Arrays.asList(1, 0, 1, 2, 3, 4));
		System.out.println(solve(arrList1, arrList2));
	}

}
class Point{
    int x;
    int y;
    Point(){
        x = 0;
        y = 0;
    }
    Point(int a , int b){
        x = a;
        y = b;
    }
}
