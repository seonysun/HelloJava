/*
 * 0. 에러 = 오작동, 비정상 종료
 * 	- 수정 불가능 에러 : 메모리 부족, eclipse 프로그램상 문제
 * 	- 수정 가능 에러 : 사용자 입력값 잘못됨(유효셩)  ex. 0으로 나누기
 * 				   프로그래머 실수  ex. 배열, 캐스트, null
 * 		-> 예외처리; 복구(try~catch) / 회피(throws)
 * 	- 컴파일에러(*) : 컴파일시 에러(문법에러) javac
 * 	  런타임에러(*) : 실행시 에러 java
 * 	  논리적에러 : 실행 가능, 프로그램 제작이 의도와 다르게 진행
 *  - 에러 발생 시 종료하지 않고 정상 수행되는 프로그램이 견고한 프로그램
 * 
 * 1. 견고한 프로그램
 * 	1) 에러 사전에 방지하는 프로그램
 * 		- if문으로 조건 제시
 * 		- 예외처리(if 처리 불가능한 경우)
 * 
 * 	2) 예외처리
 * 		- 프로그램 실행 시 발생할 수 있는 에러에 대비하는 코드 -> 에러 사전 방지
 * 		- 프로그램의 비정상 종료를 방지, 정상 수행 가능하도록 함
 *		- 가벼운 에러, 수정이 가능한 에러
 *			cf. 웹에서의 에러 -> 웹, 네트워크, 파일과 관련될 때는 예외처리 필수(없으면 오류)		
 *				- 404 : 파일이 없는 경우(파일명이 잘못된 경우)
 *				- 500 : 문법 에러
 *				- 415 : 한글 변환(UTF-8)
 *				- 400 : 전송 데이터와 받는 데이터의 데이터형이 다른 경우
 *		- Java Exception : NullPointException, ArrayIndexOutOfBoundsException
 *							-> 콘솔창(output창)에 표기됨
 *
 *	3) 예외처리의 종류
 *		- 예외 복구(*) : 예외가 발생하면 복구해서 다시 수행 가능 -> 가장 많이 사용
 *			-> try { 
 *				정상 수행 문장(에러 발생 가능) 
 *			   } catch(예외처리 종류) { 
 *				에러 발생 시 복구하는 문장
 *			   } 
 *		- 예외 회피(*) : 에러 부분을 제외하고 다음 문장부터 수행(if문과 유사)
 *			-> method() throws 예외처리
 *		- 예외 임의 발생 : 테스팅시 의도적으로 예외를 발생시켜 프로그램 종료 여부(견고한 프로그램 여부)를 확인
 *			-> throw 예외처리;
 *		- 사용자정의 예외처리 : 자바에서 지원하지 않는 경우 직접 제작
 *			-> class 클래스명 extends Exception{}
 *
 *	4) 자바에서 지원하는 예외처리의 계층구조
 *		- Error : 메모리부족, 윈도우 작동 안됨, 이클립스 문제 발생
 *		- Exception : 파일명 오지정, IP 오지정, 웹주소 오지정, SQL 문장 잘못 수행
 *		- 상위 계층구조의 클래스가 더 많은 에러를 찾아낼 수 있음
 *			-> 가장 하위 Exception부터 계층 순서대로 사용해야 함
 *			-> 상위 Exception 먼저 사용하면 에러 모두 찾아내므로 아래 코딩된 하위 Exception 수행 불가 -> 에러
 *								Object
 *								  |
 *				 		 	  Throwable : 예외처리 최상위 클래스
 * 					 			  |
 * 		     ____________________________________________
 *		 	 |											|
 *		   Error: 수정 불가능 에러						Exception : 수정 가능한 에러
 *														|
 *									  ______________________________________
 *									  |									   |
 *							   IOException(파일)						RuntimeException
 *							   SQLException(DB)							   |
 *						MalformedURLException(URL, 서버)		  ArrayIndexOutOfBoundsException
 *						ClassMotFoundException(리플렉션)			  NumberFormatException
 *						 InterrupterException(쓰레드)				  NullPointerException
 *								  								   ClassCastException
 *										  						  ArithmeticException
 *						---------------------------------------------------------------------
 *								CheckException					   UnCheckException
 *								   컴파일 에러								실행 에러
 *							 컴파일 시 예외처리 여부 확인				 컴파일 시 예외처리 여부 확인 X
 *								 (예외처리 필수)						 (필요 시 예외처리)
 *
 *	5) 예외처리 형식
 *	 (1) 직접처리(예외 복구) : 프로그래머가 직접 처리
 *		- 웹, DB는 CheckException -> 예외처리 필수
 *		- try { 
 *				정상 수행 문장(에러 발생 가능) 
 *		  } catch(예외처리 종류) { //예상되는 예외처리 종류 여러번 사용 가능
 *				에러 발생 시 복구하는 문장(에러 확인)
 *		  } finally { //생략 가능
 *				try, catch 상관없이 무조건 수행되는 문장 //파일 닫기, 오라클 닫기, 서버 닫기
 *		  }
 *		- ex. 두 개의 정수 문자열로 받아서 정수 배열에 저장, 저장된 데이터로 나눗셈 수행하는 프로그램
 *			-> 배열의 인덱스 번호 오류; ArrayIndexOutOfBoundsException
 *			-> 문자열을 정수로 변경하는 과정에서 오류; NumberFormatException
 *			-> 0으로 나누는 오류; ArithmeticException
 *			-> NullPointerException
 *		- 예외처리는 예상되는 갯수보다 +1(기타), Exception으로 처리
 *		- 예외처리 위치
 *	 (2) 간접처리(예외 회피) : 자바 시스템에 맡김
 *	 (3) 예외 임의발생 
 *	 (4) 사용자정의 예외처리 
 * */

public class 예외처리 {

	public static void main(String[] args) {
		try {
			for(int i=1;i<=10;i++) {
				int r=(int)(Math.random()*3);
				if(r==0) {
					i--;
					continue;
				}
				System.out.println(i+"."+(i/r));
			}
		} catch(Exception ex) { //catch절이 for문 밖에 있으므로 오류 발생 시 for문 빠져나옴 -> 내부에서 if 처리해서 for문 끝까지 수행되도록 설정
			ex.printStackTrace();
		}
		System.out.println();
		
		
		for(int i=1;i<=10;i++) { //for문 안에 try, catch절이 모두 포함되어 for문 끝까지 수행됨 -> better!
			try {
				int r=(int)(Math.random()*3);
				System.out.println(i+"."+(i/r));
			} catch (Exception ex) {
				i--;
			}
		}

	}

}
