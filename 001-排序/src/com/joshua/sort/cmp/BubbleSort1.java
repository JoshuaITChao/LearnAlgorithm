package com.joshua.sort.cmp;

import com.joshua.sort.Sort;


/**
 * 
 * 最坏、平均的时间复杂度 O(n^2)
 * 最好的时间复杂度 O(n)
 * @author wisecotechcp
 *
 * @param <T>
 */
public class BubbleSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		
		for (int end = array.length - 1; end > 0; end--) {
			for (int begin = 1; begin <= end; begin++) {
				if(cmp(begin, begin - 1) < 0) {
					swap(begin, begin-1);
				}	
			}
		}
		
	}

}
