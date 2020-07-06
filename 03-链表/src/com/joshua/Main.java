package com.joshua;

import com.joshua.Double.DoubleLinkedList;
import com.joshua.circle.SingleCircleLinkedList;
import com.joshua.single.SingleLinkedList;
import com.joshua.single.SingleLinkedList2;

public class Main {
	
	static void testList(List<Integer> list) {
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		System.out.println(list);		// size=4,[11, 22, 33, 44]
		
		list.add(0, 55);				// size=5,[55, 11, 22, 33, 44]
		list.add(2, 66);				// size=6,[55, 11, 66, 22, 33, 44]
		list.add(list.size(), 77);		// size=7,[55, 11, 66, 22, 33, 44, 77]
		System.out.println(list);
		
		list.remove(0);					// size=6,[11, 66, 22, 33, 44, 77]
		list.remove(2);					// size=5,[11, 66, 33, 44, 77]
		list.remove(list.size()-1);		// size=4,[11, 66, 33, 44]
		
//		Assert.test(list.indexOf(44) == 33);
//		Assert.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
//		Assert.test(list.contains(33));
//		Assert.test(list.get(0) == 11);
//		Assert.test(list.get(1) == 66);
//		Assert.test(list.get(list.size() - 1) == 44);
		
		System.out.println(list);
	}

	public static void main(String[] args) {
		
		// 单向链表的实现
		System.out.println("------------单向链表的实现--------------");
		testList(new SingleLinkedList<>());
		System.out.println("------------单向链表的实现--------------");
		
		System.out.println("\n");
		
		System.out.println("------------虚拟头节点优化单向链表的实现--------------");
		// 通过虚拟头节点优化单向链表
		testList(new SingleLinkedList2<>());
		System.out.println("------------虚拟头节点优化单向链表的实现--------------");
		
		System.out.println("\n");
		
		System.out.println("------------双向链表的实现--------------");
		// 通过虚拟头节点优化单向链表
		testList(new DoubleLinkedList<>());
		System.out.println("------------双向链表的实现--------------");
		
		System.out.println("\n");
		
		System.out.println("------------单向循环链表的实现--------------");
		// 通过虚拟头节点优化单向链表
		testList(new SingleCircleLinkedList<>());
		System.out.println("------------单向循环链表的实现--------------");


	}

}
