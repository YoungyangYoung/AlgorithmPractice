package LeetCode.DP;

public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,4,3,5,7,2};
		System.out.println(findNumberOfLIS(nums));
	}

	public static int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] len = new int[nums.length];
		int[] counter = new int[nums.length];
		len[0] = 1;
		counter[0] = 1;
		for(int i = 1; i < nums.length; i++){
			for(int j = 0; j < i; j++){
				if(nums[i] > nums[i-1] && len[i] >= 2){
					len[i] = len[i-1] + 1;
					counter[i] = counter[i-1];
					if(nums[i] > nums[j] && len[j+1] == 1){
						len[i] =  1;
						counter[i] = counter[i] + counter[j];
						break;
					}
				}
				if(nums[i] == nums[i-1]){
					len[i] = 1;
					counter[i] = counter[i-1] + 1;
					if(nums[i] > nums[j]){
						len[i] =len[j];
						counter[i] = counter[i-1];
					}
				}
				if(nums[i] < nums[i-1] && nums[i] == nums[j]){
					len[i] = len[j];
					counter[i] = counter[j];
					break;
				}else if(nums[i] < nums[i-1] && len[i-1] > 1 ){
					len[i] = 1;
					counter[i] = counter[i-1] + 1;
				}
				
				if(nums[i] > nums[j]){
					len[i] = len[j] + 1;
				}
				
			}
		}
		return counter[nums.length-1];
	}
}
