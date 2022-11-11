import java.util.Scanner;

/*
 * 0. 클래스 설계
 * 	1) 메소드 설정 : 저장된 데이터 활용(기능 설정) -> 인스턴스/static 메소드
 * 	2) 변수 설정 : 데이터 저장 공간 생성 -> 인스턴스/static 변수
 * 	3) 변수 초기화 : 변수값 주입 -> 생성자(인스턴스), 초기화 블록(static)
 * 
 * 1. 생성자
 * 	- 클래스명(매개변수) { 수행할 코드(인스턴스변수 초기화 코드) }
 *	- 객체 생성 시 '클래스명 객체명 = new 클래스명();'에서 new 뒤의 클래스명()이 생성자
 * 	1) 역할 
 * 		- 인스턴스변수 초기화 담당 메소드 : new로 생성된 메모리(인스턴스 heap)에 값 채워주는 역할
 * 		- 클래스 영역에서는 선언, 명시적 초기화만 가능, 구현 불가 -> 생성자 통해 진행
 * 			cf. 선언 : 변수 선언, 메소드 선언
 * 				구현 : 데이터 변경(초기화), 외부/파일에서 데이터읽기, 메소드 호출, 제어문 사용, 연산자 사용
 * 						-> abstract void a(); //메소드 선언
 * 						   void a() { } //메소드 구현
 * 		- 객체 생성 시 첫번째로 호출되는 메소드
 * 			-> 시작과 동시에 처리하는 내용 있을 때 설정
 * 				ex. 외부에서 데이터 읽기(날씨 읽기, 뉴스)
 * 			   	    파일에서 데이터 읽기
 * 				    쿠키값 읽기(자동로그인)
 * 				    서버연결, 오라클 연결, 윈도우 레이아웃, 데이터베이스 드라이브
 * 
 * 	2) 특징
 * 		- 클래스명과 동일하게 설정
 * 		- 리턴값이 없음
 * 		- 필요시에만 만들어서 사용 -> 생성자 생략 가능(컴파일러가 자동 첨부)
 * 							-> 매개변수가 있는 생성자가 1개 이상 존재하면 기본생성자 자동 추가되지 않음
 * 		- 오버로딩을 지원 -> 하나의 클래스에 여러 개 생성 가능
 * 		- 생성자에서 다른 생성자 호출 가능 : this(매개변수) -> 반드시 가장 첫 줄에 작성
 * 
 * 	3) 종류
 * 		- 기본생성자(디폴트 생성자) : 매개변수가 없는 생성자
 * 								  -> 생성자를 만들지 않는 경우 자동으로 생성
 * 							   웹에서 주로 사용
 * 		- 매개변수가 있는 생성자 : 사용자로부터 입력값 받아서 초기화 하는 경우
 * 								-> random()은 입력값을 받는 것이 아니라 자동 생성이므로 기본생성자에 해당
 * 							 웹에서 사용 빈도 거의 없음
 * 
 * 2. this : 객체 자신을 가리키는 참조변수(객체 생성 시 객체의 주소값 저장)
 * 		- new로 동적메모리 할당 시 자동으로 생성됨
 * 		- static -> 객체 생성시마다 계속해서 변경
 * 		- 멤버메소드(인스턴스변수, 인스턴스메소드), 생성자 내에서만 사용 가능 
 * 			-> 클래스메소드(static)에서는 사용 불가
 * 			   (객체 생성하지 않고 공통으로 사용하므로 this 불가)
 * 		- 지역변수와 멤버변수(인스턴스변수) 구분 시에 주로 사용
 * 		- 지역변수와 멤버변수가 충돌할 때(변수명 같을 때) 우선순위 : 지역변수 > 멤버변수 
 * 			-> this.로 멤버변수 호출 
 * */

class Student{
	String name;
	int kor, eng, math;
	Student(String name, int kor, int eng, int math){
		this.name=name;
			//변수가 충돌되지 않을 때는 this. 생략이 가능하지만 이름이 다르면 헷갈리므로 통일하는 것이 좋음
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	void print() {
		System.out.println("이름:"+name);
								//class 소속 메소드이므로 인스턴스 변수 가져옴
								//지역변수가 없으므로 this. 생략 가능
		System.out.println("국어:"+kor+", 영어:"+eng+", 수학:"+math);
		System.out.println("총점:"+(kor+eng+math));
		System.out.printf("평균:%.2f%n",(kor+eng+math)/3.0);
		System.out.println();
	}
}
class Sawon{
	int sabun;
	String name, dept, loc;
				//부서명, 근무지
	long pay;
	Sawon(){
		sabun=1;
		name="홍길동";
		dept="개발부";
		loc="서울";
		pay=5000;
	}
	Sawon(int sabun, String name){
		this();
			//this() 호출하지 않으면 입력되지 않은 값은 자동 초기화된 default(null/0)값
			//this() 호출했으므로 기본생성자에서 초기화된 값 불러옴
		this.sabun=sabun;
		this.name=name;
	}
	Sawon(String dept, String loc, long pay){
		//this(sabun, name); 해당 생성자에서 정의된 매개변수 sabun, name이 없으므로 해당 생성자는 호출 불가
		this.dept=dept;
		this.loc=loc;
		this.pay=pay;
	}
	Sawon(int sabun, String name, String dept, String loc, long pay){
		this(sabun, name);
		this.sabun=sabun;
		this.name=name;
		this.dept=dept;
		this.loc=loc;
		this.pay=pay;
	}
	void print() {
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
		System.out.println("근무지:"+loc);
		System.out.println("연봉:"+pay);
		System.out.println();
	}
}
public class 생성자 {
	int a=10; //멤버변수(인스턴스)
	생성자(){
		int a=20; //지역변수
			//멤버변수는 heap, 지역변수는 stack에 저장되므로 변수명 같아도 됨
		System.out.println(a+","+this.a);
								//멤버변수 호출
		System.out.println("this 주소:"+this);
	}
	public static void main(String[] args) {
		생성자 a=new 생성자();
		System.out.println("객체 a 주소:"+a); //객체 a가 생성될 때 this가 생성되어 a의 주소 저장 -> this=a(동일 주소)
		System.out.println("객체 a 인스턴스변수 a="+a.a);

		new 생성자(); //새로운 객체 생성 -> this값 달라짐
			//생성자 자체만 호출하려면 앞에 꼭 new 붙여야 함
		System.out.println();
		
		
		//
		Scanner scan=new Scanner(System.in);
		System.out.print("이름 입력:");
		String name=scan.next();
		System.out.print("국어 입력:");
		int kor=scan.nextInt();
		System.out.print("영어 입력:");
		int eng=scan.nextInt();
		System.out.print("수학 입력:");
		int math=scan.nextInt();
		
		Student hong=new Student(name, kor, eng, math);
		hong.print();
		
		
		//
		Sawon s1=new Sawon();
		s1.print();
		Sawon s2=new Sawon(2, "박문수");
		s2.print();
		Sawon s3=new Sawon("총무부", "경기", 4200);
		s3.print();
		Sawon s4=new Sawon(3, "김두한", "기획부", "부산", 5500);
		s4.print();
		
	}

}
