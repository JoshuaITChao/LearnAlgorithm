package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 
 * 大致思路：
 *      第1步：去掉多余的空格，巧妙运用 cur
 *      第2步：对整个字符串进行逆序
 *      第3步：在对单个单词进行逆序
 * 注意点：
 *      由于单词的判断通过空格实现的，可是最后一个单词是没有空格的，所以需要特殊处理一下
 */
public class _151_翻转字符串里的单词 {

	public static void main(String[] args) {
		System.out.println("666_" + reverseWords("") + "_666");
		System.out.println("666_" + reverseWords("  hello world!     ") + "_666");
		System.out.println("666_" + reverseWords("a good   example") + "_666");
		System.out.println("666_" + reverseWords("are you ok") + "_666");
	}
	
	/**
	 * 翻转字符串里的单词
	 * @param s
	 * @return
	 */
	static String reverseWords(String s) {
		
		if(s == null) return "";
		char[] chars = s.toCharArray();
		
		// 第1步，去掉字符串中多余的空格
		// 记录字符串的有效长度
		int len = 0;
		// 记录当前存放字符的长度
		int cur = 0;
		// 记录前一个字符是否是空格
		boolean space = true;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] != ' ') {	// chars[i] 不是空格
				chars[cur++] = chars[i];
				space = false;
			}else if(space == false){	// chars[i]是空格，但是chars[i-1]不是空格
				chars[cur++] = ' ';
				space = true;
			}
		}
		len = space ? cur - 1 : cur;
		if(len <= 0) return "";
		
		// 第2步：对整个有效的字符串进行逆序
		reverse(chars, 0, len);
		
		// 对每个单词进行逆序
		// 前一个空格字符的位置（有-1位置有个假想的哨兵，就是一个假想的空格字符）
		int preSpaceIndex = -1;
		for (int i = 0; i < len; i++) {
			if(chars[i] != ' ') continue;
			// i是空格字符串的位置
			reverse(chars, preSpaceIndex + 1, i);
			preSpaceIndex = i;
		}
		
		// 注意由于字符串最后不是空格，所以不会逆序，要单独处理
		reverse(chars, preSpaceIndex + 1, len);
		
		return new String(chars, 0, len);
    }
	
	/**
	 * 将[li, ri)范围内的字符串进行逆序
	 * @param chars
	 * @param li
	 * @param ri
	 */
	private static void reverse(char[] chars, int li, int ri) {
		ri--;
		while (li < ri) {
			char tmp = chars[li];
			chars[li] = chars[ri];
			chars[ri] = tmp;
			li++;
			ri--;
		}
	}
	
}
