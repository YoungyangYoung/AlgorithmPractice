package LeetCode.DFS;

public class HouseRoberIII {

	static int max = 0;
//	static int rob = 0;
//	static int notRob = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);

		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		root.left = left1;
		root.right = right1;
		
		TreeNode left2 = new TreeNode(3);
		TreeNode right2 = new TreeNode(1);
		left1.right = left2;
		right1.right = right2;
		
		System.out.println(rob(root));

	}

	public static int rob(TreeNode root) {
		max = DFSVisit(root, 0, 0);
		return max;
	}
	
	public static int DFSVisit(TreeNode node, int rob, int notRob){
		if(node == null){
			System.out.println(Math.max(rob, notRob));
			return Math.max(rob, notRob);
		}
		int temp = rob;
		rob = Math.max(notRob + node.val, rob);
		notRob = temp;
		return DFSVisit(node.left, rob, notRob) + DFSVisit(node.right, rob, notRob);
	}

}
