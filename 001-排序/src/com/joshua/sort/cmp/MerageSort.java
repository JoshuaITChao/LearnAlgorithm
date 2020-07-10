package com.joshua.sort.cmp;

import com.joshua.sort.Sort;

/**
 * 归并排序的最好、最坏、平均复杂度均为 nlog(n)
 * @author wisecotechcp
 *
 * @param <T>
 */
public class MerageSort<T extends Comparable<T>> extends Sort<T> {

	private T[] leftArray;
	
	@Override
	protected void sort() {
		leftArray = (T[])new Comparable[array.length >> 1];
		sort(0, array.length);
	}
	
	/**
	 * 对 [begin, end) 范围对数据进行归并排序
	 * @param beigin
	 * @param end
	 */
	private void sort(int begin, int end) {
		if(end - begin < 2) return;
		
		int mid = (begin + end) >> 1;
		sort(begin, mid);
		sort(mid, end);
		merage(begin, mid, end);
	}
	
	/**
	 * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序的序列
	 * @param begin
	 * @param mid
	 * @param end
	 */
	private void merage(int begin, int mid, int end) {
		int li = 0, le = mid - begin;
		int ri = mid, re = end;
		int ai = begin;
		
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		// 如果左边还没有结束
		while (li < le) {
			if(ri < re && cmp(array[ri], leftArray[li]) < 0) {
				array[ai++] = array[ri++];
			}else {
				array[ai++] = leftArray[li++];
			}
		}
	}
	
	

}
