package LeetCode.DFS;

/**
 * @author ºÚ—Ù
 * @Problem No : 111. Minimum Depth of Binary Tree
 * {@link} https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * Date : 2017.10.13
 */
//  Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(0);
		TreeNode left = new TreeNode(0);
		
		tree.left = left;
		
		System.out.println(minDepth(tree));
	}

	 public static int minDepth(TreeNode root) {
	        if(root == null)
	            return 0;
	        
	        int depth = 0;
	       if(root.right == null && root.left == null)
	           return 1;
	       int right = 0, left = 0;
	        if(root.right != null)
	            right = 1;
	        if(root.left != null)
	            left = 1;
	            
	        return min(minDepth(root.right) + right, minDepth(root.left) + left);
	    }
	    
	    
	    public static int min (int a, int b){
		       if(a == 0)
		    	   return b;
		       else if(b == 0)
		    	   return a;
		       return Math.min(a, b);
		    	   
	    }
	    
	    //
	    public int minDepth2(TreeNode root) {
	        if(root == null) return 0;
	        int left = minDepth(root.left);
	        int right = minDepth(root.right);
	        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
	       
	    }
}
