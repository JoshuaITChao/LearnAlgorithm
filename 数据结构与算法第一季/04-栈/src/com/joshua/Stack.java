package com.joshua;

import com.joshua.list.ArrayList;
import com.joshua.list.List;

public class Stack<E> {
	
	private List<E> list = new ArrayList<>();
	
	/**
	 * 返回栈的长度
	 * @return
	 */
	public int size() { return list.size(); }
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty() { return list.isEmpty(); }
	/**
	 * 入栈
	 * @param element
	 */
	public void push(E element) { list.add(element); }
	/**
	 * 出栈
	 * @return
	 */
	public E pop() { return list.remove(list.size() - 1); }
	/**
	 * 返回栈顶元素
	 * @return
	 */
	public E top() { return list.get(list.size() - 1); }

}
