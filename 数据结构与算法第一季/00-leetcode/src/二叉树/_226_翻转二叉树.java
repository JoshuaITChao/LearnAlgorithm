package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 
 * @author wisecotechcp
 * 
     4
   /   \
  2     7
 / \   / \
1   3 6   9

翻转之后：

	 4
   /   \
  7     2
 / \   / \
9   6 3   1

 *
 */
public class _226_翻转二叉树 {
	
	/**
	 * 层序遍历的方式翻转二叉树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		
		if(root == null) return root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		
		return root;
	}
	
	/**
	 * 前序遍历的方式翻转二叉树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree1(TreeNode root) {
		if(root == null) return root;
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
	}
	
	/**
	 * 中序遍历的方式翻转二叉树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree2(TreeNode root) {
		if(root == null) return root;
		
		invertTree(root.left);
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		invertTree(root.left);
		
		return root;
	}
	
	/**
	 * 后序遍历的方式翻转二叉树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree3(TreeNode root) {
		if(root == null) return root;
		
		invertTree(root.left);
		invertTree(root.right);
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
