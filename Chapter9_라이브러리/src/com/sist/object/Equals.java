package com.sist.object;

class Member{
	private String name;
	public Member(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Student{
	private String name;
	public Student(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student)
			return name==((Student)obj).name;
							//괄호를 치지 않으면 dot(.)이 우선 순위
		else return false;
	}
}
public class Equals {

	public static void main(String[] args) {
		Member m1=new Member("홍길동");
		Member m2=new Member("홍길동");
		System.out.println("m1:"+m1);
		System.out.println("m2:"+m2);
		
		if(m1.equals(m2)) //Object 상속 equals -> 주소비교
			System.out.println("같은 회원입니다.");
		else
			System.out.println("다른 회원입니다.");
		
		m2=m1;
		if(m1.equals(m2))
			System.out.println("같은 회원입니다.");
		else
			System.out.println("다른 회원입니다.");

		
		//
		Student s1=new Student("홍길동");
		Student s2=new Student("홍길동");
		
		if(s1.equals(s2))
			System.out.println("같은 학생입니다.");
		else System.out.println("다른 학생입니다.");

	}

}
