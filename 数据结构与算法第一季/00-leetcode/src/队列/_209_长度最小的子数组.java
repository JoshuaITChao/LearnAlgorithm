package 队列;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 题目描述：
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */

public class _209_长度最小的子数组 {
	
	public int minSubArrayLen(int s, int[] nums) {
		
		
		return minSubArrayLen2(s, nums);
    }
	
	/**
	 * 暴力求解
	 * 首先最容易想到的是暴力求解，使用两个for循环，一个for循环固定一个数字比如m，另一个for循环从m的下一个元素开始累加，
	 * 当和大于等于s的时候终止内层循环，顺便记录下最小长度
	 */
	private int minSubArrayLen2(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = nums[i];
			if(sum >= s) return 1;
			for (int j = i+1; j < nums.length; j++) {
				sum += nums[j];
				if(sum >= s) {
					min = Math.min(min, j-i+1);
					break;
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	/**
	 * 使用队列相加（实际上我们也可以把它称作是滑动窗口，这里的队列其实就相当于一个窗口）
	 * 我们把数组中的元素不停的入队，直到总和大于等于s为止，接着记录下队列中元素的个数，然后再不停的出队，
	 * 直到队列中元素的和小于s为止（如果不小于s，也要记录下队列中元素的个数，这个个数其实就是不小于s的连续子数组长度，
	 * 我们要记录最小的即可）。接着再把数组中的元素添加到队列中……重复上面的操作，直到数组中的元素全部使用完为止。
	 */
	private int minSubArrayLen3(int s, int[] nums) {
		int low = 0, high = 0, sum = 0, min = Integer.MAX_VALUE;
		while (high < nums.length) {
			sum += nums[high++];
			while (sum >= s) {
				min = Math.min(min, high - low);
				sum -= nums[low++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
