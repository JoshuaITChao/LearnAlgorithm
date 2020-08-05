package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import 链表.ListNode;

public class _144_二叉树的前序遍历 {
	
	/**
	 * 迭代器的方式实现前序遍历
	 * @param root
	 * @return
	 */
	
	public List<Integer> preorderTraversal(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> output = new LinkedList<>();
		
		if(root == null) return output;
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			output.add(node.val);
			
			if(node.right != null) {
				stack.push(node.right);
			}
			
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		
		
		return output;
    }
}
