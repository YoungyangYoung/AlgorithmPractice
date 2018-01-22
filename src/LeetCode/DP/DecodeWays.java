package LeetCode.DP;

/**
 * @author ºÚ—Ù
 * @Problem No : 91. Decode Ways 
 * {@link} https://leetcode.com/problems/decode-ways/description/
 * Date : 2017.10.01
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "345670";
		System.out.println(numDecodings(s));

	}

	public static int numDecodings(String s) {
		if (s == null || "".equals(s) || s.charAt(0) == '0')
			return 0;
		int length = s.length();
		int[] dp = new int[length + 1];
		int oneBit = 0;
		int twoBits = 0;
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= length; i++) {
			oneBit = Character.getNumericValue(s.charAt(i-1));
			twoBits = Character.getNumericValue(s.charAt(i - 2)) * 10 + oneBit;

			if (twoBits == 0)
				return 0;
			// when (a*10 + b) is greater than 10 ( a != 0) and less than 26,
			// and dp[i-1] is not equal to 0;
			// (if a*10 + b = 17023) s contains code cannot be encoded.
			if (twoBits > 10 && twoBits <= 26 && dp[i - 1] != 0 && oneBit != 0) {
				dp[i] = dp[i - 1] + dp[i-2];
			} else if (oneBit == 0 && twoBits <= 26 && i > 1) {
				dp[i] = dp[i - 2];
			} else if ((twoBits > 26 && oneBit != 0) || twoBits <= 10
					|| twoBits == 20) {
				// ab > 26 and ab < 10, a*10 > 26 make dp[i] = 0;
				dp[i] = dp[i - 1];
			}
		}
		return dp[length];
	}

	public static int numDecodings2(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1]
						+ memo[i + 2]
						: memo[i + 1];

		return memo[0];
	}

}
