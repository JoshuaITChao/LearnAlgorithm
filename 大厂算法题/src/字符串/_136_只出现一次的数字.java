package 字符串;

import java.util.Iterator;

public class _136_只出现一次的数字 {

	public int singleNumber(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
    }
}
