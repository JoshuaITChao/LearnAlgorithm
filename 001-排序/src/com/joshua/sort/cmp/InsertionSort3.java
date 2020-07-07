package com.joshua.sort.cmp;

import com.joshua.sort.Sort;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		
		for (int begin = 1; begin < array.length; begin++) {
			insert(begin, search(begin));
		}
		
	}
	
	private void insert(int source, int dest) {
		T v = array[source];
		
		for (int i = source; i > dest; i--) {
			array[i] = array[i-1];
		}
		array[dest] = v;
	}
	
	
	/**
	 * 利用二分搜索找到 index 位置元素的待插入位置
	 * 已经排好序的数组的区间范围是 [0, index]
	 * @param index
	 * @return
	 */
	private int search(int index) {
		int begin = 0;
		int end = index;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if(cmp(array[index], array[mid]) < 0) {
				end = mid;
			}else {
				begin = mid + 1;
			}
		}
		
		return begin;
	}

}
