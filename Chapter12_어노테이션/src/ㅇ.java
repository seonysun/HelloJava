//
//public class ㅇ {
//	파일의 종류 
//	 *          = 정형화 : 프로그램에 필요한 데이터를 구분해서 저장 (오라클) => 제약조건 
//	 *          = 반정형화 : 구분만 해주는 데이터 (HTML/XML/JSON)
//	 *                                    ---------------
//	 *          = 비정형화 : 구분이 없는 데이터 (txt,dat) ====> IO 
//	 *          = File 
//	 *          = 읽기/쓰기 
//	 *            FileInputStream / FileOutputStream 
//	 *            FileReader / FileWriter 
//	 *            BufferedReader / BufferdWriter ==> 데이터 수집 
//	 *            BufferedInputStream / BufferdOutputStream ==> 다운로드/업로드 
//	 *            ------------------------------------------
//	 *            ObjectInputStream / ObjectOutputStream ==> 네트워크 
//	 *            
//	 *      = java.net : 흐름 (역할 => 쓰레드 , 내부클래스) => 서버개발 (웹서버가 이미 존재) => tomcat,오라클서버
//	 *      -------------------------- 오라클 연결 (java.sql) : Connection,Statement,ResultSet
//	 *                                                      => 오라클 연결 
//	 *                                                      => SQL문장 전송 (SQL문장)
//	 *                                                         *** SQL (개발자마다 틀리다) => 경우의 수
//	 *                                                      => 결과값 받기 
//	 */
//	/*
//	 *     691page => 열거형 (데이터를 모아서 관리) 
//	 *                      ---------------- 관련된 일반 데이터 : 배열 
//	 *                                       관련된 상수 : 열거형 ==> 국번  (jdk 1.5이상에서 실행)
//	 *                                       ==> JDK (1.8) => 호환형 => sun에서 마지막으로 만든것 
//	 *     => STS / Eclipse / DBleaver / SqlDeveloper / Tomcat (9버전/10버전=>패키지명이 틀리다) 
//	 *     => 상수를 사용하기 쉽게 만드는 프로그램 (데이터를 모아서 => 1개의 이름으로 제어)
//	 *     => 사용법 
//	 *        enum 열거형명 {상수명 , 상수명....} => 윈도우 , 게임 , 서버 개발 ...
//	 *        enum Server {LOGIN,LOGOUT,MAKEROOM,ROOMIN,START...} => static
//	 *             => Server.LOGIN
//	 *      과일 apple 사과
//	  과일 avocado 아보카도
//	  과일 banana 바나나
//	  과일 blackberry 블랙베리, 검은 딸기
//	  과일 blueberry 블루베리
//	  과일 cherry tomato 체리 토마토, 방울 토마토
//	  과일 cherry 체리, 버찌
//	  과일 coconut 코코넛
//	  과일 grape 포도
//	  과일 kiwi 키위
//	  과일 lemon 레몬
//	  과일 lime 라임
//	  과일 mango 망고, 망고나무
//	  과일 melon 멜론
//	  과일 orange 오렌지
//	  과일 papaya 파파야
//	  과일 peach 복숭아
//	  과일 pear 배
//	  과일 persimmon 감, 감나무
//	  과일 pineapple 파인애플
//	  과일 plum 자두, 서양 자두, 플럼
//	  과일 strawberry 딸기
//	  과일 tangerine 귤, 탄제린
//	  과일 tomato 토마토
//	과일 watermelon 수박
//	 *      
//	 */
//	import java.util.*;
//	// 클래스의 일종 => 생성자 , 멤버변수를 가지고 있다 
//	enum 과일명{
//		사과("apple"),
//		아보카도("avocado"),
//		바나나("banana"),
//		블랙베리("blackberry"),
//		블루베리("blueberry"),
//		포도("grape"),
//		오렌지("orange"),
//		귤("tangerine"),
//		토마토("tomato"),
//		수박("watermelon");
//		private String en;
//		과일명(String en)
//		{
//			this.en=en;
//		}
//		public String getEn() {
//			return en;
//		}
//		
//	}
//	public class MainClass_열거형 {
//	    
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//	        Scanner scan=new Scanner(System.in);
//	        System.out.print("과일명 입력:");
//	        String f=scan.next();
//	        for(과일명 n:과일명.values())
//	        {
//	        	//System.out.println(n);
//	        	if(n.name().equals(f))
//	        	{
//	        		System.out.println(f+"의 영어명은 "+n.getEn());
//	        		break;
//	        	}
//	        }
//		}
//
//	}
//}
