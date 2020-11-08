package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FindRectangleInBinaryMatrix {
	
	public static void main(String[] args) {
		List<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
		arrList.add(new ArrayList<Integer>(Arrays.asList(0,1,1)));
		arrList.add(new ArrayList<Integer>(Arrays.asList(0,1,1)));
		arrList.add(new ArrayList<Integer>(Arrays.asList(0,1,0)));
		System.out.println("2D Arraylist : ");
		System.out.println(arrList);
		System.out.println("Contains Rectangle : "  + solve(arrList));
	}

	private static int solve(List<ArrayList<Integer>> arrList) {
		// TODO Auto-generated method stub
		int rows = arrList.size();
        int columns = arrList.get(0).size();
        
        if(rows == 0)
            return 0;
            
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < columns - 1; j++){
                for(int k = j+1 ; k < columns; k++){
                    if(arrList.get(i).get(j) == 1 && arrList.get(i).get(k) == 1){
                        if(map.containsKey(j) && map.get(j).contains(k)){
                            return 1;
                        }
                        if(map.containsKey(k) && map.get(k).contains(j)){
                            return 1;
                        }
                        if(!map.containsKey(j)){
                            HashSet<Integer> set = new HashSet<>();
                            set.add(k);
                            map.put(j,set);
                        } else {
                            map.get(j).add(k);
                        }
                        if(!map.containsKey(k)){
                            HashSet<Integer> set = new HashSet<>();
                            set.add(j);
                            map.put(k,set);
                        } else {
                            map.get(k).add(j);
                        }
                    }
                }
            }   
        }
        return 0;
	}

}

