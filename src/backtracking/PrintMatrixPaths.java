package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixPaths {
	
	public static void main(String[] args) {
		int[][] matrix = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		List<List<Integer>> printMatrixPaths = printMatrixPaths(matrix);
		System.out.println("Paths : ");
		for(List<Integer> list : printMatrixPaths) {
			System.out.println(list);
		}
		
	}

	private static List<List<Integer>> printMatrixPaths(int[][] matrix) {
		List<List<Integer>> list  = new ArrayList<>();
		matrixPathsHelper(list,new ArrayList<Integer>(), matrix, 0 , 0);
		return list;
	}

	private static void matrixPathsHelper(List<List<Integer>> list, ArrayList<Integer> paths, int[][] matrix,
			int row, int col) {
		//base case
		if(row == matrix.length-1) {
			ArrayList<Integer> tempPath = new ArrayList<>(paths);
			for(int i = col; i < matrix[0].length; i++) {
				tempPath.add(matrix[row][i]);
			}
			list.add(tempPath);
			return;
		}
		
		//base case
		if(col == matrix[0].length-1) {
			ArrayList<Integer> tempPath = new ArrayList<>(paths);
			for(int i = row; i < matrix.length; i++) {
				tempPath.add(matrix[i][col]);
			}
			list.add(tempPath);
			return;
		}
		
		//Add to list
		paths.add(matrix[row][col]);
		
		//Explore - Go Down
		matrixPathsHelper(list, paths, matrix, row+1, col);
		
		//Explore - Go Right
		matrixPathsHelper(list, paths, matrix, row, col+1);
		
		//Remove from list
		paths.remove(paths.size()-1);
		
	}

}
