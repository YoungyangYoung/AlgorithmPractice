package LeetCode.DP;

public class OnesAndZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"10", "0", "1"};
		int m = 1, n = 1;
		System.out.println(findMaxForm(strs, m, n));

	}

	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] construct = new int[strs.length][2];
		int[][] not = new int[strs.length][2];
		int[] cost = new int[2];
		
		for(int i = 1; i < strs.length; i++){
			countBits(strs[i], cost);
			//
		}
		return 0;
	}
	
	public static void countBits(String s, int[] cost){
		
		cost[0] = 0;
		cost[1] = 0;
//		for(int i = 0; i < s.length(); i++){
//			if(s.charAt(i) == '1')
//				cost[1] = cost[1] + 1;
//			else
//				cost[0] = cost[0] + 1;
//		}
		int orignalLen = s.length();
		int len = s.replace("1", "").length();
		cost[0] = len;
		cost[1] = orignalLen - len;
		
	}

}
