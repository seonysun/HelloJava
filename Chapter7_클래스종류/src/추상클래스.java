/*
 * 0. 클래스
 * 	- 클래스의 소멸 : 객체명=null; -> 주소값 지워짐
 * 	1) 클래스의 설계
 * 		- 사용자 정의 데이터형 : 관련된 데이터만 모아서 저장 -> 데이터타입형(캡슐화) 
 * 			ex. ~VO, ~DTO, ~Bean
 * 		- 기능 : 관련된 메소드만 모아서 저장 
 * 			ex. ~DAO(Data Access Object), ~Manager(데이터수집), ~Service, ~Controller, ~Model
 * 
 * 	2) 클래스의 종류
 * 		- 일반 클래스(*)
 * 			[접근지정어] class 클래스명{}
 * 		- 추상 클래스
 * 			[접근지정어] abstract class 클래스명{}
 * 		- 인터페이스(*)
 * 
 * 1. 인터페이스
 * 	- 추상 클래스의 일종 -> 추상 클래스의 단점을 보완(다중 상속)
 *    인터페이스의 장점 
 *   = 기능이 설정 (설계) : 개발 기간을 단축할 수 있다 
 *   = 모든 개발자 같은 메소드를 이용해서 구현 (표준화) => 라이브러리 (모든 개발자가 같은 형식으로 코딩)
 *                                                      ------------------------ 스프링(프레임워크)
 *   = 서로 관계없는 클래스를 연결해서 사용이 가능하게 만든다 
 *   = 독립적으로 사용이 가능 
 *   = 다중 상속이 가능하기 때문에 소스 코딩이 간결해 진다 
 *   = 단점은 인터페이스 메소드 선언을 추가하면 => 연결되어 있는 모든 클래스가 에러 발생 => default
 *   
 * 		- 내부 클래스 : 멤버클래스, 익명의 클래스(*), 지역클래스
 * 		- 종단 클래스
 * 
 * 1. 추상클래스
 * 	- 미완성 -> 인스턴스에서 완성
 * 	- [접근지정어] abstract class 클래스명{
 * 			변수
 * 			메소드(구현되지 않음, 선언 only)
 * 	  }
 * */

abstract class 도형{
	public abstract void draw(); //추상메소드 : 선언만, 구현부 없음 -> 상속 후 구현
	public void selectColor(String color) { 
		//클래스 상속 후 메소드 추가할 때 추상메소드로 설정하면 자손클래스 모두 오류남 -> 구현 메소드로 설정
		System.out.println("선택 색상: "+color);
	}
}
class 사각형 extends 도형{
	public void draw() { //자손클래스에서 구현 시에는 abstract 제외
		System.out.println("사각형을 그린다.");
	}
}
class 원형 extends 도형{
	public void draw() {
		System.out.println("원형을 그린다.");
	}
}
class 삼각형 extends 도형{
	public void draw() {
		System.out.println("삼각형을 그린다.");
	}
}

abstract class Board{
	public abstract void boardList(); //추상메소드는 자손클래스에서 반드시 구현되어야 함 -> 필수로 포함되는 기본 기능
	public abstract void boardInsert();
	public abstract void boardDetail();
	public abstract void boardUpdate();
	public abstract void boardDelete();
	public abstract void boardFind();	
	public void login() { //선택적으로 사용되는 메소드 -> 선택 기능
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
		graph.draw();
		graph.selectColor("노랑");
		graph=new 원형();
		graph.draw();
		graph=new 삼각형();
		graph.draw();

	}

}
