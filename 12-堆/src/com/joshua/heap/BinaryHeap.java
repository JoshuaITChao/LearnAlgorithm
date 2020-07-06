package com.joshua.heap;

import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.joshua.printer.BinaryTreeInfo;


/**
 * 二叉堆（最大堆）
 * @author wisecotechcp
 *
 * @param <E>
 */
@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
	
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	
	public BinaryHeap(E[] elements, Comparator<E> comparator) {
		super(comparator);
		
		if(elements == null || elements.length == 0) {
			this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		}else {
			size = elements.length;
			int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
			this.elements = (E[])new Object[capacity];
			for (int i = 0; i < elements.length; i++) {
				this.elements[i] = elements[i];
			}
			// 建堆
			heapify();
		}
	}
	
	public BinaryHeap(E[] elements) {
		this(elements, null);
	}
	public BinaryHeap(Comparator<E> comparator) {
		this(null, comparator);
	}
	public BinaryHeap() {
		this(null, null);
	}

	
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 添加元素
	 */
	@Override
	public void add(E element) {
		// 校验元素是否为空
		elementNotNullCheck(element);
		// 扩容
		ensureCapacity(size+1);
		elements[size++] = element;
		
		// 上滤
		siftUp(size-1);
		
	}

	@Override
	public E get() {
		emptyCheck();
		return elements[0];
	}

	@Override
	public E remove() {
		emptyCheck();
		
		int lastIndex = --size;
		E root = elements[0];
		elements[0] = elements[lastIndex];
		elements[lastIndex] = null;
		
		siftDown(0);
		return root;
	}

	@Override
	public E replace(E element) {
		elementNotNullCheck(element);
		
		E root = null;
		if(size == 0) {
			elements[0] = element;
			size++;
		}else{
			root = elements[0];
			elements[0] = element;
			siftDown(0);
		}
		return root;
	}

	/**
	 * 批量建堆
	 */
	private void heapify() {
		// 自上而下的上滤
//		for (int i = 0; i < size; i++) {
//			siftUp(i);
//		}
		
		// 自下而上的下滤
		for (int i = (size >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}
	}
	
	/**
	 * 让index位置的元素下滤
	 * @param index
	 */
	private void siftDown(int index) {
		E element = elements[index];
		int half = size >> 1;
		// 第一个叶子节点的索引 == 非叶子节点的数量
		// index < 第一个叶子节点的索引
		// 必须保证index位置是非叶子节点
		while (index < half) {
			// index的节点有2中情况
			// 1.只有做节点
			// 2.同时有左右两个节点
			
			// 默认为左节点跟它进行比较
			int leftIndex = (index << 1) + 1;
			E child = elements[leftIndex];
			
			// 右节点
			int rightIndex = leftIndex + 1;
			
			// 选出左右节点最大的那个
			if(rightIndex < size && compare(elements[rightIndex], child) > 0) {
				child = elements[leftIndex = rightIndex];
			}
			
			if(compare(element, child) >= 0) break;
			
			// 将子节点存放到index位置
			elements[index] = child;
			// 重新设置index
			index = leftIndex;
		}
		
		elements[index] = element;
		
	}
	
	/**
	 * 让index位置的元素上滤
	 */
	private void siftUp(int index) {
		
//		E element = elements[index];
//		while (index > 0) {
//			int pindex = (index - 1) >> 1;
//			E p = elements[pindex];
//			if(compare(element, p) <= 0) return;
//			
//			// 交换index、pindex位置的内容
//			E tmp = elements[index];
//			elements[index] = elements[pindex];
//			elements[pindex] = tmp;
//			
//			// 重新赋值index
//			 index = pindex;
//		}
		
		// 优化：不需要交互值
		E element = elements[index];
		while (index > 0) {
			int pindex = (index - 1) >> 1;
			E p = elements[pindex];
			if(compare(element, p) <= 0) return;
			
			// 交换index、pindex位置的内容
			elements[index] = p;
			
			// 重新赋值index
			 index = pindex;
		}
		elements[index] = element;
		
	}
	/**
	 * 校验数据是否为null
	 * @param element
	 */
	private void elementNotNullCheck(E element) {
		if(element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	/**
	 * 校验堆是否为空
	 */
	private void emptyCheck() {
		if(size == 0) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}
	}
	/**
	 * 数组扩容
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	@Override
	public Object root() {
		return 0;
	}

	@Override
	public Object left(Object node) {
		int index = ((int)node << 1) + 1;
		return index >= size ? null : index;
	}

	@Override
	public Object right(Object node) {
		int index = ((int)node << 1) + 2;
		return index >= size ? null : index;
	}

	@Override
	public Object string(Object node) {
		return elements[(int)node];
	}

}
