package LeetCode.DP;

/**
 * @author ºÚ—Ù
 * @Problem No : 198. House Robber 
 * {@link} https://leetcode.com/problems/house-robber/description/
 * Date : 2017.09.20
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int myRob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] use = new int[nums.length];
        int[] notUse = new int[nums.length];
        int Max = nums[0], value = 0;
        use[0] = nums[0];
        notUse[0] = 0;
        for(int i = 1 ; i < nums.length; i++){
            value = Math.max(notUse[i-1] + nums[i], use[i-1]);
            use[i] = value;
            notUse[i] = use[i-1];
            if(value > Max)
                Max = value;
        }
        return Max;
    }
	
	public int rob(int[] num) {
	    int prevNo = 0;
	    int prevYes = 0;
	    for (int n : num) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}
}
