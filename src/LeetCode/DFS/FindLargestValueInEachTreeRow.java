package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode left2 = new TreeNode(-2);
		TreeNode right2 = new TreeNode(-1);
		root.left = left2;
		root.right = right2;

		TreeNode left3 = new TreeNode(5);
		TreeNode right3 = new TreeNode(3);
		left2.left = left3;
		left2.right = right3;

		TreeNode right4 = new TreeNode(9);
		right2.right = right4;

		List<Integer> list = largestValues(root);

	}

	public static List<Integer> largestValues(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		
		while (nodes.size() != 0) {
			int max = nodes.get(0).val;
			for (int i = nodes.size() - 1; i >= 0; i--) {
				TreeNode node = nodes.get(i);
				int val = node.val;
				max = Math.max(max, val);
				if (node.right != null)
					nodes.add(node.right);
				if (node.left != null)
					nodes.add(node.left);
				nodes.remove(i);
			}
			list.add(new Integer(max));
		}
		return list;
	}
	//master code;
	public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
