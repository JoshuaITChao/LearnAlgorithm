package com.joshua.sort.cmp;

import com.joshua.sort.Sort;


/**
 * 最好、最坏、平均的时间复杂度 O(n^2)
 * @author wisecotechcp
 *
 * @param <T>
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			int max = 0;
			for (int begin = 1; begin <= end; begin++) {
				if(cmp(max, begin) < 0){
					max = begin; 
				}
			}
			
			swap(max, end);
		}
		
	}

}
