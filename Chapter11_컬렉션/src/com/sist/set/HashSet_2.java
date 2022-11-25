package com.sist.set;
import java.util.*;

class Student{
	String name;
	int age;
	public Student(String name,int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student s=(Student)obj;
			return name.equals(s.name) && age==s.age;
		}
		return false;
	}
	@Override
	public String toString() {
		return name+":"+age;
	}
	@Override
	public int hashCode() { //객체에 저장된 값을 비교
		return (name+age).hashCode();
	}
}
public class HashSet_2 {

	public static void main(String[] args) {
		Set set=new HashSet();
		set.add(new Student("홍길동",30));
		set.add(new Student("홍길동",30));
		System.out.println(set);
		
	}

}
