package LeetCode.BFS;

import java.util.ArrayList;
import java.util.List;

// 513
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class FindBottomLeftTreeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(2);

		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		System.out.println(findBottomLeftValue(root));
	}



	public static int findBottomLeftValue(TreeNode root) {

		if(root == null)
			return 0;
		List<TreeNode> list = new ArrayList<TreeNode>();
		int index = 0;
		list.add(root);
		int breadth = 1;
		int result = 0;
		//nodes num of next layer
		int count = 0;
		int nodeNum = 1;
		while(index < list.size()){
			TreeNode node = list.get(index);
			if(node.left != null){
				list.add(node.left);
				count ++;
			}
				
			if(node.right != null){
				list.add(node.right);
				count ++;
			}
			index ++;
			nodeNum --;
			//
			if(nodeNum == 0){
				result = list.get(list.size() - breadth).val;
				nodeNum = breadth;
				count = 0;
			}
		}
		return result;
	}
}
