package com.joshua;

import com.joshua.circle.CircleDeque;
import com.joshua.circle.CircleQueue;

public class Main {
	
	static void test1() {
		// 基于链表实现单向队列
//		Queue<Integer> queue = new Queue<>();
//		queue.enQueue(11);
//		queue.enQueue(22);
//		queue.enQueue(33);
//		queue.enQueue(44);
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}
		
		// 双端队列
		Deque<Integer> queue = new Deque<>();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		
		// 尾44 33 11 22头
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
		System.out.println("牛逼了啊");
	}

	public static void main(String[] args) {
		// 队列和双端队列
		// test1();
		
		// 循环队列
		// test2();
		
		// 循环双端队列
		test3();

	}
	
	/**
	 * 循环单向队列
	 */
	static void test2() {
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		
		// null, null, null, null, null, 5, 6, 7, 8, 9
		for (int i = 0; i < 5; i++) {
			queue.deQuque();
		}
		System.out.println(queue);
		
		// 15, 16, 17, 18, 19, 5, 6, 7, 8, 9
		for (int i = 15; i < 20; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQuque());
		}
		
	}
	
	/**
	 * 循环双端队列
	 */
	static void test3() {
		CircleDeque<Integer> queue = new CircleDeque<>();
		// 头5 4 3 2 1 100 101 102 103 104 105 106 8 7 6尾 
		// 再次扩容后
		// 头 8, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, null, null, 10, 9
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i+1);
			queue.enQueueRear(100+i);
		}
		System.out.println(queue);
		
		// null, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, null
		for (int i = 0; i < 3; i++) {
			queue.deQuqueFront();
			queue.deQueueRear();
		}
		System.out.println(queue);
		
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		// 11, 7, 6, 5, 4, 3, 2, 1, 100, 101, 102, 103, 104, 105, 106, null, null, null, null, null, null, 12
		System.out.println(queue);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQuqueFront());
		}
	}
	
	

}
