package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ºÚ—Ù
 * @Problem No :  442. Find All Duplicates in an Array
 * {@link} https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 * Date : 2017.10.31
 */
public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = { 5, 4, 6, 7, 9, 3, 10, 9, 5, 6 };
		findDuplicates(input);
	}

	//put integers into index of a new array according to value
	//if there exist a element already, the element is duplicate. 
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int index = nums[i];
			if(arr[index - 1] == 0){
				arr[index - 1] = index;
			}else{
				list.add(index);
			}
			
		}
		return list;
	}

	//highest votes in discuss
	public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }
}
