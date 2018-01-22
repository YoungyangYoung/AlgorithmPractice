package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ºÚ—Ù
 * @Problem No :  199. Binary Tree Right Side View
 * {@link} https://leetcode.com/problems/permutations-ii/description/
 * Date : 2017.10.17
 */

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);

		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(3);
		root.left = left2;
		root.right = right2;

		List<Integer> list = rightSideView(root);

	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		List<TreeNode> queue = new ArrayList<TreeNode>();
		if (root == null)
			return list;
		queue.add(root);
		int start = 0;
		while (queue.size() != start) {
			int length = queue.size();
			for (int i = start; i < length; i++) {
				TreeNode node = queue.get(i);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				start++;
				if (i == length - 1)
					list.add(new Integer(node.val));

			}

		}

		return list;
	}
}
