package LeetCode.DP;

public class HouseRobberII {

	static int visited = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{10, 11, 10 ,11, 10};
		System.out.println(rob(nums));

	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] use = new int[nums.length];
		int[] notUse = new int[nums.length];
		int Max = nums[0], value = 0;
        use[0] = nums[0];
        notUse[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			if(i == nums.length - 1 && visited == 1)
				return Max;
			value = max(notUse[i - 1] + nums[i], use[i - 1]);
			use[i] = value;
			notUse[i] = use[i - 1];
			Max = Math.max(Max, value);
		}
		return Max;
	}
	 public static int max(int a, int b) {
	       if(a > b){
	    	   visited = 0 - visited;
	    	   System.out.print(visited + " ");
	    	   return a;
	       } 
           return b;
	    }
}
