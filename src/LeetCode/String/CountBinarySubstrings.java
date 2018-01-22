package LeetCode.String;
/**
 * @author ºÚ—Ù
 * @Problem No : 696. Count Binary Substrings 
 * {@link} https://leetcode.com/problems/count-binary-substrings/description/
 * Date : 2017.10.30
 */
public class CountBinarySubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "10101";
		System.out.println(countBinarySubstrings(s));
	}

	public static int countBinarySubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int count0 = 0;
		int count1 = 0;
		int strNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 48) {
				if ((i > 0 && s.charAt(i - 1) == 49)) {
					// end with 1
					strNum = strNum + Math.min(count0, count1);
					count0 = 1;
				} else {
					count0++;
				}
				if (i == s.length() - 1) {
					strNum = strNum + Math.min(count0, count1);
				}

			} else {
				if ((i > 0 && s.charAt(i - 1) == 48)) {
					strNum = strNum + Math.min(count0, count1);
					count1 = 1;
				} else {
					count1++;
				}

				if (i == s.length() - 1) {
					strNum = strNum + Math.min(count0, count1);
				}
			}

		}
		return strNum;
	}
	//solution of leetcode 
	 public int countBinarySubstrings1(String s) {
	        int ans = 0, prev = 0, cur = 1;
	        for (int i = 1; i < s.length(); i++) {
	            if (s.charAt(i-1) != s.charAt(i)) {
	                ans += Math.min(prev, cur);
	                prev = cur;
	                cur = 1;
	            } else {
	                cur++;
	            }
	        }
	        return ans + Math.min(prev, cur);
	    }
}
