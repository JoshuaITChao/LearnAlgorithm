package com.joshua;

public class Main {

	public static void main(String[] args) {
		
		test();
		
//		ArrayList<Object> persons = new ArrayList<>();
//		persons.add(new Person("zs", 10));
//		persons.add(null);
//		persons.add(new Person("ls", 11));
//		persons.add(null);
//		persons.add(new Person("ww", 12));
//		persons.add(null);
//		
//		System.out.println(persons);
//		System.out.println(persons.indexOf(null));

	}
	
	static void test() {
		// int -> Integer
		// 所有的类都最终继承自 java.lang.Object
		
		// new 是向堆申请内存
		ArrayList<Person> persons  = new ArrayList<>();
		persons.add(new Person("Jack", 10));
		persons.add(new Person("James", 12));
		persons.add(new Person("Rose", 15));
		persons.clear();
		// 题型JVM垃圾回收
		System.gc();
		persons.add(new Person("abc", 22));
		
		System.out.println(persons);
		ArrayList<Integer> ints  = new ArrayList<>();
		ints.add(10);
		ints.add(10);
		ints.add(22);
		ints.add(33);
		System.out.println(ints);
	}

}
