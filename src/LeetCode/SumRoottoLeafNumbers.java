package LeetCode;

/**
 * @author ºÚ—Ù
 * Problem No : 129. Sum Root to Leaf Numbers
 * web: https://leetcode.com/problems/sum-root-to-leaf-numbers/#/description
 * Date : 2017.06.26
 */
public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return toInt(root, 0);
	}

	public int toInt(TreeNode root, int num){
		if (root == null)
			return 0;
		int value = num * 10 + root.val;
		if (root.right == null && root.left == null) {
			return value;
		}
		return toInt(root.right, value) + toInt(root.left, value);
       
    }

	// * Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
