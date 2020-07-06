package 二叉树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author wisecotechcp
 *
 */
public class _700_二叉搜索树中的搜索 {

	
	public TreeNode searchBST(TreeNode root, int val) {
		
		while (root != null && val != root.val) {
			root = val > root.val ? root.right : root.left;
		}
		return root;
    }
	
	/**
	 * 递归实现
	 * @param root
	 * @param val
	 * @return
	 */
	public TreeNode searchBST2(TreeNode root, int val) {
		if(root == null || root.val == val) return root;
		return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
