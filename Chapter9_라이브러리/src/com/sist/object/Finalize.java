package com.sist.object;

//소멸자
class Main{
	private int a=10;
	public Main(int a) {
		this.a=a;
		System.out.println("Main 클래스 메모리 할당(객체 생성)");
	}
	public void display() {
		System.out.println("Main 클래스 객체 활용");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("객체 소멸");
	}
}
public class Finalize {

	public static void main(String[] args) {
		Main m=new Main(10);
		m.display();
		m=null; //객체 메모리 해제 명령
		System.gc();
		
	}

}
