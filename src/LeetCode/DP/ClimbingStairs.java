package LeetCode.DP;
/**
 * @author ºÚ—Ù
 * @Problem No : 198. House Robber 
 * {@link} https://leetcode.com/problems/climbing-stairs/description/
 * Date : 2017.09.20
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(6));
	}

	public static int myClimbStairs(int n) {
		if (n == 0 || n < 0)
			return 0;
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
	
	//
}
