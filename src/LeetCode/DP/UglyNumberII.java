package LeetCode.DP;

public class UglyNumberII {

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
	}

	/*
	 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller
	 * ugly number.
	 * 
	 * The key is how to maintain the order of the ugly numbers. Try a similar
	 * approach of merging from three sorted lists: L1, L2, and L3.
	 * 
	 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2
	 * * 3, L3 * 5).
	 */
	public static int nthUglyNumber(int n) {
		int factor2 = 2, factor3 = 3, factor5 = 5;
		int index1 = 0, index2 = 0, index3 = 0;
		int min = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			min = Math.min(Math.min(dp[index1] * 2, dp[index2] * 3),
					dp[index3] * 5);
			dp[i] = min;
			if (min == factor2 * dp[index1]) {
				index1++;
			}
			if (min == factor3 * dp[index2]) {
				index2++;
			}
			if (min == factor5 * dp[index3]) {
				index3++;
			}
		}

		return dp[n - 1];
	}
}
