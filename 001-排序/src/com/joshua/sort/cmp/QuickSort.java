package com.joshua.sort.cmp;

import com.joshua.sort.Sort;

/**
 * 最好、平均复杂度(O(nlogn))
 * 最坏平均复杂度(O(n^2))
 * @author dingxiaomin
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		// TODO Auto-generated method stub
		sort(0, array.length);
	}
	
	/**
	 * 对[begin, end)范围对元素进行快速排序
	 * @param begin
	 * @param end
	 */
	private void sort(int begin, int end) {
		if(end - begin < 2) return;
		
		// 确定轴点位置
		int mid = pivotIndex(begin, end);
		
		// 最子序列排序
		sort(begin, mid);
		sort(mid+1, end);
	}
	
	/**
	 * 构造[begin, end)对轴点元素
	 * @param begin
	 * @param end
	 * @return
	 */
	private int pivotIndex(int begin, int end) {
		
		// 备份begin位置对元素
		T pivot = array[begin];
		// end指向最后一个元素
		end--;
		
		while (begin < end) {
			while (begin < end) {
				if(cmp(pivot, array[end]) < 0) {	// 右边元素 > 轴点元素
					end--;
				}else { // 右边元素 <= 轴点元素
					array[begin++] = array[end];
					break;
				}
			}
			
			while (begin < end) {
				if(cmp(pivot, array[begin]) > 0) {	// 左边元素 < 轴点元素
					begin++;
				}else {	// 左边元素 >= 轴点元素
					array[end--] = array[begin];
					break;
				}
			}
		}
		
		// 将轴点元素放入最终位置
		array[begin] = pivot;
		// 返回轴点元素对位置
		return begin;
		
	}

}
