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
		// size=3, [a, b, d]
		
		System.out.println(linkedList);
		
		
		// LinkedList2相关操作(虚拟头节点)
		List<String> linkList2 = new LinkedList2<>();
		linkList2.add("A");
		linkList2.add("B");
		linkList2.add(2, "C");
		int index =  linkList2.indexOf("C");
		System.out.println(index);
		System.out.println(linkList2);
		

	}

}
