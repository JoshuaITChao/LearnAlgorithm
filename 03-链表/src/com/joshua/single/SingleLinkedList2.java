package com.joshua.single;

import com.joshua.AbstractList;

/**
 * 通过虚拟头节点，优化add和set方法，使其处理逻辑和其他节点一致
 * @author JoshuaSuper
 *
 * @param <E>
 */

public class SingleLinkedList2<E> extends AbstractList<E> {
	
	// 私有类，Node节点对象
	private static class Node<E> {
		E element;
		Node<E> next;
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	// 创建first节
	private Node<E> first;
	
	public SingleLinkedList2 () {
		first = new Node<>(null, null);
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
		
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E oldElement = node.element;
		node.element = element;
		return oldElement;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		
		Node<E> prevNode = index == 0 ? first : node(index - 1);
		prevNode.next = new Node<>(element, prevNode.next);
		
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		
		Node<E> prevNode = index == 0 ? first : node(index - 1);
		Node<E> node = prevNode.next;
		prevNode.next = node.next;
		
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		if(element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if(node.element == element) return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if(node.element.equals(element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 根据index获取对应的节点
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		// 从第一个节点开始遍历
		Node<E> node = first.next;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first.next;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			
			string.append(node.element);
			
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}

}
