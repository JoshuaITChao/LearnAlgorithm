package com.joshua.circle;

import com.joshua.AbstractList;

public class CircleDoubleLinkedList<E> extends AbstractList<E>{
	
	
	/**
	 * 私有类节点对象
	 * @author wisecotechcp
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		E element;
		Node<E> prev;
		Node<E> next;
		public Node(Node<E> prev,E element, Node<E> next){
			this.prev = prev;
			this.next = next;
			this.element = element;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			
			sb.append("_").append(element).append("_");

			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			
			return sb.toString();
		}
	}
	
	private Node<E> first;
	private Node<E> last;

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
		last = null;
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		
		// index = 0
		// size = 0
		if(index == size) {
			// 往后面添加元素
			Node<E> oldLast = last;
			last = new Node<>(oldLast, element, first);
			if(oldLast == null) {
				// 这是链表的第一个元素
				first = last;
				first.prev = first;
				first.next = first;
			}else {
				oldLast.next = last;
				first.prev = first;
			}
		}else {
			// 往前面添加元素
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<>(prev, element, next);
			next.prev = node;
			prev.next = node;
			
			if(next == first) {	// index = 0
				first = node;
			}
		}
		
		size++;
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if(prev == null) {
			first = next;
		}else {
			prev.next = next;
		}
		
		if(next == null) {
			last = prev;
		}else {
			next.prev = prev;
		}
		
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
				if(element.equals(node.element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 根据索引index获取对应的节点
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		
		if(index < (size >> 1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size-1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
		
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
			
			string.append(node);
			
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}

}
