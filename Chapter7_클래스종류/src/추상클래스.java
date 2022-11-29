/*
 * 0. 클래스(컴포넌트)
 * 	1) 클래스의 설계
 * 		- 사용자 정의 데이터형 : 관련된 데이터만 모아서 저장 -> 데이터타입형(캡슐화) 
 * 			ex. ~VO, ~DTO, ~Bean
 * 		- 기능 : 관련된 메소드만 모아서 저장 
 * 			ex. ~DAO(Data Access Object), ~Manager(데이터수집), ~Service, ~Controller, ~Model
 * 		cf. 클래스의 소멸 : 객체명=null; -> 주소값 지워짐
 * 
 * 	2) 클래스의 종류
 * 		- 일반 클래스(*)
 * 			[접근지정어] class 클래스명{}
 * 		- 추상 클래스
 * 			[접근지정어] abstract class 클래스명{}
 * 		- 인터페이스(*)
 * 			interface 인터페이스명{}
 * 		- 종단 클래스
 * 			[접근지정어] final class 클래스명{}
 * 		- 내부 클래스 : 멤버클래스, 익명의 클래스(*), 지역클래스
 * 
 *	3) 메모리 할당
 * 		class Human{}
 * 		-> (1) Human h1=new Human(); //직접 연결(결합성 높은 프로그램)
 *         (2) Human h2=new Human().getClass().getDeclearedContstructor().newInstance();
 * 		   (3) Human h3=Human.newInstance();
 *         (4) Human h4=Human.class.getDeclearedContstructor().newInstance();
 * 		   (5) Human h5=Class.forName().getInstance();
 *      (*)(6) Human h6=(Human)Class.forName("Human"); //변수/메소드 제어(리플렉션)
 * 
 * 1. 추상클래스
 * 	- [접근지정어] abstract class 클래스명{
 * 			변수
 * 			추상메소드(구현되지 않음, 선언 only) //미완성 -> 인스턴스에서 완성
 * 	  }
 * 	- 메모리 할당 불가 -> 오버라이딩하여 메소드 구현된 하위클래스 이용
 * 	- 하위클래스들의 공통된 기능 추상메소드에 정의
 * 		-> 하위클래스 각각에서 개별적으로 구현 필수
 * 		-> 일반메소드로 오버라이딩하는 것과 동일하나, 각 클래스별로 다르게 구현하고자 함을 강조할 때 사용
 * 											ex. 버튼, 마우스, 키보드, DB의 모든 클래스
 * 	- 구현된 메소드도 지님 
 * 		-> 클래스 상속 후 공통 메소드 추가할 때는 구현메소드로 설정
 * 		  (추상메소드 설정 시 자손클래스에서 모두 구현해야 하므로 오류 발생)
 * */

abstract class 도형{
	public abstract void draw();
	public void selectColor(String color) { 
		System.out.println("선택 색상: "+color);
	}
}
class 사각형 extends 도형{
	public void draw() { //자손클래스에서 구현 시에는 abstract 제외
		System.out.println("사각형을 그린다");
	}
}
class 원형 extends 도형{
	public void draw() {
		System.out.println("원형을 그린다");
	}
}
class 삼각형 extends 도형{
	public void draw() {
		System.out.println("삼각형을 그린다");
	}
}

abstract class Board{
	public abstract void boardList(); //반드시 구현되어야 하는 추상메소드 -> 필수 기본 기능
	public abstract void boardInsert();
	public abstract void boardDetail();
	public abstract void boardUpdate();
	public abstract void boardDelete();
	public abstract void boardFind();	
	public void login() { //선택적으로 사용되는 구현메소드 -> 선택 기능
	}
}
class 묻고답하기 extends Board{
	@Override
	public void boardList() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void boardInsert() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void boardDetail() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void boardUpdate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void boardDelete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void boardFind() {
		// TODO Auto-generated method stub
		
	}
}
public class 추상클래스 {

	public static void main(String[] args) {
		도형 graph=new 사각형(); //추상클래스는 구현되지 않았으므로 생성자 호출 불가
		graph.selectColor("노랑");
		graph.draw();
		graph=new 원형(); //다형성
		graph.draw();
		graph=new 삼각형();
		graph.draw();

	}

}
