package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍
 * @author wisecotechcp
 *
 */

public class _1_两数之和 {

	public int[] twoSum(int[] nums, int target) {
		return twoSum1(nums, target);
    }
	
	/**
	 * 方法一：暴力法，遍历每个元素x，并查找是否存在一个值与target - x相等的目标元素
	 * 
	 * 复杂度分析：
	 * 		时间复杂度O(n^2)
	 * 		对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)。
	 * 		空间复杂度：O(1)。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No Two sum solution");
	}
	
	/**
	 * 方法二：两遍哈希表
	 * 
	 * 复杂度分析：
	 * 		时间复杂度：O(n)，
	 * 		我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)O(1)O(1) ，所以时间复杂度为 O(n)O(n)O(n)。
	 * 		空间复杂度：O(n)，
	 * 		所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	/**
	 * 方法三：一遍哈希表
	 * 时间复杂度：O(n)
	 * 		我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
	 * 空间复杂度：O(n)
	 * 		所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum3(int[] nums, int target) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
}
