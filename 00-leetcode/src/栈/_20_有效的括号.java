package 栈;

import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 测试
		boolean isValid1 = isValid1("({[]})");
		System.out.println(isValid1);
		
		boolean isValid2 = isValid2("({[]})");
		System.out.println(isValid2);
		
		boolean isValid3 = isValid3("({[]})");
		System.out.println(isValid3);
	}
	
	/**
	 * 最简单的匹配规则
	 */
	public static boolean isValid1(String s) {
		 while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
			s = s.replace("{}", "");
			s = s.replace("[]", "");
			s = s.replace("()", "");
		}
		 return s.isEmpty();
	 }
	
	/**
	 * 检验有效的括号
	 * 借助HashMap的方式进行匹配
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 */
	public static boolean isValid2(String s) {
	
		// 创建HashMap对象
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		// 创建栈容器
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				// 左括号
				stack.push(c);
			}else {
				// 右括号
				if(stack.isEmpty()) return false;
				if(c != map.get(stack.pop())) return false;
			}
		}
		return stack.isEmpty();
	}
	
	/**
	 * 检验有效的括号
	 * 通过栈的方式进行匹配
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 */
	public static boolean isValid3(String s) {
		// 初始化java系统栈
		Stack<Character> stack = new Stack<>();
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				// 左括号
				stack.push(c);
			} else {
				// 右括号
				if(stack.isEmpty()) return false;
				char left = stack.pop();
				if(left == '(' && c != ')') return false;
				if(left == '{' && c != '}') return false;
				if(left == '[' && c != ']') return false;
			}
		}
		return stack.isEmpty();
    }

}
