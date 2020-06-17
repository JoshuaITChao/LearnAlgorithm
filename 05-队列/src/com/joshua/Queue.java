package com.joshua;

import com.joshua.list.LinkedList;
import com.joshua.list.List;

public class Queue<E> {
	// 通过链表实现
	private List<E> list = new LinkedList<>();
	/**
	 * 获取队列长度
	 * @return
	 */
	public int size() { return list.size(); }
	/**
	 * 判读队列是否为空
	 * @return
	 */
	public boolean isEmpty() { return list.isEmpty(); }
	
	/**
	 * 入队列
	 * @param element
	 */
	public void enQueue(E element) { list.add(element); }
	/**
	 * 出队列
	 * @return
	 */
	public E deQueue() { return list.remove(0); }
	/**
	 * 获取队列头节点
	 * @return
	 */
	public E front() { return list.get(0); }
	
}
