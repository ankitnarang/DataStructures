package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetMatrixZeros {
	
	private static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    Map<String,ArrayList<Integer>> map = new HashMap<>();
	    map.put("rows",new ArrayList<Integer>(Arrays.asList(-1)));
	    map.put("cols",new ArrayList<Integer>(Arrays.asList(-1)));
	    ArrayList<Integer> tempRow = new ArrayList<Integer>();
	    ArrayList<Integer> tempCol = new ArrayList<Integer>();
	    for(int row = 0 ; row < a.size(); row ++){
	        for(int col = 0 ;  col < a.get(0).size(); col++){
	            if(a.get(row).get(col) == 0){
	            	tempRow = new ArrayList<Integer>();
	            	tempCol = new ArrayList<Integer>();
	            	tempRow.add(row);
	            	tempCol.add(col);
	                //map.put("rows",);
	                //map.put("cols",);
	            }
	        }
	    }
	    
	    map.get("rows").remove(0);
	    map.get("cols").remove(0);
	    
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
		arrList.add(new ArrayList<Integer>(Arrays.asList(1,0,1)));
		arrList.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
		arrList.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
		System.out.println(arrList);
		setZeroes(arrList);
		System.out.println("End");
	}

}
