package LeetCode;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,1,2,4,3,3};
		int result = singleNumber(nums);
		
//		System.out.println(result);
	}
	
	public static int singleNumber(int[] nums) {
	    int result = 0;
	    for (int i = 0; i < nums.length; i++)
	    {
			result ^= nums[i];
			System.out.println(result);
	    }
		return result;
	}

}
