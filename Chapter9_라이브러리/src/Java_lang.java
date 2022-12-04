import java.util.Arrays;

/*
 * 0. 라이브러리(패키지+클래스+메소드)
 * - java.lang : 프로그램에서 가장 많이 사용되는 클래스의 집합 -> import 생략 가능
 * - java.util
 * - java.text
 * - java.io
 * - java.net
 * 
 * 1. java.lang
 *	1) Object : 최상위 클래스 
 *		- 생성된 모든 클래스는 Object 제공 메소드 사용 가능
 *
 *		- 복제 기능(*) : 같은 값을 가진 메모리 새롭게 만들어 줌 (스프링 : prototype)
 *			protected Object clone()
 *				cf. 참조(얕은 복사) : 같은 주소를 제어
 *									-> Object의 clone() : 원본 객체의 값 그대로 복사
 *					복제(깊은 복사) : 새로운 메모리 생성, 다른 주소를 제어
 *									-> clone() 생성 후 객체에 새로운 인스턴스 참조
 *
 *		- 문자열화(*) : 메소드의 리턴형이 Object일 때 문자열로 형변환
 *			public String toString()
 *			- toString으로 출력 시 생략 가능(입력 시에는 추가 필수)
 *				ex. class A{} 
 *					A a=new A();
 *					입력 String s=a.toString() //s에 a의 toString 메소드 내용 저장(기본은 객체 주소값)
 *						String s=(String)a;
 *						String s=String.valueOf(a)
 *					출력 System.out.println(a);
 *										//a.toString
 *
 *		- 소멸자(*) : 객체 메모리 제거
 *			protected void finalize()
 *			  : 객체가 null이거나 사용이 없는 경우 
 *					-> System.gc() 실행
 *					-> finalize 자동 호출
 *					-> 객체 메모리에서 소멸
 *
 *		- 객체 비교 : equals(), !equals() -> ==, != 사용하지 않음
 *			public boolean equals(Object obj)
 *								//모든 데이터형 가능
 *				cf. Object = 주소값 비교, String = 저장된 문자열 비교
 *					-> Object에서는 equals 사용 빈도 거의 없고 String(Object 상속)으로 비교
 *
 *		- 속한 클래스의 클래스객체를 반환하는 메소드(객체 정보)(*)
 *			public Class getClass()
 *			- 클래스객체 : 클래스의 모든 정보 포함, 클래스당 1개씩 존재
 *						-> 실행 시 클래스객체 메모리 존재 여부 확인
 *						-> 존재할 경우 객체 주소 반환
 *						   존재하지 않을 경우 지정된 경로로 클래스 찾아서 클래스객체로 생성, 메모리에 로드
 *			- 클래스객체 참조 방법
 *				- Class 객체명=new 클래스명().getClass();
 *							//생성된 객체로부터 얻음
 *				- Class 객체명=클래스명.class;
 *							//클래스 파일로부터 얻음
 *				- Class 객체명=Class.forName("클래스명");
 *					-> DB 드라이버와 같은 클래스 파일 메모리에 로드할 때 주로 사용 
 *			- 객체 생성
 *				- 클래스명 객체명=new 클래스명(); -> 생성자 이용
 *				- 클래스명 객체명=클래스명.class.newInstance(); -> 클래스객체의 메소드 이용
 *
 *		- 자바에서 지원하는 대부분의 메소드는 리턴형 Object(모든 데이터형 가능) -> 형변환해서 사용
 *
 *	2) String : 문자열을 저장하는 클래스(char[] 이용해서 만든 클래스)
 *		- 문자열 저장하는 데이터형/클래스형
 *		- 참조변수이나 기본형 취급 -> Call By Value
 *			String s=""; : 문자열의 주소를 얻는 방식("" 자체가 주소)
 *		  	String s=new String(""); : 새로운 메모리에 문자열을 저장
 *				ex. String s1="홍길동"; String s2="홍길동"; 
 *					-> s1과 s2는 같은 주소를 지정
 *					String s3=new String("홍길동");
 *					-> s3은 다른 주소를 지정
 *		- final 클래스(종단클래스) 
 *			-> 변경(오버라이딩) 불가, 있는 그대로 라이브러리 사용해야 함
 *				cf. 종단클래스 :  Math, StringBuffer, StringBuilder, System, Wrapper
 *		
 *		- charAt : 문자열에서 원하는 위치의 문자 한개 추출 
 *			public char charAt(int index) 
 *		- toUpperCase : 대문자 변환 => 컬럼명 / 테이블명 (배열)
 *			public String toUpperCase()
 *		- toLowerCase : 소문자 변환
 *			public String toLowerCase()
 *		- concat : 문자열 결합
 *			public String concat(String s)
 *		- trim(*) : 좌우 공백 제거 -> 사용자 실수 방지(유효성 검사)
 *			public String trim()
 *
 *		- equals(*) : 문자열 비교(대소문자 구분) -> 로그인처리, 아이디 중복체크
 *			public boolean equals(Object o)
 *		- equalsIgnoreCase : 문자열 비교(대소문자 구분 없음) -> 게시판, 검색기
 *			 public boolean equalsIgnoreCase(String s)
 *
 *		- contains : 문자 포함 여부 비교 -> 검색기
 *			public boolean contains(String s)
 *
 *		- startsWith : 시작 문자열이 같은지 여부 비교 -> 쿠키 출력(최근 방문 사이트)
 *			public boolean startsWith(String prefix)
 *		- endsWith : 끝 문자열이 같은지 여부 비교
 *			public boolean endsWith(String suffix)
 *
 *		- replace(*) : 문자, 문자열 변경
 *			public String replace(String old, String nw)
 *			public String replace(char old, char nw)
 *		- replaceAll : 정규식(문자열 패턴)을 이용하여 변경 -> 크롤링
 *			public String replaceAll(String regex, String s)
 *			- 정규식 기호 : . | ^ ? + * 
 *				-> 실제 기호 자체로 사용시 \\ 입력 필수
 *
 *		- split(*) : 구분자 통해 문자열 구분 후 배열에 저장 -> StringTokenizer
 *			public String[] split(String regex)
 *			- 구분자는 정규식으로 사용
 *		- join : 문자열 사이에 구분자 넣어서 결합
 *
 *		- length(*) : 문자 갯수 확인 -> 화면 UI
 *			public int length()
 *
 *		- indexOf : 원하는 문자나 문자열의 위치 찾기(앞에서부터 검색)
 *			public int indexOf(String s)
 *			public int indexOf(char c, int pos) : pos부터 확인
 *			- 문자열 시작 번호 0
 *			- 없으면 -1 반환
 *		- lastIndexOf : 원하는 문자나 문자열의 위치 찾기(뒤에서부터 검색)
 *			public int lastIndexOf(String s)
 *			public int lastIndexOf(char c)
 *
 *		- substring(*) : 문자열을 자를 경우에 사용
 *			public String substring(int startIndex, int endIndex)
 *			- s부터 e 전까지
 *
 *		- valueOf(*) : 모든 데이터형을 문자열로 변환
 *			public static String valueOf(int a)
 *			- 유일한 static 메소드 -> String.valueOf()
 *
 *	3) StringBuffer : 문자열 결합 최적화
 *		- append : 문자열 결합
 *			public StringBuffer append(String s)
 *		- toString : 문자열 출력
 *			public String toString()
 *
 *	4) Wrapper : 각 데이터형을 클래스화
 *		- 기본형 데이터를 참조형(클래스형 Object)으로 변환
 *			-> 기본형에서 필요한 메소드를 제공 -> 사용에 편리
 *				ex. 문자열 정수로 변환, 이진법 변환 등
 *			-> Integer, Double, Boolean, Long, Byte, Short, Float
 *		- 박싱 : Integer i=10; 클래스형에 실제 데이터값(리터럴)을 대입
 *		  언박싱 : int k=i; 기본형에 클래스형 데이터를 대입
 *		- 문자열 변환
 *			parseInt, parseDouble, parseBoolean, parseLong
 *		- equals() : 실제값 비교
 *		- Collection : 데이터 모아서 관리 -> 배열 대체(가변형)
 *
 *	5) Math : 기본적인 수학 계산 -> 게임에서 많이 사용, 웹에서는 사용 빈도 적음
 *		- static double random() : 난수 추출
 *		- static double ceil(double d) : 올림 -> 페이지 나누기
 *		- static long round(double d) : 반올림
 *
 *	6) System
 *		- 입출력
 *		- GC(가비지 컬렉션) 
 * */

public class Java_lang {

}
