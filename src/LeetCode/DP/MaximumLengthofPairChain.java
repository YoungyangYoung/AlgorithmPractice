package LeetCode.DP;
/**
 * @author ºÚ—Ù
 * @Problem No : 646. Maximum Length of Pair Chain
 * {@link} https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 * Date : 2017.09.24
 */
public class MaximumLengthofPairChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[-10,-8],[8,9],[-5,0],[6,10],[-6,-4],[1,7],[9,10],[-4,7]]
		int[][] pairs = new int[][] { { 9, 10 }, { -4, 9 }, { -5, 6 },
				{ -5, 9 }, { 8, 9 } };
		System.out.println(findLongestChain(pairs));
	}

	public static int findLongestChain(int[][] pairs) {
		int[][] sorted = new int[pairs.length][pairs[0].length];
		int[] chain = new int[pairs.length];
		chain[0] = 1;
		int max = 0;
		mergesort(pairs, 0, pairs.length - 1, sorted);

		for (int i = 0; i < sorted.length; i++) {
			System.out.print("[" + sorted[i][0] + "," + sorted[i][1] + "]"
					+ " ");
		}
		System.out.println();

		for (int i = 1; i < sorted.length; i++) {
			chain[i] =1;
			for (int j = i; j >= 0; j--) {
				if (sorted[i][0] > sorted[j][1] && chain[i] < chain[j] + 1) {
					chain[i] = chain[j] + 1;
				}
			}
			max = Math.max(chain[i], max);
		}
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(chain[i] + " ");
		}
		System.out.println();
		return max;
	}

	public static void mergesort(int[][] arr, int start, int end, int[][] sorted) {

		if (start == end) {
			return;
		}

		int mid = start + ((end - start) / 2);
		mergesort(arr, start, mid, sorted);
		mergesort(arr, mid + 1, end, sorted);

		int i = start;
		int j = mid + 1;
		for (int k = start; k <= end; k++) {
			if (i <= mid && (j > end || arr[i][0] < arr[j][0])) {
				sorted[k][0] = arr[i][0];
				sorted[k][1] = arr[i][1];
				i++;
			} else {
				sorted[k][0] = arr[j][0];
				sorted[k][1] = arr[j][1];
				j++;
			}
		}

		for (int k = start; k <= end; k++) {
			arr[k][0] = sorted[k][0];
			arr[k][1] = sorted[k][1];
		}

	}
}
