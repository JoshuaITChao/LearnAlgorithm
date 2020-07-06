package com.joshua.tree;

import java.util.Comparator;

import org.w3c.dom.ls.LSException;

public class BST<E> extends BinaryTree<E> {

	private Comparator<E> comparator;
	
	public BST() {
		this(null);
	}
	
	public BST(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * 构建二叉树
	 */
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if(root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点
		// 找到父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if(cmp > 0) {
				node = node.right;
			}else if(cmp < 0) {
				node = node.left;
			}else {
				node.element = element;
				return;
			}
			
		}
		
		// 看看查到父节点的什么位置
		Node<E> newNode = new Node<>(element, parent);
		if(cmp > 0) {
			parent.right = newNode;
		}else{
			parent.left = newNode;
		}
		size++;
	}
	/**
	 * 删除节点
	 * @param element
	 */
	public void remove(E element) {
		remove(node(element));
	}
	
	/**
	 * 是否包含元素
	 * @param element
	 * @return
	 */
	public boolean contains(E element) {
		return node(element) != null;
	}
	
	
	private void remove(Node<E> node) {
		if(node == null) return;
		
		size--;
		
		if(node.hasTwoChildren()) { // 有两个节点
			// 找到后继节点
			Node<E> s = successor(node);
			// 用后继节点的值覆盖度为2的节点
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		
		// 删除 node 节点（node 节点的度必然是0或1）
		Node<E> replacement = node.left != null ? node.left : node.right;
		if(replacement != null) { 	// node是度为1的节点
			// 更改parent
			replacement.parent = node.parent;
			// 更改parent的left和right的指向
			if(node.parent == null) {	// node是度为1的节点，并且是根节点
				root = replacement;
			}else if(node == node.parent.left) {
				node.parent.left = replacement;
			}else {
				node.parent.right = replacement;
			}
			
		} else if(node.parent == null) {	// node是叶子节点而且是根节点
			root = null;
		}else {	// node是叶子节点，但不是根节点
			if(node == node.parent.left) {
				node.parent.left = null;
			}else {
				node.parent.right = null;
			}
			
		}
	}
	
	/**
	 * 根据 element 获取对应节点
	 * @param element
	 * @return
	 */
	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			} else { // cmp < 0
				node = node.left;
			}
		}
		return null;
	}
	
	
	/**
	 * 比较两个元素大小
	 * 0：e1 == e2
	 * >0：e1 > e2
	 * <0：e1 < e2
	 * @return
	 */
	private int compare(E e1, E e2) {
		if(comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	/**
	 * 校验element元素是否为空
	 * @param element
	 */
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
}
