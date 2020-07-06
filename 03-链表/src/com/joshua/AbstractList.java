package com.joshua;

public abstract class AbstractList<E> implements List<E> {
	/**
	 * 元素的数量
	 */
	protected int size;
	/**
	 * 元素数量
	 */
	public int size() { return size; }
	/**
	 * 是否为空
	 * @return
	 */
	public Boolean isEmpty() { return size == 0; }
	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public Boolean contains(E element) { return indexOf(element) != ELEMENT_NOT_FOUND; }
	
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) { add(size, element); }
	
	/**
	 * 检查索引是否合法
	 * @param index
	 */
	protected void rangeCheck(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	/**
	 * 检查添加元素的索引是否合法
	 * @param index
	 */
	protected void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	/**
	 * 索引越界
	 * @param index
	 */
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index："+index+", Size："+size);
	}
}
