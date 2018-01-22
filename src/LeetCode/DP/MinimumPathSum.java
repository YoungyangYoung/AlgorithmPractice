package LeetCode.DP;

import java.util.Scanner;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int m = keyboard.nextInt();
		int n = keyboard.nextInt();
		int[][] grid = new int[m][n];
		for(int i = 0 ; i < m; i++){
			for(int j = 0; j < m; j++){
				grid[i][j] = keyboard.nextInt();
			}
		}
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		if(grid == null || grid.length ==0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(i == 0 && j >=1){
					dp[i][j] = dp[i][j -1] + grid[i][j]; 
				}else if(j == 0 && i >= 1){
					dp[i][j] = dp[i-1][j] + grid[i][j];
				}else if(i >= 1 && j >= 1){
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
				}
			}
		}
		return dp[m-1][n-1];
	}
}
