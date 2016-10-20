package com.example.misc;

public class MatrixFindNumber {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        
        for(int i = 0; i < cols; i++) {
            if (matrix[0][i] == target) return true;
            if(matrix[0][i] < target && matrix[rows - 1][i] > target) {
                if(binarySearchColumn(matrix, i, target)) return true;
            } 
        }
        return false;
    }
    private boolean binarySearchColumn(int[][] matrix, int column, int target) {
        int low = 0; int high = matrix.length;

        if(matrix.length == 1) return matrix[0][0] == target;
        
        while(low < high) {
        	if(high - low <= 1) {
        		if(matrix[low][column] == target) return true;
            	return matrix[high - 1][column] == target;
        	}
            int mid = (low + high) / 2;
            if(matrix[mid][column] == target) return true;
            if(matrix[mid][column] < target) low = mid;
            if(matrix[mid][column] > target) high = mid;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int[][] a = {{1,1}};
    	MatrixFindNumber s = new MatrixFindNumber();
    	
    	System.out.println(s.searchMatrix(a, 6));
    }
}