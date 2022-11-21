import java.util.Arrays;

/*
 * 0. 라이브러리
 * - java.lang : 프로그램에서 가장 많이 사용되는 클래스의 집합 -> import 생략 가능
 * - java.util
 * - java.text
 * - java.io
 * - java.net
 * - 라이브러리 : 패키지, 클래스명, 주요메소드
 * 
 * 1. java.lang
 *	1) Object : 최상위 클래스 
 *		- 생성된 모든 클래스는 Object 제공 메소드 사용 가능
 *		- 복제 기능(*) : 같은 값을 가진 메모리 새롭게 만들어 줌 (스프링 : prototype)
 *			참조(얕은 복사) : 같은 주소를 제어; a=b
 *			복제(깊은 복사) : 새로운 메모리 생성, 다른 주소를 제어; b=a.clone();
 *			protected Object clone()
 *		- 문자열화(*) 
 *			public String toString()
 *			- 메소드의 리턴형이 Object일 때 문자열로 형변환 시 사용
 *			- toString은 생략이 가능
 *				ex. class A{} A a=new A();
 *					String s=(String)a;
 *					String s=String.valueOf(a)
 *					String s=a.toString()
 *		- 소멸자(*) : 객체 메모리 제거
 *			protected void finalize()
 *			  : 객체가 null이거나 사용이 없는 경우 
 *					-> System.gc() 실행
 *					-> finalize 자동 호출
 *					-> 객체 메모리에서 소멸
 *		- 객체 비교 : equals(), !equals() -> ==, != 사용하지 않음
 *			public boolean equals(Object obj)
 *								//모든 데이터형 가능
 *				cf. Object = 주소값 비교, String = 저장된 문자열 비교
 *					-> Object에서는 equals 사용 빈도 거의 없고 String(Object 상속)으로 비교
 *		- 객체를 얻어오는 메소드(객체 정보)(*)
 *			public Class getClass()
 *		- 자바에서 지원하는 대부분의 메소드는 리턴형 Object(모든 데이터형 가능) -> 형변환해서 사용
 *
 *	2) String : 문자열을 저장하는 클래스(char[] 이용해서 만든 클래스)
 *		- 문자열 저장하는 데이터형/클래스형
 *		- final 클래스(종단클래스) -> 변경(오버라이딩) 불가, 있는 그대로 라이브러리 사용해야 함
 *
 *	3) StringBuffer : 최적화(문자열 결합)
 *
 *	4) Wrapper : 각 데이터형을 클래스화
 *		- 기본형을 참조형(Object형)으로 변환
 *			-> 기본형에서 필요한 메소드를 제공 -> 사용에 편리
 *				ex. 문자열 정수로 변환, 이진법 변환 등
 *		- Integer, Double, Boolean, Byte, Short, Float
 *		- 박싱 : Integer i=10; 클래스형에 실제 데이터값(리터럴)을 대입
 *		  언박싱 :  int k=i; 클래스 데이터를 기본형에 대입
 *
 *	5) Math : 수학 관련
 *
 *	6) System : 입출력 / GC(가비지 컬렉션) 
 * */

public class Java_lang {

	public static void main(String[] args) {

	}

}
