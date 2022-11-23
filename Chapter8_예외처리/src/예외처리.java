import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 0. 에러
 * 	- 오작동, 비정상 종료
 * 	- 컴파일에러(*) : 컴파일시 에러(문법에러); CheckedException -> javac
 * 	  런타임에러(*) : 실행시 에러; UnCheckedException -> java
 * 	  논리적에러 : 실행 가능, 프로그램 제작이 의도와 다르게 진행
 * 	- 수정 불가능 에러 : 메모리 부족, eclipse 프로그램상 문제
 * 	- 수정 가능 에러 : 사용자 입력값 잘못됨(유효성 검사)  ex. 0으로 나누기
 * 				   프로그래머 실수  ex. 배열, 캐스트, null
 * 
 * 1. 견고한 프로그램
 * 	- 에러 발생 시 비정상 종료되지 않고 정상 종료되는 프로그램
 * 		cf. 좋은 프로그램
 * 				- 가독성 : 다른 개발자가 쉽게 알아볼 수 있는 프로그램(유지보수)
 * 						-> 구조적인 프로그램(메소드-기능별 분리)
 * 						-> 재사용(상속)
 * 						-> 수정, 추가(다형성)
 * 						=> 객체지향 프로그램
 * 				- 최적화 : 실행 속도가 빠른 프로그램
 * 						-> 웹에서 최적화 : 데이터 전송 속도와 화면 출력 속도 균형(화면 출력 속도 조절 : React, Vue)
 * 				- 견고성 : 에러에 대응할 수 있는 프로그램(예외처리)
 * 
 * 	1) 에러 사전에 방지하는 프로그램
 * 		- if문
 * 		- 예외처리(if문 처리 불가능한 경우)
 * 
 * 	2) 예외처리
 * 		- 프로그램 실행 시 발생할 수 있는 에러에 대비하는 코드 -> 에러 사전 방지
 * 		- 프로그램의 비정상 종료를 방지, 정상 종료 가능하도록 함
 *		- 가벼운 에러, 소스 상에서 수정이 가능한 에러
 *			cf. 웹에서의 에러 -> 웹, 네트워크, 파일과 관련될 때는 예외처리 필수(없으면 오류)		
 *				- 404 : 파일이 없는 경우(파일명이 잘못된 경우)
 *				- 500 : 문법 에러
 *				- 415 : 한글 변환(UTF-8)
 *				- 400 : 전송 데이터와 받는 데이터의 데이터형이 다른 경우
 *		- 예외처리로 소스가 변경되는 것은 아님 -> 에러 부분 잘라내기
 *		- Java Exception : NullPointException, ArrayIndexOutOfBoundsException ..
 *							-> 콘솔창(output창)에 표기됨
 *
 *	3) 자바에서 지원하는 예외처리의 계층구조
 *		- Error : 메모리부족, 윈도우 작동 안됨, 이클립스 문제 발생
 *		- Exception : 파일명 오지정, IP 오지정, 웹주소 오지정, SQL 문장 잘못 수행
 *		- 상위 계층구조의 클래스가 더 많은 에러를 찾아낼 수 있음
 *			-> 가장 하위 Exception부터 계층 순서대로 사용해야 함
 *			-> 상위 Exception 먼저 사용하면 에러 모두 찾아내므로 아래 코딩된 하위 Exception 수행 불가 -> 에러
 *
 *				 		 	  Throwable : 예외처리 최상위 클래스
 * 		   	 ┌────────────────────┴─────────────────────┐
 *		   Error: 수정 불가능 에러						Exception : 수정 가능한 에러
 *									┌───────────────────┴──────────────────┐
 *							   IOException(파일)						RuntimeException
 *							   SQLException(DB)							   |
 *						MalformedURLException(URL, 서버)		  ArrayIndexOutOfBoundsException
 *						ClassNotFoundException(리플렉션)			  NumberFormatException
 *						 InterruptedException(쓰레드)				  NullPointerException
 *								   ...							   ClassCastException
 *										  						   ArithmeticException
 *						---------------------------------------------------------------------
 *							  CheckedException					   UnCheckedException
 *								  컴파일 에러								실행 에러
 *							 컴파일 시 예외처리 여부 확인				 컴파일 시 예외처리 여부 확인 X
 *								 (예외처리 필수)						 (필요 시 예외처리)
 *
 *		- 컴파일 : 이진법 파일로 변경 
 * 				javac; 프로그래머 실수 -> CheckedException
 * 		- 인터프리터 : 한줄씩 읽어서 출력 
 * 				   java; 사용자의 오류(외적인 요인) -> UnCheckedException
 *		- CheckedException 예외처리 필수
 * 			= IOCheckException : 입출력 에러(파일명, 경로명 에러)
 * 			= ClassNotFoundException : 클래스가 없는 경우 -> 리플렉션(new 없이 메모리 할당 가능)
 * 			= SQLException : 오라클, MYSQL 연결(DB 연결)
 * 			= InterruptedException : 쓰레드 충돌
 * 			= MalformedURLException : IP, URL 주소 에러(크롤링 시 자주 발생)
 * 		- UnCheckedException 예외처리 선택
 * 			= ArrayIndexOutOfBoundsException : 배열 범위 초과(인덱스 번호 오류)
 * 			= NumberFormatException : 정수 변환 오류(웹, 윈도우는 정수 전송 불가, 문자열로 변환해서 전송 -> 항상 변환 필수)
 * 			= NullPointerException : 객체 선언 후 생성없이 사용(주소값 없음)
 * 			= ClassCastException : 클래스 형변환 오류(빈도 적음 -> 제네릭스가 자동 형변환 가능)
 * 		- Exception : 다중 조건문(선택문) -> 모든 예외 처리 가능
 *
 *	4) 예외처리의 종류
 *		- 예외 복구(*) : 예외가 발생하면 복구해서 다시 수행(if문과 유사) -> 가장 많이 사용
 *			-> try { 
 *				정상 수행 문장(에러 발생 가능) 
 *			   } catch(예외처리 종류) { 
 *				에러 발생 시 복구하는 문장
 *			   } 
 *		- 예외 회피(*) : 에러 부분을 제외하고 다음 문장부터 수행
 *			-> method() throws 예외처리 {}
 *		- 예외 임의 발생 : 테스팅시 의도적으로 예외를 발생시켜 프로그램 종료 여부(견고한 프로그램 여부)를 확인
 *			-> throw new 예외처리();
 *		- 사용자정의 예외처리 : 자바에서 지원하지 않는 경우 직접 제작
 *			-> class 클래스명 extends Exception{}
 *
 *	5) 예외처리 형식
 *	 (1) 직접처리(예외 복구) : 프로그래머가 직접 처리
 *		- 웹, DB는 CheckedException -> 예외처리 필수
 *		- try { 
 *				정상 수행 문장(에러 발생 가능) 
 *		  } catch(예외처리종류 참조변수) { 
 *				에러 발생 시 복구하는 문장(에러 확인)
 *		  } finally { //생략 가능
 *				try, catch 수행 여부 상관없이 무조건 수행되는 문장 
 *					-> 파일 닫기, 오라클 닫기, 서버 닫기
 *					-> 오류 발생 시 제대로 프로그램 종료되지 않으면 서버 무너질 수 있음
 *		  }
 *		- 예상되는 예외처리종류 갯수만큼 catch문 여러번 사용 가능
 *			-> 하나에 통합해서 사용하는 것도 가능, |로 구분(멀티 catch문) : 중복 코드 줄일 수 있음
 *				(계층구조 동일한 것끼리만 나열 가능)
 *			ex. 두 개의 정수 문자열로 받아서 정수 배열에 저장, 저장된 데이터로 나눗셈 수행하는 프로그램
 *					-> 배열의 인덱스 번호 오류; ArrayIndexOutOfBoundsException
 *					-> 문자열을 정수로 변환하는 과정에서 오류; NumberFormatException
 *					-> 0으로 나누는 오류; ArithmeticException
 *					-> NullPointerException
 *		- 오류 발생 시 첫번째 오류 발생한 곳 이하의 문장 수행되지 않음, 바로 catch문으로 이동
 *		- catch문 여러개일 때는 첫번째로 해당되는 catch문만 실행(오류 한개만 찾을 수 있음)
 *			-> 하나의 catch문에 묶어서 사용, 조건문 이용하면 오류 여러개 찾을 수 있음
 *		- try-catch문 중첩 사용 가능
 *		- 예외처리는 예상되는 갯수보다 +1(기타), Exception으로 처리
 *		- 예외처리 위치 설정 주의
 *
 *	 (2) 간접처리(예외 회피) : 예외 떠넘기기
 *		- 메소드 생성 시 예외를 처리하지 않고 다른 메소드(호출한 곳-main)로 떠넘김
 *		- 예외 선언(시스템에 예상되는 예외 있음을 알림)
 *			-> 호출 시 예외처리 후 사용하도록 함(직접처리 or 간접처리)
 *										//try문 내부에서 간접처리된 메소드 호출
 *		- method() throws 예외처리종류 {}
 *		- 예외처리종류 comma(,)로 구분하여 여러개 나열 가능(순서 상관 없음)
 *		- 첫번째 선언 시 사용된 예외처리종류보다 다음 선언 시 사용하는 예외처리종류가 크거나 같아야 함(축소 불가, 여러개 다 써도 됨)
 *			-> 주로 Exception/Throwable 사용
 *		- UnCheckedException은 예외처리 필수 아니므로 주로 CheckedException 선언
 *		- throws는 메소드(생성자)에서만 사용 가능, 초기화블록에서는 사용 불가
 *		- 라이브러리에 많이 존재
 *			-> 이미 만들어진 메소드(라이브러리)에서 발생될 예외 예측하기는 어려움 
 *			-> 미리 예외 선언, 사용 전 예외처리 하도록 설정 
			-> 견고한 프로그램 작성 가능
 *
 *	 (3) 예외 임의발생(예외 던지기)
 *		- throw new 예외처리종류();
 *					//예외처리 클래스의 생성자 -> 객체 생성 -> 예외 임의 발생됨
 *			ex. throw new Exception();
 *		- 사용자정의 예외처리에서 사용 
 *			-> 사용자정의 예외처리 클래스는 catch문에서 읽을 수 없음
 *			-> 해당 예외처리 클래스를 임의로 발생시켜 catch에서 읽을 수 있도록 함
 *		- 사용 빈도 낮음
 *
 *	 (4) 사용자정의 예외처리 
 *		- Exception 상속을 받은 예외처리 클래스를 새롭게 정의
 *		- class 클래스명 extends Exception{}
 *		- 사용 빈도 낮음
 * */

class A{
	
}
class B extends A{
	
}
public class 예외처리 {

	public static void main(String[] args) {
		//예외처리 실행 순서
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(10/0); //try-catch절 없으면 비정상 종료 -> 8, 9 출력되지 않음
			System.out.println(5);
		} catch(RuntimeException ex) {
			System.out.println(6);
		} finally {
			System.out.println(7);
		}
		System.out.println(8);
		System.out.println(9);
		System.out.println();
		
		
		//
		try { //catch절 수행 시 다시 돌아오지는 않음 -> 오류 발생 위치 아래의 문장은 수행되지 않음
			B b=(B)new A();
			
			String str1=" 10"; //공백은 정수로 변환 불가 -> .trim()
			System.out.println(Integer.parseInt(str1.trim()));
			System.out.println(Integer.parseInt(str1));
			
			String str=null;
			System.out.println(str.trim());
			
			System.out.println(10/0); 
		} 
		catch(ArrayIndexOutOfBoundsException ex) {
			//배열 범위 초과할 경우
			System.out.println("배열의 범위를 초과하였습니다.");
		}
		catch(ArithmeticException ex) {
			//산술 연산 오류(정수를 0으로 나눴을 경우)
			System.out.println("정수는 0으로 나눌 수 없습니다.");
		}
		catch(NumberFormatException ex) {
			//문자열이 정수로 변환되지 않을 경우
			System.out.println("정수로 변환될 수 없습니다.");
		}
		catch(NullPointerException ex) {
			//객체, 클래스의 주소값이 없는 경우
			System.out.println("참조변수에 저장된 주소가 없습니다.");
		}
		catch(ClassCastException ex) {
			//형변환이 잘못됐을 경우
			System.out.println("형변환을 확인해주세요.");
		}
		catch(RuntimeException ex) {
			//위에 있는 모든 예외처리 + 예상하지 못하는 경우(기타)
			System.out.println("RuntimeException");
		}
		System.out.println();
		
		
		//try-catch 사용 위치
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
		System.out.println();
		
		
		//예외처리 메소드
		try {
			Scanner scan=new Scanner(System.in);
			System.out.print("정수 두개 입력(10 10):");
			int[] arr=new int[2];
			arr[0]=scan.nextInt();
			arr[2]=scan.nextInt(); //오류 발생 -> 프로그램 비정상 종료
			
			int res=arr[0]/arr[1];
			System.out.println("res="+res);
		} catch(ArrayIndexOutOfBoundsException ex) { //예외처리 -> 프로그램 정상 종료
			System.out.println(ex.getMessage()); //에러 설명 출력
			ex.printStackTrace(); //에러 위치 출력
		}
		System.out.println("프로그램 종료");
		System.out.println();
		
		
		//멀티 catch문
		try {
			Scanner scan=new Scanner(System.in);
			System.out.print("첫번째 정수 입력:");
			String num1=scan.next();
			System.out.print("두번째 정수 입력:");
			String num2=scan.next();
			
			int n1=Integer.parseInt(num1);
			int n2=Integer.parseInt(num2);
			
			int n3=n1/n2;
			System.out.println("결과값:"+n3);
		} catch(NumberFormatException | ArithmeticException ex) {
			if(ex instanceof NumberFormatException)
					//ex는 예외처리 클래스의 객체 -> 어떤 클래스의 객체에 해당하는지 확인하는 조건문
				System.out.println("문자열이 입력되었습니다.\n정수를 입력하세요.");
			else if(ex instanceof ArithmeticException)
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
		System.out.println();
		
		
		//파일 읽기
		FileReader fr=null; //finally문에서도 사용되는 변수이므로 try문 밖에 설정해야 함
		try {
			fr=new FileReader("c:\\javaDev\\guest.txt");
			int i=0;
			while((i=fr.read())!=-1) {
				System.out.print((char)i);
			}
		} catch(IOException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} finally {
			try {
				fr.close();
			} catch(IOException ex) {
				System.out.println("파일을 닫을 수 없습니다.");
			}
		}
		
		try (FileReader fr1=new FileReader("c:\\javaDev\\shop.txt")) { //fr.close() 자동처리
			int i=0;
			while((i=fr1.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		System.out.println();
		
		
		//로또 번호 추출
		try {
			int[] arr=new int[6];
			for(int i=0;i<arr.length;i++) {
				arr[i]=(int)(Math.random()*45)+1;
				for(int j=0;j<i;j++) {
					if(arr[j]==arr[i]) {
						i--;
						break;
					}
				}
			}
			System.out.println("오늘의 로또 번호:");
			Arrays.sort(arr);
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
				Thread.sleep(1000); //수행 사이에 (1000)*1/1000초 간격 설정 
			}
		} catch(InterruptedException e) { //충돌 방지
			System.out.println(e.getMessage());
		}

	}

}
