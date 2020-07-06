package com.joshua;

@SuppressWarnings("unchecked")
public class ArrayList<E> {
	/**
	 * 元素的数量
	 */
	private int size;
	/**
	 * 所有元素
	 */
	private E[] elements;

	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	public ArrayList(int capaticy) {
		capaticy = (capaticy > DEFAULT_CAPATICY) ? capaticy : DEFAULT_CAPATICY;
		elements = (E[])new Object[capaticy];
	}

	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}
	
	/**
	 * 清除所有元素
	 */
	public void clear() {
		// 注意：由于这里改成存储泛型对象，所以要考虑内存泄漏问题
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	/**
	 * 元素数量
	 */
	public int size() {
		return size;
	}
	/**
	 * 是否为空
	 * @return
	 */
	public Boolean isEmpty() {
		return size == 0;
	}
	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	public Boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	/**
	 * 添加元素到尾部
	 * @param element
	 */
	public void add(E element) {
		add(size, element);
	}
	/**
	 * 获取index位置到元素
	 * @param index
	 * @return 
	 */
	public E get(int index) {
		// 检查索引是否合法
		rangeCheck(index);
		// 根据索引获取对应的元素
		return elements[index];
	}
	/**
	 * 设置index位置到元素
	 * @param index
	 * @param element
	 * @return 原来位置到元素
	 */
	public E set(int index, E element) {
		// 检查索引是否合法
		rangeCheck(index);
		
		// 获取原来位置的元素
		E oldElement = elements[index];
		elements[index] = element;
		return oldElement;
		
	}
	/**
	 * 在index位置插入一个元素
	 * @param index
	 * @param element
	 */
	public void add(int index, E element) {
		// 检查索引是否合法
		rangeCheckForAdd(index);
		// 确保有足够容量
		ensureCapaticy(size + 1);
		
		for (int i = size-1; i >= index; i++) {
			elements[i+1] = elements[i];
		}
		elements[index] = element;
		size++;
		
	}
	/**
	 * 删除index位置的元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		// 检查索引是否合法
		rangeCheck(index);
		
		E oldElement = elements[index];
		for (int i = index+1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		elements[--size] = null;
		return oldElement;
	}
	/**
	 * 查看元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if(element == null) {
			for (int i = 0; i < size; i++) {
				if(elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if(element.equals(elements[i])) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 检查索引是否合法
	 * @param index
	 */
	private void rangeCheck(int index) {
		if(index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	private void rangeCheckForAdd(int index) {
		if(index < 0 || index > size) {
			outOfBounds(index);
		}
	}
	private void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index："+index+", Size："+size);
	}
	/**
	 * 保证要有足够的capacity容量
	 */
	private void ensureCapaticy(int capacity) {
		int oldCapaticy = elements.length;
		if(oldCapaticy >= capacity) return;
		
		// 新容量为旧容量的1.5倍
		int newCapaticy = oldCapaticy + (oldCapaticy >> 1);
		
		E[] newElements = (E[])new Object[newCapaticy];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapaticy + "扩容为：" + newCapaticy);
	}
	
	@Override
	public String toString() {
		// size = 3, [99, 98, 97]
		StringBuffer string = new StringBuffer();
		string.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if(i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
}
