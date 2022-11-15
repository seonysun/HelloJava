/* 
 * 0. 객체지향_재사용기법
 * 	- 상속 : 변경(오버라이딩)해서 사용
 * 	- 포함 : 그대로 사용, 내용 추가
 * 
 * 1. 상속
 * 	- 기존(부모)의 클래스 확장해서 새로운(자식) 클래스 제작
 *		-> 기능 추가, 변수 추가, 기능 변경(오버라이딩), 변수값 변경
 *		-> 소스 코딩량 적음, 공통 관리 쉬움
 * 	- class 하위클래스명 extends 상위클래스명 {	}
 * 		  //자식클래스 			//부모클래스
 * 		ex. class A {
 * 				int a, b;
 * 				void display(){}
 * 			}
 *			class B extends A {
 * 				int c;
 * 				void ddisplay() {}
 * 			}
 * 				=> A : a, b, display()
 * 				   B : c, ddisplay(), a, b, display()
 * 	- 상위 클래스가 먼저 메모리 할당 후 하위 클래스 메모리 할당 
 * 		-> 속도 저하, 사용 빈도 낮음
 * 	- 예외 : 인스턴스만 상속, 생성자/초기화블록/static은 상속에서 제외(공유)
 * 			private은 상속은 가능하나 접근 불가 -> getter/setter 메소드 필요
 * 	- 상속 횟수에는 제한 없음
 *	- 단일 상속이 기본
 * 
 * 2. Object
 * 	- 자바의 모든 클래스는 java.lang.Object 상속
 * 		-> 컴파일 시 클래스명 옆에 extends Object 자동 첨부
 * 	- Object : 최상위 클래스
 * 	1) 소멸자 finalize() 
 * 	2) 문자열반환 toString()
 * 	3) 메모리복제 clone()
 * 
 * 3. super
 * 	- 상위클래스의 객체(상속받은 객체)
 * 		-> 생성자, 인스턴스 메소드에서 사용 가능(static 메소드 불가)
 * 	- super() : 상위클래스의 생성자
 * 					-> 생성자에서만 사용 가능(반드시 첫줄에)
 * 		- 기본생성자는 추가하지 않아도 자동으로 추가됨
 * 		- 상위클래스가 매개변수 생성자만 가질 때는 상속 시 생성자 따로 추가해줘야 함
 * 
 * 4. 오버라이딩
 * 	1) 조건 
 * 		- 상속이 있어야 함
 * 		- 메소드명 동일
 * 		- 매개변수 갯수나 데이터형 동일
 * 		- 리턴형 동일 -> 오버로딩과 달리 기존의 것을 수정하는 것이므로 완전히 같아야 함
 * 		- 접근지정어 축소 불가, 확대 가능
 * 			cf. 접근지정어는 보통 public/private 사용
 * 				-> 라이브러리에서 가끔 protected
 * */

class Super{
	int a=10;
	int b=20;
	static int c=30;
	public Super() {
		System.out.println("Super() Call..");
	}
	public void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
	}
}
class Sub extends Super{
	public Sub() {
		a=100; //상속받은 자식클래스의 메모리는 부모클래스와 별개 -> 변수 각각 관리됨
		b=200;
		c=300;
		System.out.println("Sub() Call..");
	}
}

class Board1{
	public void list() {	}
	public void insert() {	}
	public void update() {	}
	public void detail() {	}
	public void find() {	}
}
class ReplyBoard1 extends Board1{
	public void reply() {	} //새롭게 추가할 기능만 작성
}
class GalleryBoard1 extends Board1{
	public void detail() {	} //기존 기능 수정할 부분만 작성 -> 오버라이딩
}
class DataBoard1 extends Board1{
	public void insert() {	}
	public void detail() {	}
}
public class 상속 {

	public static void main(String[] args) {
		Sub sub=new Sub(); //객체 생성 시 생성자는 자동으로 실행 -> 부모클래스 실행 후 자식클래스 실행
		sub.print();
		Super sup=new Super();
		sup.print();

	}

}
