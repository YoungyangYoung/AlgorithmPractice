package LeetCode;

/**
 * @author ºÚ—Ù
 *
 */
public class removeDuplicatesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 1, 1, 2, 2, 2, 3 };
		System.out.println(removeDuplicates1(input));
	}

	public static int removeDuplicates1(int[] nums) {

		int counter = 1;
		int position = 1;
		if (nums == null || nums.length == 0)
			return 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				counter++;
				nums[position] = nums[i];
				position++;
			}

		}
		return counter;
	}

	public static int removeDuplicates(int[] nums) {

		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
