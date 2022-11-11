/*
 * 1. 클래스
 * 	- 공통적인 데이터, 기능 모아서 관리 -> 여러 개의 클래스 간 연관 관계 이용하여 프로그램 구성 가능
 * 
 * 	1) 데이터형 클래스 : 관련된 데이터를 모아서 관리 -> 사용자 정의 데이터형
 * 	2) 액션 클래스 : 관련된 기능 모아서 관리 -> 메소드의 집합
 * 			ex. 게시판 생성 시 데이터형 클래스 : name, subject, content, id, pw..
 * 							액션 클래스 : 목록 출력, 상세보기, 글쓰기, 수정, 삭제, 검색, 
 * 									   id, pw; 캡슐화
 * 									   댓글 재사용; 상속 
 * 									   자료실 -> 글쓰기(업로드), 상세보기(다운로드); 오버라이딩 
 * 	3) 조립 클래스 : 데이터, 메소드 모아서 관리
 * 
 * 	- 클래스로 객체를 정의, 이후 객체를 생성하여 사용 -> 실제 동작하는 것은 객체(instance)
 * 			cf. 객체 : (클래스에 설계된) 여러개의 데이터와 메소드를 저장할 수 있는 메모리 공간의 이름
 * 				변수 : 하나의 데이터를 저장할 수 있는 메모리 공간의 이름
 * 				배열 : 여러개의 데이터를 저장할 수 있는 메모리 공간의 이름
 * 	-	class 클래스명{
 * 			변수 설정 : 전역변수, 멤버변수, 공유변수 -> 자동 초기화(0/null)
 * 			변수 활용 : 메소드
 * 			변수 초기화 : 생성자	}
 * 	- 클래스명 참조변수명 = new 클래스명();
 * 			-> 생성된 객체 주소가 참조변수에 저장
 * 		ex. Student를 정의, hong, lee, kang이라는 객체를 생성하여 사용
 * 	- 클래스명 : 식별자 생성 조건 적용
 * 	- 특징
 * 		- 코드 재사용성 높음, 코드 관리 용이
 * 		- 이미 사용중인 프로그램 이용해 새로운 프로그램 제작 -> 신뢰성 높은 프로그램 제작 가능
 * 		- 다형성; 포함된 메소드의 기능 변경(오버라이딩), 추가(오버로딩)
 * 		- 캡슐화; 키워드(private) 이용하여 데이터 은닉화(데이터 보호)
 * 		- 상속(is-a) : 변경해서 사용(오버라이딩)
 * 		  포함(has-a) : 있는 그대로 사용 
 * */

class Student{
	int hakbun;
	String name;
	String sex;
	int age;
	int kor, eng, math;
}
class FoodHouse{
	int fno;
	String ftitle;
	double score;
	String address, tel, type, price, time;
}
public class 클래스 {

	public static void main(String[] args) {
		Student hong=new Student(); 
					//클래스를 객체(인스턴스)로 설정하여 저장
		System.out.println("hong="+hong);
		hong.hakbun=1;
			//dot(.) : 메모리주소 접근 연산자(읽기, 쓰기(저장))
		hong.name="홍길동";
		hong.sex="남";
		hong.age=25;
		hong.kor=90;
		hong.eng=80;
		hong.math=70;
		Student lee=new Student();
		lee.hakbun=2;
		lee.name="이순신";
		Student kang=new Student();

		System.out.println("이름:"+hong.name);
		System.out.println("이름:"+lee.name);
		System.out.println("이름:"+kang.name);
								//값 지정해주기 전에는 null값으로 자동초기화된 상태
		
		
		//
		FoodHouse food1=new FoodHouse();
		food1.fno=1;
		food1.ftitle="농민백암순대";
		food1.score=4.6;

	}

}
