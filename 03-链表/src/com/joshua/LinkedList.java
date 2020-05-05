package com.joshua;

public class LinkedList<E> extends AbstractList<E> {
	
	// 私有类，Node节点对象
	private static class Node<E>{
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
	}
	
	// 创建First节点
	private Node<E> first;
	
	@Override
	public void clear() {
		size = 0;
		first = null;
		
	}

	@Override
	public E get(int index) { return node(index).element; }

	@Override
	public E set(int index, E element) {
		
		Node<E> node = node(index);
		E oldE = node.element;
		node.element = element;
		return oldE;
	}

	@Override
	public void add(int index, E element) {
		// 针对头部节点特殊处理
		if(index == 0) {
			first = new Node<E>(element, first);
		}else {
			// 获取index索引对应的上一个元素
			Node<E> preNode = node(index - 1);
			preNode.next = new Node<E>(element, preNode.next);
		}
		// 注意：size++
		size++;
	}

	@Override
	public E remove(int index) {
		// 注意：检查索引的合法性
		rangeCheck(index);
		
		// 针对头部元素特殊处理
		Node<E> node = first;
		if(index == 0) {
			first = node.next;
		}else {
			Node<E> preNode = node(index-1);
			node = preNode.next;
			preNode.next = node.next;
		}
		// 注意：size--
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 根据索引获取对应的Node节点
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		// 检查索引是否合法
		rangeCheck(index);
		// 从第一个节点开始遍历
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node.element);
			
			node = node.next;
		}
		string.append("]");
		
//		Node<E> node1 = first;
//		while (node1 != null) {
//			
//			
//			node1 = node1.next;
//		}
		return string.toString();
	}

}
