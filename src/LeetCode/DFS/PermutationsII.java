package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ºÚ—Ù
 * @Problem No :  47. Permutations II
 * {@link} https://leetcode.com/problems/permutations-ii/description/
 * Date : 2017.09.18
 */
public class PermutationsII {
	
	private static List<List<Integer>> list;
    private static int[] arr;
    public List<List<Integer>> permuteUnique(int[] nums) {
    	if(nums == null && nums.length == 0)
    		return null;
        arr = nums;
        list = new ArrayList<List<Integer>>();
		List<Integer> val = new ArrayList<Integer>();
		int[] visited = new int[arr.length];
        Arrays.sort(arr);
		DFSVisit(0, visited, val);
        return list;
    }
	public  void DFSVisit(int blog, int[] visited, List<Integer> val){
		if(blog >= arr.length){
		    list.add(new ArrayList<Integer>(val)); 	
			return;
		}
		for(int i = 0; i < arr.length; i++){
            
			if(visited[i] == 0){
				//when a number has same value with previous one, use only if its previous used.
                if(i > 0 && arr[i-1] == arr[i] && visited[i-1] == 0)
                        continue;
				visited[i] = 1;
				val.add(new Integer(arr[i]));
				DFSVisit(blog + 1, visited, val);
				val.remove(blog);
				visited[i] = 0;
			}
		}
		
	}   
}
