package 动态规划;

import javax.xml.crypto.Data;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 
	输入: 
	[
  		[1,3,1],
  		[1,5,1],
  		[4,2,1]
	]
	输出: 12
	解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
	
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 */
public class _剑指Offer47_礼物的最大价值 {

	/**
	 * 动态规划（二维数组）
	 * @param grid
	 * @return
	 */
	public int maxValue(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) return 0;
		
		int rows = grid.length;
		int cols = grid[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if(row == 0 && col == 0) continue;
				if(row == 0) {
					grid[row][col] += grid[row][col-1];
				}else if(col == 0){
					grid[row][col] += grid[row-1][col]; 
				}else {
					grid[row][col] += Math.max(grid[row-1][col], grid[row][col-1]);
				}
			}
		}
		
		return grid[rows-1][cols-1];
    }
	
	/**
	 * 优化版本 动态规划 + 一维数组
	 * @param grid
	 * @return
	 */
	public int maxValue2(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) return 0;
		
		// 只用一维数组
		int[] dp = new int[grid[0].length];
		
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				int left = 0, up = 0;
				if(row > 0) {
					up = dp[col];
				}
				if(col > 0) {
					left = dp[col-1];
				}
				dp[col] = Math.max(up, left) + grid[row][col];
			}
		}
		
		return dp[grid[0].length - 1];
	}
}
