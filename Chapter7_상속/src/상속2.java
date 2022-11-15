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
		//자손클래스의 변수를 새로 정의하지 않으면 자손 객체=상속받은 객체 -> this.a=상속받은 a=super.a
		//	-> this.와 super.의 멤버변수 구분 불가
	public Sub3(int a, int b, int c) {
		super(a,b); //상위클래스가 매개변수 생성자만 가질 때 -> 상위클래스의 생성자 먼저 호출해야함
					//기본생성자는 자동메모리 할당되지만 매개변수 생성자는 불가하므로 직접 호출
					//상위클래스(상속받은 객체) 참조 시 super.(상위클래스의 객체 : super)			
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
public class 상속2 {

	public static void main(String[] args) {
		Sub3 sub3=new Sub3(10,20,30);
		sub3.print();
		System.out.println();
		
		
		//
		B0 d=new B0(1000,2000,3000);
		d.print();
		System.out.println();

	}

}
