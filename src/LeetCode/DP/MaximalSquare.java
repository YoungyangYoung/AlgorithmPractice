package LeetCode.DP;

import java.util.Scanner;

/**
 * @author ºÚ—Ù
 * @Problem No : 221. Maximal Square 
 * {@link} https://leetcode.com/problems/maximal-square/#/description
 * Date : 2017.06.26
 */
public class MaximalSquare {
	
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int[][] matrix = new int[5][5];
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				matrix[i][j] = keyboard.nextInt();
			}
		}
		int val = maximalSquare(matrix);
		System.out.println(val);
	}
	public int maximalSquare(char[][] matrix){
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[][] dp = new int[rows + 1][cols +1];
		int maxsqlen = 0;
		for(int i = 1; i <= rows; i++){
			for(int j = 1; j <= cols; j++){
				if(matrix[i-1][j-1] == '1'){
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]) + 1;
					maxsqlen = Math.max(maxsqlen, dp[i][j]);
				}
			}
		}
		return maxsqlen * maxsqlen;
	}
	public static int maximalSquare(int[][] matrix){
		int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
		int[] dp = new int[cols + 1];
		int maxsqlen = 0, prev = 0;
		for(int i = 1; i <= rows; i++){
			for(int j = 1; j <= cols; j++){
				int temp = dp[j];
				if(matrix[i-1][j-1] == 1){
					dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
					maxsqlen = Math.max(maxsqlen, dp[j]);	
					System.out.print(prev + " ");
				}else{
					dp[j] = 0;
					System.out.print("@" + " ");
				}
				prev = temp;
			}
			System.out.println();
			prev = 0;
		}
		return maxsqlen * maxsqlen;
	}
}
