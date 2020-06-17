package com.joshua;

public class Main {

	public static void main(String[] args) {
		// 基于链表实现
		Queue<Integer> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}

	}

}
