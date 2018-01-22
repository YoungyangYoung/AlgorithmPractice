package LeetCode.DP;
/**
 * @author ºÚ—Ù
 * @Problem No : 198. House Robber 
 * {@link} https://leetcode.com/problems/house-robber/description/
 * Date : 2017.09.20
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[]{1,4,2};
		System.out.println(myMaxProfit(prices));

	}

	public static int myMaxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int[] profit = new int[prices.length];
		int cooldown = 0;
		profit[0] = 0;
		for(int i = 1; i < prices.length; i++){
			for(int j = 0;j < i; j++){
				profit[i] = Math.max(profit[i], prices[i] - prices[j]);
				profit[i] = Math.max(profit[i], profit[i-1]);
				if(j >= 1 && prices[j] <= prices[j-1])
					cooldown = j-1;
				if(cooldown > 0){
					profit[i] = Math.max(profit[i], prices[i] - prices[cooldown + 1] + profit[cooldown-1]);
					if(j - cooldown > 1 )
						profit[i] = Math.max(profit[i], prices[i] - prices[j] + profit[cooldown]);
				}
				
			}
		}
		return profit[prices.length-1];
	}
}
