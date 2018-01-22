package POJ;

import java.util.Scanner;

/**
 * @author ºÚ—Ù
 * Problem No: 1050
 * 
 */
public class ToTheMax {

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int N = keyboard.nextInt();
		int[][] rectangle = new int[N + 1][N + 1]; 
		
		for(int i = 1; i <= N; i++){
			for(int j = 1; j <= N; j++){
				rectangle[i][j] = keyboard.nextInt();
			}
		}
		
		int max = 0;
		int sum = 0;
		//i and j set range of traversal for calculate sum of sub matrices 
		for(int i = 1; i <= N; i++){
			//vertical
			for(int j = i; j <= N; j++){
				sum = 0;
				//horizontal
				for(int k = 1; k <= N; k++ ){
					//m belongs to values between i and j
					for(int m = i ; m <= j; m++){
						sum = sum + rectangle[k][m];
						if(sum < 0){
							sum = 0;
						}
						if(sum > max){
							max = sum;
						}
					}
				}
			}
			
		}
		
		System.out.println(max);
		
	}
}
