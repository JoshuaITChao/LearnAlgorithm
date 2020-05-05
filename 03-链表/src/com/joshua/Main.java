package com.joshua;


public class Main {

	public static void main(String[] args) {
		
		// ArrayList相关操作
		List<Integer> arrList = new ArrayList<>();
		arrList.add(10);
		arrList.add(20);
		arrList.add(1, 30);
		arrList.add(40);
		System.out.println(arrList);
		
		// LinkedList相关操作
		List<String> linkedList = new LinkedList<>();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add(1, "c");
		linkedList.add(linkedList.size(), "d");
		// size=4, [a, c, b, d]
		
		linkedList.remove(1);
		
		System.out.println(linkedList);

	}

}
