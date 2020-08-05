package 栈;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 *
 */
public class _面试题_08_06_汉诺塔问题 {

	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

		move(A.size(), A, B, C);
		
    }
	
	private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
		if(n == 1) {
			C.add(A.remove(A.size()-1));
			return;
		}
		move(n-1, A, C, B);
		C.add(A.remove(A.size()-1));
		move(n-1, B, A, C);
	}
}
