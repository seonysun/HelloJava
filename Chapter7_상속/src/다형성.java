/*
 * 1. 다형성
 * 				오버로딩 		  오버라이딩
 * 	---------------------------------------
 * 	상태	 	   같은 클래스내 	상속이 있는 상태
 * 	---------------------------------------
 * 	메소드 		 동일 			동일
 * 	---------------------------------------
 * 	매개변수 	갯수나 데이터형 다름 		동일
 * 	---------------------------------------
 * 	리턴형 		상관없음 			동일
 * 	---------------------------------------
 * 	접근지정어	 	상관없음 		  동일, 확대
 * 
 * 2. super
 * 	- 상위클래스의 객체
 * 		-> 생성자, 인스턴스 메소드에서 사용 가능(static 메소드 불가)
 * 	- super() : 상위클래스의 생성자
 * 					-> 생성자에서만 사용 가능(반드시 첫줄에)
 * 		- 기본생성자는 추가하지 않아도 자동으로 추가됨
 * 		- 상위클래스가 매개변수 생성자만 가질 때는 상속 시 생성자 따로 추가해줘야 함
 * */ 

class 동물{
	void eat() {
		System.out.println("먹는다");
	}
}
class 개 extends 동물{
	void eat() { //접근지정어 동일(default)
		System.out.println("개같이 먹는다");
	}
}
class 소 extends 동물{
	public void eat() { //접근지정어 확대(default->public)
		System.out.println("소같이 먹는다");
	}
}
class 돼지 extends 동물{
	@Override
	void eat() {
		//super.eat(); //자동으로 오버라이딩 추가하면 이렇게 추가됨
		System.out.println("돼지같이 먹는다");
	}
}

class Super3{ //Super3의 super : Object
	int a, b;
	public Super3(int a, int b) {
		this.a=a;
		this.b=b;
	}
	public void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}
class Sub3 extends Super3{ 
	int c;
	int a, b;
	public Sub3(int a, int b, int c) {
		super(a,b); //상위클래스가 매개변수 생성자만 가질 때 -> 상위클래스의 생성자 먼저 호출해야함
					//기본생성자는 자동메모리 할당되지만 매개변수 생성자는 불가하므로 직접 호출
					//상위클래스 참조 시 super.(상위클래스의 객체 : super)			
		this.a=100;
		this.b=200;
		this.c=c;
	}
	public void print() {
		System.out.println("super3.a="+super.a); 
		System.out.println("super3.a="+super.b);
		System.out.println("this.a="+a); //스스로 참조 시 this.(생략 가능)
		System.out.println("this.b="+b);
		System.out.println("this.c="+c);
	}
}

class A0{
	int a,b,c;
	public A0() {
		a=10;
		b=20;
		c=30;
	}
	public A0(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public A0(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
}
class B0 extends A0{
	int a,b,c;
	public B0() {
		a=100;
		b=200;
		c=300;
	}
	public B0(int a,int b,int c) {
		super(a,b); //상위클래스 호출 시 매개변수가 2개인 생성자를 호출했으므로 super.c는 default(0)
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public void print() {
		System.out.println("this.a="+this.a);
		System.out.println("this.b="+this.b);
		System.out.println("this.c="+this.c);
		System.out.println("super.a="+super.a);
		System.out.println("super.b="+super.b);
		System.out.println("super.c="+super.c);
	}
}
public class 다형성 {

	public static void main(String[] args) {
		동물 ani=new 개();
		ani.eat();
		ani=new 소();
		ani.eat();
		ani=new 돼지();
		ani.eat();
		System.out.println();

		
		//
		Sub3 sub3=new Sub3(10,20,30);
		sub3.print();
		System.out.println();
		
		
		//
		B0 d=new B0(1000,2000,3000);
		d.print();
		System.out.println();

		
		//
		Object obj=new Object();
		A0 a=new A0();
		B0 b=new B0();
		
		if(a instanceof Object) //a는 Object의 객체
			System.out.println(true);
		if(b instanceof Object) 
			System.out.println(true);
		if(b instanceof A0)
			System.out.println(true);
		if(b instanceof B0)
			System.out.println(true);
		if(a instanceof B0)
			System.out.println(true);
		else System.out.println(false);
		
	}

}
