/*
 * 1. 변수의 종류
 * 	1) 지역변수 : 메소드, 생성자, 초기화 블록 내에서 선언된 변수, 메소드 호출이 종료되면 자동으로 사라지는 변수
 * 		- 지역변수 : 메소드 내에서 선언, 사용
 * 		- 매개변수 : 메소드 호출시마다 생성, 메소드에서 사용자 요청값을 받을 때 사용
 * 
 * 	2) 멤버변수 : 클래스 영역에 선언된 변수, 프로그램 종료시까지 유지되는 변수
 *		- 클래스변수(공유변수) : 모든 객체가 사용할 수 있는 변수; static
 *								   -> 클래스명.변수(Math.~, String.~) / 객체명.변수
 *						   메모리 공간이 1개이므로 모든 데이터값이 동일 -> 공유할 때 사용
 *							ex. 메뉴, 로고, 사이트명
 *		- 인스턴스변수(멤버변수) : 객체마다 다르게 가지는 변수
 *					 -> 객체명.변수
 *			ex. class Student{
 *					String name; -> s1.name, s2.name : 학생명
 *					static String sName; -> Student.sName : 학교명
 *				}
 *			cf. static변수(클래스변수)는 범위에 따라 static 여부가 달라지므로 사용 빈도는 적음
 *					ex. Student라는 클래스 내에서는 static이지만 그보다 더 큰 범위가 있다면 static이 아님
 *
 * 2. 가변 매개변수
 * 	- 데이터형 여러개 : Object
 * 	  갯수 여러개 : ...
 * */

class Card{
	int number;
	String image;
	static int width, heigth;
}
public class 변수종류 {
	//가변매개변수
	/*
	void names(String n1) {
		System.out.println(n1);
	}
	void names(String n1, String n2) {
		System.out.println(n1+" "+n2);
	}
	void names(String n1, String n2, String n3) {
		System.out.println(n1+" "+n2+" "+n3);
	}
	void names(String n1, String n2, String n3, String n4) {
		System.out.println(n1+" "+n2+" "+n3+" "+n4);
	}
	void names(String n1, String n2, String n3, String n4, String n5) {
		System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5);
	}
	*/
	void names(String...name) {
		for(String s:name) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Card card1=new Card();
		card1.number=2;
		card1.image="♠";
		Card.width=100;
		card1.heigth=180; 
			//클래스변수 호출 시에는 클래스명, 객체명 모두 사용 가능 -> 클래스명 사용 추천
		Card card2=new Card();
		card2.number=5;
		card2.image="♣";
		Card card3=new Card();
		card3.number=7;
		card3.image="♥";
		Card card4=new Card();
		card4.number=9;
		card4.image="◆";

		System.out.println(Card.width);
		System.out.println(card2.width);
		System.out.println(card3.heigth);
		
		
		//
		변수종류 m=new 변수종류();
		m.names("홍길동");
		m.names("홍길동","박문수");
		m.names("홍길동","박문수","이순신");
		m.names("홍길동","박문수","이순신","강감찬");
		m.names("홍길동","박문수","이순신","강감찬","김두한");

	}

}
