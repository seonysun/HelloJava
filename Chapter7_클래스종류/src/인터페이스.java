/*
 * 2. 인터페이스
 * 	- 추상 클래스 보완(다중 상속)
 * 	- interface 인터페이스명{ 
 * 			public static final 상수명=값;
 * 			public abstract 메소드명(매개변수){} 
 * 	  }
 * 	- 상속 : interface 자손인터페이스명 extends 조상인터페이스명{}
 * 	  구현 : class 클래스명 implements 인터페이스명{}
 * 
 * 	1) 조건 
 * 		- 모든 멤버변수 : 상수 -> public static final 생략 가능
 * 			cf. final int a=10; 상수형 변수
 * 				static final int b=10; 상수
 * 		- 모든 메소드 : 추상메소드 -> public abstract 생략 가능
 * 								//클래스에서 구현(오버라이딩) 시에는 public 필수(접근제어자 축소 불가) 
 * 			cf. jdk1.8부터 static, default 메소드(구현메소드) 추가 가능
 * 
 * 	2) 장점
 * 		- 다중 상속
 * 		- 프로그램 제작 시 기본틀 형성 -> 표준화 -> 라이브러리
 * 		- 관계 없는(상속관계 아님, 공통조상 없음) 클래스 서로 연결해서 사용 가능
 *   		=> 다형성 : 메소드 리턴형으로 인터페이스 -> 구현클래스의 인스턴스 반환
 *   					-> 인스턴스 직접 생성하지 않고 메소드로 생성
 *   					-> 내용 변경 시에 수정 적음
 * 		- 독립적인 프로그래밍(결합성 낮은 프로그램) 
 * 			-> 클래스간 직접적인 관계 대신 인터페이스 구현 통한 간접적인 관계로 설정
 * 			-> 클래스 수정 시 다른 클래스에 영향 적음
 * 				ex. A -> B => A -> I(B)
 * 					B의 메소드 변경 시 A는 간접 관계이므로 영향 없음ㄴ
 */

interface I{
	public abstract void play();
}
class B implements I{
	public void play() {
		
	}
}
class C implements I{
	public void play() {
		
	}
}
class A {
	void display(I i) {
				//I의 구현 클래스인 B나 C의 객체 사용
		i.play();
	}
}
public class 인터페이스 {
	public static void main(String[] args) {
		A a=new A();
		a.display(new B());
		a.display(new C());
		
	}
	
}
