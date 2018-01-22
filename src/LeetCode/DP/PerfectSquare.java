package LeetCode.DP;

/**
 * @author ºÚ—Ù
 * Problem No : 279. Perfect Squares
 * web: https://leetcode.com/problems/perfect-squares/#/description
 * Date : 2017.06.17
 */
public class PerfectSquare {

	public static void main(String[] args){
		int num = 12;
		System.out.println(numSquares(num));
		
	}
	public static int numSquares(int n) {
		int[] dn = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int temp = 0;
			for (int j = 1; j * j <= i; j++) {
				if(dn[i] == 0)
					temp = dn[i- j*j] + 1;
				temp = min(dn[i - j * j] + 1, temp);
				dn[i] = temp;
//				System.out.print(temp + " ");
			}
			
			System.out.print(dn[i] + " ");
			System.out.println("----------" + i);
		}
		
		return dn[n];
	}

	public static int min(int a, int b) {
		if (a > b)
			return b;
		else
			return a;
	}
}
