package LeetCode.DFS;
/**
 * @author ¼òÑô
 * @Problem No :  494. Target Sum
 * {@link} https://leetcode.com/problems/target-sum/description/
 * Date : 2017.10.02
 */
public class TargetSum {
	static int[] arr;
	static int targetSum;
	static int counter;
	
	public static void  main(String[] args){
		int[] nums = new int[]{1, 1, 1, 1, 1};
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));
	}
	public static int findTargetSumWays(int[] nums, int S) {
		arr = nums;
		counter = 0;
		targetSum = S;
		DFSVisit(0,0);
		return counter;
	}
	
	public static void DFSVisit(int blog, int sum){
		if(blog >= arr.length){
			System.out.println(sum);
			if(sum == targetSum)
				counter ++;
			return;
		}
		DFSVisit(blog + 1, sum + arr[blog]);
		DFSVisit(blog + 1, sum - arr[blog]);
	}

}
