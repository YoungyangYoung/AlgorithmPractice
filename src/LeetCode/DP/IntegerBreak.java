package LeetCode.DP;

/**
 * @author ºÚ—Ù
 * @Problem No :  Integer break
 * {@link} https://leetcode.com/problems/integer-break/description/
 * Date : 2017.10.21
 */
public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(integerBreak(10));
	}

	public static int integerBreak(int n) {
		if(n == 0)
			return 0;

		int[] dp = new int[n + 1];
		dp[1] = 1;
		int[] multipliers = new int[n + 1];
		int multiplier1 = 1;
		int multiplier2 = 0;
		multipliers[1] = 1;

		for (int i = 2; i <= n; i++) {
			int a = multipliers[i - 1] * (multiplier1 + 1) * multiplier2;
			int b = multipliers[i - 1] * multiplier1 * (multiplier2 + 1);
			if(a > b){
				multiplier1 ++;
				dp[i] = a;
			}else{
				multiplier2++;
				dp[i] = b;
			}
			if(multiplier2 > 3){
				multiplier1 = 2;
				multiplier2 = 2;
				multipliers[i] = multipliers[i-1] * 3;
			}else{
				multipliers[i] = multipliers[i-1];
			}

		}
		return dp[n];
	}
}
