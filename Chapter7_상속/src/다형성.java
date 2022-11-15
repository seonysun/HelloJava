/*
 * 1. 다형성
 * 	- 여러 가지 형태를 가질 수 있는 능력
 * 	- 오버로딩 : 기존에 없는 새로운 메소드 정의(new)
 * 	- 오버라이딩 : 상속받은 메소드의 내용을 변경(modify)
 * 
 *	 				오버로딩 		  오버라이딩
 * 		---------------------------------------
 * 		상태	 	   같은 클래스내 	상속이 있는 상태
 * 		---------------------------------------
 * 		메소드 		 동일 			동일
 * 		---------------------------------------
 * 		매개변수 	갯수나 데이터형 다름 		동일
 * 		---------------------------------------
 * 		리턴형 		상관없음 			동일
 * 		---------------------------------------
 * 		접근지정어	 	상관없음 		  동일, 확대
 *
 * 	- 한 타입의 참조변수로 여러 타입의 인스턴스 참조 가능
 * 		: 변수는 참조변수 타입, 메소드는 객체(생성자) 타입으로 설정됨
 * 				//메모리 할당 클래스명 //생성자 만드는 클래스명
 * 		-> 인스턴스 타입이 같더라도 참조변수 타입에 따라 사용할 수 있는 멤버의 개수가 달라짐
 * 	 1) 하위클래스 클래스명 = new 하위클래스(); 
 * 			-> 기본
 * 	    상위클래스 클래스명 = new 상위클래스(); 
 * 			-> 거의 사용하지 않음, 상속받은 하위클래스 주로 사용
 * 
 *   2) 상위클래스 클래스명 = new 하위클래스(); 
 * 			-> 상위 객체, 하위 생성자(상위 변수, 하위 메소드)
 * 			-> 인터페이스, 추상클래스, 스프링 DB
 * 
 * 	 3) 상위클래스 클래스명1 = new 하위클래스();
 * 		하위클래스 클래스명2 = (하위클래스)클래스명1(); 
 * 			-> 하위 객체, 상위 생성자(하위 변수, 상위 메소드)는 형변환 오류 발생, 형변환하여 사용
 * 				(참조변수의 멤버(변수) 갯수는 인스턴스의 멤버(생성자, 메소드) 갯수보다 같거나 많아야 함)
 * 			-> 생성자는 형변환 X, 일치하도록 설정해야 하므로 하위클래스 생성자로 new 만든 뒤 참조변수만 형변환
 * 			-> 라이브러리 클래스
 * 	
 * 2. 참조변수 형변환
 * 	- 상속, 포함 관계의 클래스 간에서만 참조변수 형변환 가능
 * 		- 데이터형 : 상위클래스 > 하위클래스 -> 공통내용이 더 많은 상위클래스가 더 큼(분화 전)
 * 					cf. float(4byte) > long(8byte) -> 수 표현 경우의 수가 더 많은 float이 더 큼
 * 	  	- 메모리크기 : 상위클래스 < 하위클래스
 * 					cf. 상속 없는 상태의 모든 클래스 메모리 : 4byte로 동일
 * 	- 자동형변환 : 자손타입 -> 조상타입(UpCasting)
 * 	  강제형변환 : 조상타입 -> 자손타입(DownCasting)
 * 	- 목적 : 참조변수 타입 변환 -> 참조된 인스턴스에서 사용할 수 있는 멤버의 개수 조절
 * 	- 특징
 * 		- 형변환은 참조변수만 해당, 생성자는 변환되지 않음
 * 			ex. 인스턴스가 자식타입일 때 - 참조변수 자식타입 -> 부모타입 : 메소드 접근 불가
 * 								   	  	   부모타입 -> 자식타입 : 메소드 접근 가능
 * 				인스턴스가	부모타입일 때 - 참조변수 자식타입 -> 부모타입 : 메소드 접근 가능
 * 								   	  	   부모타입 -> 자식타입 : 실행 에러(형변환 오류)
 * 		- ex.의 4번째 경우에서 컴파일 시에는 참조변수 타입만 체크되므로 오류가 없지만 실행 시에는 에러 발생
 * 			-> instanceof로 형변환 가능 여부 파악 후 사용
 * 			   (참조변수가 참조하고 있는 실제 인스턴스 타입 확인)
 * 			-> 참조변수명 instanceof 클래스명
 * 			-> boolean 도출
 * 		- 형변환 사용 시 가급적이면 new 사용하지 않음
 * 			-> new : 결합성이 높은 프로그램(다른 프로그램에 영향 높은 경우)
 * */ 

class Super2{
	int a=1;
	int b=2;
	public void display() {
		System.out.println("Super2:display() Call..");
	}
}
class Sub2 extends Super2{
	int c=3;
	public void display() {
		System.out.println("Sub2:display() Call..");
	}
}

class A{
	int a=10;
	public void display() {
		System.out.println("A:display Call..");
	}
}
class B extends A{
	int a=100;
	public void display() {
		System.out.println("B:display Call..");
	}
}

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
		//super.eat(); //자동으로 오버라이딩 추가하면 포함의 형태로 추가됨
					   // -> 아예 이전 내용을 없애고 변경하는 것이 아니라 옵션을 추가하는 등의 변경이라면 이 뒤에 추가하면 됨
		System.out.println("돼지같이 먹는다");
	}
}
public class 다형성 {

	public static void main(String[] args) {
		Sub2 sub=new Sub2(); //하위 변수, 하위 메소드
		System.out.println("sub.a="+sub.a);
		System.out.println("sub.b="+sub.b);
		System.out.println("sub.c="+sub.c);
		sub.display();
		
		Super2 sup=new Sub2(); //상위 변수, 하위 메소드
		System.out.println("sup.a="+sup.a);
		System.out.println("sup.b="+sup.b);
		//System.out.println("sup.c="+sup.c); //하위클래스의 변수에는 접근 불가
		sup.display();
		
		//Sub2 sub2=new Super2(); //하위 변수, 상위 메소드 -> 형변환 오류
		//Sub2 sub2=(Sub2)new Super2(); //형변환 시에는 생성자가 같아야함 -> 실행 시 오류
		Super2 sup2=new Sub2(); 
		Sub2 sub2=(Sub2)sup2;
		System.out.println("sub2.a="+sub2.a);
		System.out.println("sub2.b="+sub2.b);
		System.out.println("sub2.c="+sub2.c);
		sub2.display();
		System.out.println();
		
		
		//
		B b=new B();
		System.out.println(b.a);
		b.display();
		
		A c=new B();
		System.out.println(c.a);
		c.display();
		
		B d=(B)c;
		System.out.println(d.a);
		d.display();

		
		//
		동물 ani=new 개();
		ani.eat();
		ani=new 소();
		ani.eat();
		ani=new 돼지();
		ani.eat();
		System.out.println();

		
		//
		Object obj=new Object();
		A a1=new A();
		B b1=new B();
		
		if(a1 instanceof Object) //a1은 Object의 객체, a1을 Object 타입으로 형변환 가능
			System.out.println(true);
		if(b1 instanceof Object) 
			System.out.println(true);
		if(b1 instanceof A)
			System.out.println(true);
		if(b1 instanceof B)
			System.out.println(true);
		if(a1 instanceof B)
			System.out.println(true);
		else System.out.println(false);
		
	}

}
