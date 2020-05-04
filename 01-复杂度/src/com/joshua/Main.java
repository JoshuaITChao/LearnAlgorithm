package com.joshua;


import com.joshua.TimeTool.Task;

public class Main {
	
	public static void main(String[] args) {
		
		int n = 46;
		
		TimeTool.check("fib1", new Task() {
			public void execute() {
				System.out.println(fib1(n));
			}
		});
		
		TimeTool.check("fib2", new Task() {
			public void execute() {
				System.out.println(fib2(n));
			}
		});
		
		TimeTool.check("fib3", new Task() {
			public void execute() {
				System.out.println(fib3(n));
			}
		});
	}
	
	/**
	 * 斐波那且数列
	 * 0 1 1 2 3 5 8 13 ...
	 * 复杂度：O(n^2)
	 */
	public static int fib1(int n) {
		if(n <= 1) return n;
		return fib1(n-1) + fib1(n-2);
	}
	
	/**
	 * 斐波那且数列
	 * 0 1 1 2 3 5 8 13 ...
	 * 复杂度：O(n)
	 */
	public static int fib2(int n) {
		if(n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n-1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	/**
	 * 斐波那且数列(优化版)
	 * 0 1 1 2 3 5 8 13 ...
	 * 复杂度：O(n)
	 */
	public static int fib3(int n) {
		if(n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n-1; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
	
	// O(1)
	public static void test1(int n) {
		// 汇编指令
		
		// 1
		if(n > 10) {
			System.out.println("n>10");
		}else if (n>5) {
			System.out.println("n>5");
		}else {
			System.out.println("n<=5");
		}
		
		// 1 + 4 + 4 + 4
		for (int i = 0; i < 4; i++) {
			System.out.println("test");
		}
	}
	
	// 1 + 3n
	// 1 + n + n + n 
	// O(n)
	public static void test2(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("test");
		}
	}
	
	// 1 + 2n + n *(1+3n)
	// 1 + 2n + n + 3n^2
	// 3*n^2 + 3n + 1
	// O(n^2)
	public static void test3(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("test");
			}
		}
	}
	
	
	// 1 + 2n + n*(1 + 15 + 15 +15)
	// 1 + 48n
	// O(n)
	public static void test4(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.println("test");
			}
		}
	}
	
	// 8  = 2 ^ 3
	// 16 = 2 ^ 4
	// 3 = log2(8)
	// 4 = log2(16)
	// 执行次数为：log2(n)
	// O(log(n))
	public static void test5(int n) {
		while (( n = n / 2) > 0) {
			System.out.println("test");
		}
	}
	
	// log5(n)
	// O(log(n))
	public static void test6(int n) {
		while ((n = n / 5) > 0) {
			System.out.println("test");
			
		}
	}
	
	// O(n*log(n))
	public static void test7(int n) {
		// 1 + 2*log2(n) + log2(n)*(1+3n)
		// 1 + 3*log2(n) + 3n*log2(n)
		for (int i = 0; i < n; i = i * 2) {
			// 1 + 3n
			for (int j = 0; j < n; j++) {
				
			}
		}
	}
	
	// O(n)
	public static void test10(int n) {
		int a = 10;
		int b = 20;
		int c = a + b;
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + c);
		}
	}

}
