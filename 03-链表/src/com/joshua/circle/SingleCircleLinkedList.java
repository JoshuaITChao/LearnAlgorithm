package com.joshua.circle;

import com.joshua.AbstractList;

public class SingleCircleLinkedList<E> extends AbstractList<E> {
	// 第一个节点
		private Node<E> first;
		
		// 私有类Node节点对象
		private static class Node<E> {
			E element;
			Node<E> next;
			public Node(E element, Node<E> next) {
				this.element = element;
				this.next = next;
			}
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				sb.append(element).append("_").append(next.element);
				return sb.toString();
			}
		}

		@Override
		public void clear() {
			size = 0;
			first = null;
		}

		@Override
		public E get(int index) {
			/**
			 * 最好：O(1)
			 * 最差：O(n)
			 * 平均：O(n)
			 */
			return node(index).element;
		}

		@Override
		public E set(int index, E element) {
			/**
			 * 最好：O(1)
			 * 最差：O(n)
			 * 平均：O(n)
			 */
			Node<E> node = node(index);
			E oldElement = node.element;
			node.element = element;
			return oldElement;
		}

		@Override
		public void add(int index, E element) {
			/**
			 * 最好：O(1)
			 * 最差：O(n)
			 * 平均：O(n)
			 */
			rangeCheckForAdd(index);
			
			if(index == 0) {
				Node<E> newFirst = new Node(element, first);
				// 拿到最后一个节点
				Node<E> last = (size == 0) ? newFirst : node(size - 1);
				last.next = newFirst;
				first = newFirst;
			}else {
				Node<E> prevNode = node(index - 1);
				prevNode.next = new Node<>(element, prevNode.next);
			}
			size++;	
		}

		@Override
		public E remove(int index) {
			/**
			 * 最好：O(1)
			 * 最差：O(n)
			 * 平均：O(n)
			 */
			rangeCheck(index);
			
			Node<E> node = first;
			if(index == 0) {
				
				if(size == 1) {
					first = null;
				}else {
					Node<E> last = node(size - 1);
					first = first.next;
					last.next = first;
				}
				
				first = first.next;
			}else {
				Node<E> prevNode = node(index-1);
				node = prevNode.next;
				prevNode.next = node.next;
			}
			size--;
			return node.element;
		}

		@Override
		public int indexOf(E element) {
			// 这里要区分element是null还是非空
			if(element == null) {
				Node<E> node = first;
				for (int i = 0; i < size; i++) {
					if(node.element == element) return i;
					node = node.next;
				}
			}else{
				Node<E> node = first;
				for (int i = 0; i < size; i++) {
					if(element.equals(node.element)) return i;
					node = node.next;
				}
			}
			return ELEMENT_NOT_FOUND;
		}
		
		/**
		 * 获取index位置对应的节点对象
		 */
		private Node<E> node(int index) {
			// 校验index合法性
			rangeCheck(index);
			
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
				
				string.append(node);
				
				node = node.next;
			}
			string.append("]");
			return string.toString();
		}
}
