package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
	static List<Integer> list;
	static List<List<Integer>> resultList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { -4, -6, -7, -7 };
		findSubsequences(nums);
	}

	public static List<List<Integer>> findSubsequences(int[] nums) {
		list = new ArrayList<Integer>();
		resultList = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return resultList;
		if (nums.length == 1) {
			return resultList;
		}

		int[] visited = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			DFSVisit(0, nums, visited, i);
		}

		return resultList;
	}

	public static void DFSVisit(int blog, int[] nums, int[] visited, int index) {
		if (blog > nums.length) {
			return;
		}
		if (!resultList.contains(list) && list.size() >= 2)
			resultList.add(new ArrayList<Integer>(list));
		for(int i = index; i < nums.length; i++){
			if (visited[i] == 0) {
				if ((list.size() == 0 || nums[i] >= list.get(list.size() - 1))) {
					list.add(new Integer(nums[i]));
					visited[i] = 1;
					DFSVisit(blog + 1, nums, visited, index);
					visited[i] = 0;
					list.remove(list.size()-1);
				}else{
					visited[i] = 1;
					DFSVisit(blog + 1, nums, visited, index);
					visited[i] = 0;
				}
				
				
			}
		}

	}

}
