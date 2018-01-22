package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	static List<Integer> list;
	static List<List<Integer>> resultList;
	static int target = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);

		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(1);
		root.left = left;
		root.right = right;
		 List<List<Integer>>  result = pathSum(root, 1);

	}

	

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		list = new ArrayList<Integer>();
		resultList = new ArrayList<List<Integer>>();
		target = sum;
		if (root == null)
			return resultList;
		if (root.left == null && root.right == null && root.val == target) {
			list.add(new Integer(root.val));
			resultList.add(list);
			return resultList;
		}
		DFSVisit(root, 0, 0);
		return resultList;
	}

	public static void DFSVisit(TreeNode root, int val, int blog) {
		if(root == null){
			return;
		}
		val = root.val + val;
		list.add(new Integer(root.val));
		if (root.right == null && root.left == null) {
			if (val == target && blog >= 1) {
				resultList.add(new ArrayList(list));
			}
		}
		
		DFSVisit(root.left, val, blog + 1);
		DFSVisit(root.right, val, blog + 1);
		list.remove(list.size() - 1);
	}
}
