package com.joshua.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.joshua.printer.BinaryTreeInfo;


public class BinaryTree<E> implements BinaryTreeInfo {
	
	protected int size;
	protected Node<E> root;
	
	public boolean isEmpty() { return size == 0; }
	
	public void clear() {
		size = 0;
		root = null;
	}
	
	/**
	 * 前序遍历
	 * @param visitor
	 */
	public void preorder(Visitor<E> visitor) {
		preorder(root, visitor);
	}
	private void preorder(Node<E> node, Visitor<E> visitor) {
		if(node == null || visitor == null) return;
		
		visitor.visit(node.element);
		preorder(node.left, visitor);
		preorder(node.right, visitor);
	}
	/**
	 * 中序遍历
	 * @param vistor
	 */
	public void inorder(Visitor<E> visitor) {
		inorder(root, visitor);
	}
	private void inorder(Node<E> node, Visitor<E> visitor) {
		if(node == null || visitor == null) return;
		
		inorder(node.left, visitor);
		visitor.visit(node.element);
		inorder(node.right, visitor);
	}
	/**
	 * 后续遍历
	 * @param visitor
	 */
	public void postorder(Visitor<E> visitor) {
		postorder(root, visitor);
	}
	
	private void postorder(Node<E> node, Visitor<E> visitor) {
		if(node == null || visitor == null) return;
		postorder(node.left, visitor);
		postorder(node.right, visitor);
		visitor.visit(node.element);
	}
	/**
	 * 层序遍历
	 * @param visitor
	 */
	public void levelorder(Visitor<E> visitor) {
		if(root == null || visitor == null) return;
		
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			visitor.visit(node.element);
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		
	}
	
	public int depath() {
		if(root == null) return 0;
		
		// 树的高度
		int height = 0;
		// 每一层节点的数量
		int levelSize = 1;
		
		Queue<Node<E>>queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			
			if(node.right != null) {
				queue.offer(node.right);
			}
			// levelSize == 0 意味着访问这层完毕
			if(levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}
	
	/**
	 * 根据某个节点获取该节点的深度
	 * @param node
	 * @return
	 */
	private int depath(Node<E> node) {
		if(node == null) return 0;
		return 1 + Math.max(depath(node.left), depath(node.right));
	}
	
	
	/**
	 * 获取前驱节点
	 * 第一种情况： node.left != null
	 * 循环条件：node.left.right.right.right
	 * 终止条件： right为null
	 * 
	 * 第二种情况： node.left == null && node.parent != null
	 * 循环条件：node.parent.parent.parent
	 * 终止条件：node 出现在 parent 的右子树中
	 * 
	 * 
	 * 第三种情况：node.left == null && node.parent == null
	 * 没有前驱节点
	 * 
	 * @param node
	 * @return
	 */
	protected Node<E> predecessor(Node<E> node){
		if(node == null) return null;
		Node<E> p = node.left;
		// 第一种情况 node.left != null
		if(p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		
		// 第二种情况 node.left == null && node.parent != null
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		
		// 第三种情况
		// node.parent == null
		// node = node.parent.right
		return node.parent;
	}
	
	/**
	 * 获取后继节点
	 * 第一种情况： node.right != null
	 * 循环条件：node.right.left.left.left
	 * 终止条件： left为null
	 * 
	 * 第二种情况： node.right == null && node.parent != null
	 * 循环条件：node.parent.parent.parent
	 * 终止条件：node 出现在 parent 的右子树中
	 * 
	 * 
	 * 第三种情况：node.right == null && node.parent == null
	 * 没有前驱节点
	 * 
	 * @param node
	 * @return
	 */
	protected Node<E> successor(Node<E> node) {
		if(node == null) return null;
		Node<E> p = node.right;
		// 第一种情况 node.left != null
		if(p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		
		// 第二种情况 node.left == null && node.parent != null
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		
		// 第三种情况
		// node.parent == null
		// node = node.parent.right
		return node.parent;
	}
	
	
	
	public static interface Visitor<E> {
		void visit(E element); 
	}
	
	
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
				
		}
		
		public boolean isLeaf() { return left == null && right == null; }
		public boolean hasTwoChildren() { return left != null && right != null; }
	}
	

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
	}

}
