package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * @author dingxiaomin
 *
 */
public class _105_从前序与中序遍历序列构造二叉树 {
	
	private Map<Integer, Integer> indexMap;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根结点
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);

    }
	
	/**
	 * 递归
	 * @param preorder
	 * @param inorder
	 * @param preorder_left
	 * @param preorder_right
	 * @param inorder_left
	 * @param inorder_rigt
	 * @return
	 */
	public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_rigt) {
		if(preorder_left > preorder_right) return null;
		
		// 前序遍历中的第一个节点就是根结点
		int preorder_root = preorder_left;
		// 在中序遍历中定位根结点
		int inorder_root = indexMap.get(preorder[preorder_root]);
		
		// 先把根结点构建起来
		TreeNode root = new TreeNode(preorder[preorder_root]);
		// 得到左子数的节点个数
		int size_left_subtree = inorder_root - inorder_left;
		// 递归构造左子树，并连接根结点
		// 先序遍历中[从 左边界+1 到 size_left_subtree] 个元素就对应中序遍历中从 [左边界 到  根结点定位-1]的元素
		root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
		
		// 递归构造右子树,并连接根结点
		// 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
		root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_rigt);
		return root;
	}
	
	
}
