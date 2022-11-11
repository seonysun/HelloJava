/*
 * 0. 클래스 : 하나의 큰 기능
 * 			 -> 변수 + 생성자 + 메소드
 * 	  메소드 : 각각의 세부 기능 1개
 * 		ex. 게시판 기능의 클래스 -> 글쓰기 메소드, 삭제 메소드, 수정 메소드, 목록출력 메소드, 상세보기 메소드, 검색 메소드
 * 
 * 1. 메소드의 종류
 * 	1) 인스턴스 메소드 : 각각 서로 다른 메모리에 저장 -> 개별적으로 다르게 동작
 * 		- 인스턴스 변수를 이용할 때 사용(대부분)
 *
 * 	2) 클래스 메소드(정적메소드, 공유메소드); static : 하나의 메모리에 저장 -> 공유
 * 		- 인스턴스 변수를 이용하지 않을 때 사용
 * 		- 클래스 메소드 안에서는 인스턴스 메소드 호출 불가
 * 			-> 클래스 메소드는 자동으로 저장, 인스턴스 메소드는 동적메모리 할당 후 저장되기 때문
 * 			   (클래스의 객체를 생성하면 인스턴스 메소드의 동적메모리 할당됨)
 * 		  인스턴스 메소드 안에서는 인스턴스/클래스 메소드 모두 호출 가능(동일 클래스 내)
 * 			-> 객체 생성 시 클래스 내 모든 인스턴스 메소드의 동적메모리 할당되기 때문
 * 				ex. void a() {b, c, d 모두 호출 가능}
 * 					static void b() {c만 호출 가능}
 * 					static void c() {b만 호출 가능}
 * 					void d() {a, b, c 모두 호출 가능}
 * 		- 웹페이지는 보통 static이 많음(관리자가 설정 변경하면 모두에게 적용) -> oracle로 만든 static
 * 
 * 	3) 추상 메소드
 * 
 * 2. 메소드 선언
 *	1) 선언부 : [접근지정어] [옵션] 리턴형 메소드명(매개변수) 
 *			- 접근지정어 : public, protected, default, private
 *
 * 			- 옵션 : static; 공통으로 사용되는 메소드일 때, 인스턴스변수 사용하지 않을 때 -> DB에서 많이 사용, Oracle
 * 					final; 수정이 불가능한 상태로 고정 -> 웹에서 사용빈도 적음
 * 					abstract; 추상메소드
 * 					생략; 인스턴스 메소드 -> new로 선언하는만큼 저장됨 -> 웹에서 주로 사용
 * 			
 * 			- 리턴형 : 배열, 클래스, 일반 데이터형 모두 가능
 * 				ex. Category[] recipeListData() -> Category 클래스(변수, 메소드 포함) 배열로 가져옴
 * 					Recipe recipeDetailData() -> Recipe 클래스 가져옴
 * 					int recipeTotalPage() -> 페이지 숫자 가져옴
 * 					boolean isLogin() -> 로그인여부 가져옴
 * 					void memberInsert(회원정보 m) -> 회원정보 m 입력, 수정, 삭제 진행
 * 
 * 			- 매개변수 : 사용자 입력(클릭, 선택, 입력 등)
 * 				- 매개변수 입력값(인자)이 복사되어 메소드에 전달되어 처리
 * 					-> 실제 변수 저장 공간과 매개변수 저장 공간은 서로 다름
 *				- 기본형, String : Call By Value
 *			  						-> 매개변수 메모리 저장 공간에 실제 변수의 리터럴이 저장
 *										=> 메소드 수행 시 값이 변경되더라도 실제 변수값은 그대로 유지
 *								 read only
 *				- 참조형(배열, 클래스) : Call By Reference
 *										-> 매개변수 메모리 저장 공간에 실제 변수의 주소값이 저장
 *			 								=> 메소드 수행 시 값이 변경되면 실제 변수값도 변경됨
 *									read, write
 *				- 매개변수가 3개 이상이면 클래스, 배열 이용
 *				- 매개변수 갯수가 명확하지 않을 경우 가변 매개변수 이용 
 *					ex. 체크박스(몇개 체크할 지 모름), 장바구니
 * 
 * 	2) 인스턴스 : 리턴형 메소드명(매개변수) {	return 값; }
 * 	   static : static 리턴형 메소드명(매개변수) {	return 값; }
 * 
 * 3. 메소드 호출
 * 	1) 인스턴스 : new를 이용하여 메소드가 포함된 클래스의 동적메모리 할당 필요
 *  			-> 클래스명 객체명 = new 클래스명(); //동적메모리 할당, 객체 생성
 *  			   객체명.메소드명(); //호출
 *  					cf. 참조변수 생성 없이 new 클래스명().메소드명() 로 바로 대입하여 사용할 수도 있음
 *  	ex. class A{
 *  			int age;
 *  			String name;
 *  			void insert(int age, String name){	}
 *  			void update(int age, String name){	}
 *  			void list(){	}
 *  		}
 *  		A a=new A(); //a라는 참조변수에 변수 age, name과 메소드 insert(), update(), list()가 저장됨
 *  		a.age, a.insert() ..
 *  
 * 	2) static : 컴파일러에 의해 자동으로 메모리 할당됨
 * 				-> 서로 다른 클래스일 때 : 클래스명.메소드명(); 
 * 				   동일 클래스 내에서 : 메소드명();
 * 				라이브러리는 static 메소드
 * 					ex. Math 클래스의 random() -> 클래스 객체 생성 없이 메소드 사용 가능
 * 		ex. class A{
 *  			static int a;
 *  			static void list(){	}
 *  		}
 *  		A.a, A.list() ..
 * 
 * 4. 오버로딩 : 한 클래스 내에서 같은 이름의 메소드 여러 개 정의하는 것
 * 				-> 하나의 메소드명으로 조작 가능한 새로운 기능 추가
 * 		- 기능이 같은 경우 메소드명 통일 -> 메소드명 절약, 사용하기 편리
 * 			ex. println(int a / boolean b / char[] c / double d / String s);
 * 				onClick(String id, String pw / int a);
 * 		- 생성자에서 가장 많이 사용
 * 	1) 조건 
 * 		- 같은 클래스 내에서 생성
 * 		- 메소드명 동일
 * 		- 매개변수 갯수나 데이터형이 다름 
 * 		- 리턴형, 매개변수 이름은 관계 없음(같아도, 달라도 모두 안됨) -> 오류
 * 
 * cf. 클래스가 가지고 있는 변수를 출력할 때는 앞에 this. 붙임
 * 		ex. class Member{
 * 				String id, pw; //heap에 저장 -> this. 를 붙여서 호출
 * 				boolean isLogin(String id, String pw) //Stack에 저장 -> 저장 공간이 다르므로 동일한 변수명 사용 가능
 * 			}
 * */

class Names{
	String name1;
	String name2;
	static String name3;
}
public class 메소드종류 {
	final int num=1000;
	
	void swap(int a, int b) {
		int tmp=a;
		a=b;
		b=tmp;
		System.out.println("swap:a="+a+", b="+b);
	}
	void swap(String name1, String name2) {
		//오버로딩
		String tmp=name1;
		name1=name2;
		name2=tmp;
		System.out.println("swap:name1="+name1+", name2="+name2);
	}
	void swap(String[] names) {
		String tmp=names[0];
		names[0]=names[1];
		names[1]=tmp;
		System.out.println("swap:names[0]="+names[0]+", names[1]="+names[1]);
	}
	void swap(Names name) {
		String tmp=name.name1;
		name.name1=name.name2;
		name.name2=tmp;
		System.out.println("name1="+name.name1+", name2="+name.name2);
	}

	void display(char c, int i, long l) {
		System.out.println("display(char c, int i, long l) Call..");
	}
	int display(int c, int i, double l) {
		System.out.println("display(int c, int i, long l) Call..");
		return 0;
	}
	double display(double c, double i, double l) {
		System.out.println("display(double c, double i, double l) Call..");
		return 0.0;
	}
	long display(float c, double i, long l) {
		System.out.println("display(float c, double i, long l) Call..");
		return 0L;
	}
	public static void main(String[] args) {
		메소드종류 m=new 메소드종류();
		System.out.println(m.num);
			//상수도 인스턴스 변수이므로 객체 생성 후 호출 가능
		
		int x=10;
		int y=20;
		m.swap(x, y);
		System.out.println("main:x="+x+", y="+y);
			//매개변수(x, y: int) -> 메소드 수행 시 결과값만 변경되어 출력되고 매개변수 실제값은 변경되지 않음
		
		String name1="홍길동";
		String name2="박문수";
		m.swap(name1, name2);
		System.out.println("main:name1="+name1+", name2="+name2);
			//매개변수(name1, name2: String) -> 메소드 수행 시 결과값만 변경되어 출력되고 매개변수 실제값은 변경되지 않음
		
		String[] names= {"이순신", "강감찬"};
		m.swap(names);
		System.out.println("main:names[0]="+names[0]+", names[1]="+names[1]);
			//매개변수(names: 배열) -> 메소드 수행 시 매개변수 실제 값도 변경
		
		Names n=new Names();
		n.name1="철수";
		n.name2="영희";
		m.swap(n);
		System.out.println("name1="+n.name1+", name2="+n.name2);
			//매개변수(n: 클래스) -> 메소드 수행 시 매개변수 실제 값도 변경
		
		
		m.display(10.0,10,10); //10.0이 double이므로 리턴형 double인 메소드 호출
			//m.display(10,10,10); -> 처음 10이 int, double, float 모두 가능하므로 오류
			//-> 이렇게 애매하게 메소드 오버로딩하면 안됨
		
	}

}
