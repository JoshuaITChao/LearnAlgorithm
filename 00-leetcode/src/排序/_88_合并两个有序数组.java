package 排序;

/**
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 
 * 
 * @author dingxiaomin
 *
 */
public class _88_合并两个有序数组 {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
		
		while (p2 >= 0) {
			if (p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p3--] = nums1[p1--];
			}else {
				nums1[p3--] = nums2[p2--];
			}
		}
    } 
}
