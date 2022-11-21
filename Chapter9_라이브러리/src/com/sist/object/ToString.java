package com.sist.object;

class Person{
	private String name;
	private String sex;
	private int age;
	public Person(String name, String sex, int age){
		this.name=name;
		this.sex=sex;
		this.age=age;
	}
	@Override
	public String toString() {
		return "이름:"+name+", 성별:"+sex+", 나이:"+age;
	}
}
public class ToString {
	
	public static void main(String[] args) {
		Person p=new Person("홍길동","남자",30);
		System.out.println(p);
						//toString() 호출하지 않아도 자동으로 호출됨 
	    System.out.println(p.toString());

	}

}

