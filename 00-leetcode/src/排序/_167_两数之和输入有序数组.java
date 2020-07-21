package 排序;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author dingxiaomin
 *
 */
public class _167_两数之和输入有序数组 {

	public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low+1, high+1};
            }else if(sum < target){
                low++;
            }else{
                high--;
            }
        }
        return new int[]{-1, -1};

    }
}
