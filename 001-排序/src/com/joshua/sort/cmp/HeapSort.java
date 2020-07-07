package com.joshua.sort.cmp;

import com.joshua.sort.Sort;

/**
 * 最好、最坏、平均复杂度都是 nlog(n)
 * @author wisecotechcp
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

	private int heapSize;
	
	@Override
	protected void sort() {
		
		// 原地建堆
		heapSize = array.length;
		
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			siftDown(i);
		}
		
		while (heapSize > 1) {
			swap(0, --heapSize);
			
			// 对0位置进行siftDown下移（恢复堆的性质）
			siftDown(0);
		}
		
	}
	
	private void siftDown(int index) {
		T element = array[index];
		
		int half = heapSize >> 1;
		
		while (index < half) {	// index必须是非叶子节点
			
			// 默认是左节点根父节点比较
			int childIndex = (index << 1) + 1;
			T child = array[childIndex];
			
			int rightIndex = childIndex + 1;
			// 右节点比左节点大
			while (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
				child = array[childIndex=rightIndex];
			}
			
			// 大于等于子节点
			if(cmp(element, child) >= 0) break;
			
			array[index] = child;
			index = childIndex;
		}
		array[index] = element;
	}

}
