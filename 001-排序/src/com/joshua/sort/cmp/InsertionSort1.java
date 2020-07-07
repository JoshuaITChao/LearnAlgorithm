package com.joshua.sort.cmp;

import com.joshua.sort.Sort;

/**
 * 最坏和平局的复杂度	O(n2)
 * 最好的时间的复杂度 O(n)
 * @author wisecotechcp
 *
 * @param <T>
 */
public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			while (cur > 0 && cmp(cur, cur-1) < 0) {
				swap(cur, cur-1);
				cur--;
			}
		}
		
	}

}
