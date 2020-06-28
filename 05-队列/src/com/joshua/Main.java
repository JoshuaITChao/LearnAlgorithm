package com.joshua;

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
		// 队列
		test1();

	}

}
