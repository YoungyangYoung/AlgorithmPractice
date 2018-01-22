package LeetCode.DP;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = new int[]{23,0,0,4,7};
		if(checkSubarraySum(val, -6)){
			System.out.println("Right Answer!");
		}

	}

	// sum = n * k; n > 0, n = 0, n < 0;
	public static boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length == 0)
			return false;
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		if(k == 0){
			for(int i = 1; i < nums.length; i++){
				if(nums[i] == 0 || nums[i-1] == 0){
					return true;
				}
			}
		}else{
			for(int i = 1; i < nums.length; i++){
				sum[i] = sum[i - 1] + nums[i];
				if( sum[i] % k != 0){
					for(int j = 0; j < i-1; j ++){
						if((sum[i] - sum[j]) % k == 0){
							System.out.println(sum[i] - sum[j]);
							return true;
						}
					}
				}else if(sum[i] % k == 0 ){
//					System.out.println(sum[i]);
					return true;
				}
			}
		}
		return false;
	}
	
}
