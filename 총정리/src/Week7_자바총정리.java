/*
 * 1. 내부클래스 : 쓰레드, 네트워크, 빅데이터 분석 (MapReduce, Spark)
 *	1) 멤버클래스
 *		- 두개의 클래스가 공유해야되는 데이터나 메소드 존재할 때 주로 사용 
 *		- class A{ 
 *			class B{}
 *		  }
 *	2) 익명의 클래스(스프링)
 *		- class A{
 *			B b=new B(){ //상속없이 오버라이딩이 가능한 클래스 
 *				public void display(){}
 *			}
 *		  }
 *		  class B{
 *			public void display(){}
 *		  }
 * 	3) 지역클래스 
 *      - class A{
 *          public void display(){
 *          	class B{} //메소드 내에서만 사용 가능
 *          }
 *        }
 *        
 * 2. 종단클래스 : 확장이 불가능한 클래스 
 *   - final class ClassName ==> String,Math,System (java.lang)
 *   
 * 3. 라이브러리
 * 	1) java.lang : 가장 기본이 되는 클래스 집합 -> import 생략 가능
 * 		(1) Object : 최상위 클래스(모든 클래스는 Object 상속)
 * 					-> 서로 다른 클래스 묶어서 관리
 * 					-> 모든 라이브러리의 메소드에서 객체 리턴할 때 리턴형 Object로 설정됨
 * 						ex. class A{
 *								aaa()
 *								bbb()
 * 								ccc()
 * 							}
 * 							Object a=new A(); 
 * 								-> A의 메소드 중에 Object의 메소드 오버라이딩된 것만 호출 가능
 * 					 			-> a.aaa() 호출 불가
 * 					 			-> 형변환 A aa=(A)a; 하여 A의 메소드 활용
 *			- toString() : 가장 많이 오버라이딩되는 메소드
 *			- finalize() : GC에 의해 자동 호출
 *			- clone() : 동일한 크기의 새로운 메모리 생성, 복제 -> 스프링 prototype
 *															cf. 스프링 : 기본은 싱글턴(객체당 메모리를 1개만 생성, 재사용) -> 메모리 누수현상 방지
 *						  											   여러개 제작 시 prototype(객체당 메모리 여러개 생성)
 *			- equals() : 객체 비교
 *						-> == : 주소값 비교(기본형) / equals : 실제 저장된 값 비교(참조형)
 *					cf. 참조 - class A{}
 *							  A a=new A();
 *							  A b=a; //a=b -> 매개변수로 객체를 받는 경우 주로 사용
 *							  A c=a.clone(); //a≠c
 *
 * 		(2) String
 * 			cf. 오라클의 데이터형 
 * 				- 문자형(CHAR, VARCHAR2, CLOB->String)
 * 				- 숫자형(NUMBER->int, double)
 * 				- 날짜형(DATE, TIMESAMP->Date)
 * 				- 기타형(BLOB, BFILE->InputStream)
 * 			- 문자 저장 방법
 * 				String s="";
 * 				String s=new String("");
 * 			- int length()
 * 			- trim() : 좌우 공백 제거(가운데 공백 제거 불가)
 * 			- String substring(int begin, int end) : end-1
 * 			- boolean startsWith() / endsWith()
 * 			- boolean contains() : 자음으로 찾기 -> 추천, 챗봇
 *				cf. 오라클 질문
 *					- procedure / 트리거
 *					- CHAR : 고정형 메모리, VARCHAR2 : 가변형 메모리
 *					- BLOB : binary로 저장, BFILE : 파일로 저장
 * 			- equals()
 * 			- int indexOf() / lastIndexOf() : 문자(char)나 문자열(String)의 위치 찾기
 * 											-> 경로명, 확장자 찾을 때 주로 lastIndexOf
 * 				cf. 오라클 INSTR : 앞에서 -> 1번부터 커짐, 뒤에서 -> -1번부터 작아짐
 * 			- static String valueOf(Object o)
 * 
 * 		(3) StringBuffer : 문자열 결합 시 최적화
 * 			- append()
 * 			- toString() : 저장된 데이터 한 번에 읽어올 때 
 * 
 * 		(4) Math : 오라클에도 동일한 메소드들이 있으므로 자주 사용하지는 않음
 * 			- static double random()
 * 			- static double ceil(double d)
 * 			- static double round(double d)
 * 
 * 		(5) Wrapper(*) : 제네릭스에서 주로 사용
 * 			- 박싱 : Wrapper=리터럴;
 * 			  언박싱 : 기본형=Wrapper;
 * 			- parseInt() / parseDouble() / parseBoolean() / parseLong() : 문자열을 해당 데이터형으로 변경
 * 
 * 		(6) System
 * 			- in(), out() : 표준 입출력
 * 			- currentTimeMillis() : 시간 읽기 -> 실행시간, 로그파일
 * 
 * 		(7) java.lang.regex -> Pattern / Matcher (정규식)
 * 			- [] : 범위 -> [A-Z] [a-z] [A-Za-z] [0-9] [가-힣]
 * 			- {} : 갯수 -> [a-z]{3} [a-z]{1,3}
 *			- + : 1이상 -> 맛있+
 *			- * : 0이상 -> 맛없*
 *			- . : 임의의 1글자 -> [a-z]. a1 aK a가
 *			- $ : 끝나는 문자 -> [a-z]$ 
 * 			- ^ : 시작 문자 -> ^[a-z]
 * 				: 부정 -> [^a-z]
 *			- | : 선택
 *			- 정규식 기호로 문자의 패턴 만들어 검색 
 * 
 * 	2) java.util : 웹, 모바일에서 사용 빈도 높은 클래스 집합
 * 		(1) StringTokenizer : 단어별로 문자 자를 때 사용
 * 			- new StringTokenizer(String data, String 구분자) : 생성자
 * 			 	-> 구분자가 공백일 경우 생략 가능
 * 				-> 배열 형식이므로 데이터 갯수 확인
 * 			- String nextToken() : 구분된 데이터 읽기
 * 			- boolean hasMoreTokens() : 갯수를 모르거나 여러 데이터의 갯수가 서로 다른 경우, 루프(while문)에서 사용
 * 			- int countTokens()
 * 
 * 		(2) Date, Calendar
 * 			- Date : 기능 없음, 날짜 데이터형
 * 			- Calendar : 추상클래스 -> Calendar cal=Calendar.getInstance();
 * 				- 날짜 설정 : set(Calendar.YEAR,2022)
 * 						   set(Calendar.MONTH,10) //0부터 시작 -> month-1
 * 						   set(Calendar.DATE,30)
 * 				- 날짜 읽기 : get(Calendar.DAY_OF_WEEK) //요일, 일요일-1부터 시작
 * 
 * 		(3) Collection; ArrayList, HashSet, HashMap, Vector : 배열 확장, 보완 인터페이스
 * 			- List : 순서 있음, 중복 있음 -> 데이터 접근 속도 빠름 -> DB에서 사용
 * 					- ArrayList : 비동기화, add() remove() set() get() clear() size()
 * 					- Vector : 동기화
 * 					- LinkedList
 * 			- Set : 순서 없음, 중복 없음 -> ArrayList 데이터의 중복 제거 -> 웹에서 통신(사용자 정보 저장)시 사용
 * 																	Application : Socket
 * 																	Web : WebSocket
 * 										cf. 오라클에서 가져올 때 DISTINCT 사용 시 알아서 제거되므로 사용 빈도는 적음
 * 					- HashSet : add() remove() get() clear() size()
 * 					- TreeSet
 * 			- Map : 키(중복 없음) + 값(중복 있음) -> 클래스관리(스프링), SQL관리(마이바티스), 쿠키, 세션, 요청값, 응답값 -> 웹에서 사용
 * 					- HashMap : 비동기화, put() get()
 * 					- Hashtable : 동기화
 * 
 * 	3) java.text
 * 		(1) SimpleDateFormat
 * 		(2) MessageFormat : 형식있는 문자열 생성 -> DB, SQL 제작 시 사용
 * 
 * 	4) java.io
 * 		(1) File : 파일, 디렉토리(폴더) 정보
 * 			- File file=new File("경로명"); -> 디렉토리 정보
 * 			- File file=new File("경로명/파일명"); -> 파일 정보
 * 			- getName() : 파일/디렉토리명 읽기
 * 			- getPath() : 경로명, 파일명 전체 읽기
 * 			- getParent() : 경로명 읽기
 * 			- length() : 파일 크기
 * 			- listFiles() : 파일 목록 읽기
 * 			- createNewFile() : 파일 생성
 * 			- mkdir() : 폴더 생성
 * 			- delete() : 파일 삭제
 * 		(2) FileInputStream / BufferedInputStream
 * 			- read(), close()
 * 			- 업로드 시 사용
 * 			- Buffered -> 임시 메모리에 전체 데이터 한번에 모두 가져온 후 실행 -> 속도 빠름
 * 		(3) FileOutputStream / BufferedOutputStream
 * 			- write(), close()
 * 			- 다운로드 시 사용
 *	   ---------------------------------------------------------------------- 1byte씩 읽음 -> 파일 제어(copy, 업/다운로드)
 * 		(4) FileReader / BufferedReader
 * 			- read(), close()
 * 			- readLine() : BufferedReader만 가능(데이터 임시 메모리에 모두 존재 -> FileReader는 한글자씩 읽는 것만 가능)
 * 		(5) FileWriter / BufferedWriter
 *			- write(String), close()
 *	   ---------------------------------------------------------------------- 2byte씩 읽음 -> 파일에 저장된 데이터(문자 스트림) 제어
 * 		- 웹에서는 DB 파일에서 데이터를 가져오는 방식 주로 사용하므로 ObjectStream 사용 빈도 적음
 * 
 * 	5) java.net
 * 		- URL : 웹사이트 주소 설정
 * 		- URLEncoder : 브라우저(아스키, 1byte) <-> 자바(유니코드, 2byte)
 *  				  				   인코딩 디코딩
 */

import java.io.*;
import java.net.*;

class A { // 윈도우 , Server (접속 담당)
	class B { //쓰레드 , 통신 담당 
		public void display() {
			System.out.println("B:display Call...");
		}
	}
	public void aaa() {
		B b=new B();
		b.display();
	}
}
class D {
	E e=new E() {
		public void display() {
			System.out.println("D.E:display() Call...");
		}
	};
}
class E {
	public void display() {
		System.out.println("E:display() Call...");
	}
}
public class Week7_자바총정리{
	public static void main(String[] args) {
		A a=new A();
		a.aaa();
			
		E e=new E();
		e.display();
			
		D d=new D();
		d.e.display();
		
		//
		try {
			URL url=new URL("https://www.daum.net/");
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn!=null) {
				BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true) {
					String s=in.readLine();
					if(s==null) break;
					System.out.println(s);
				}
			}
		} catch(Exception ex) {}
		
	}
	
}
