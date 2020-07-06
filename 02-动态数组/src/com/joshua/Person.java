package com.joshua;

public class Person {
	private int age;
	private String name;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [age="+ age +", name="+ name +"]";
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		
		System.out.println("Person-finalize");
	}
}
