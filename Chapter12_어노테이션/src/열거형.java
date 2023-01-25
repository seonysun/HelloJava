import java.util.*;

/*
 * java.io
 * 	- 파일의 종류
 * 		- 정형화 : 프로그램에 필요한 데이터 구분해서 저장(오라클)
 * 		- 반정형화 : 구분만 해주는 데이터(HTML, XML, JSON)
 * 		- 비정형화 : 구분되지 않는 데이터(txt, dat -> IO)
 * java.net
 * 	- 흐름
 *  
 * 1. 열거형 : 관련된 상수 데이터 모아서 제어 -> 사용 편리
 * 		cf. 관련된 일반 데이터형 모음 : 배열
 * 			관련된 상수 모음 : 열거형
 * 	1) 사용법
 * 		- enum 열거형명 {상수명..}
 * 			ex. enum Server {LOGIN,LOGOUT,MAKEROOM,ROOMIN,START...}
 * 				-> Server.LOGIN
 * 	2) 특징
 * 		- 클래스의 일종 -> 생성자, 멤버변수 가짐
 *  	- 생성자 public 사용 불가
 * */

enum 전화국번{
	서울특별시("02"),
	경기도("031"),
	인천광역시("032"),
	강원도("033"),
	충청남도("041"),
	대전광역시("042"),
	충청북도("043"),
	세종특별자치시("044"),
	부산광역시("051"),
	울산광역시("052"),
	대구광역시("053"),
	경상북도("054"),
	경상남도("055"),
	전라남도("061"),
	광주광역시("062"),
	전라북도("063"),
	제주도("064");
	private String code;
	public String getCode() { //상수이므로 setter 불필요
		return code;
	}
	전화국번(String code) {
		this.code=code;
	}
}
enum 과일명{
	사과("apple"),
	아보카도("avocado"),
	바나나("banana"),
	블랙베리("blackberry"),
	블루베리("blueberry"),
	포도("grape"),
	오렌지("orange"),
	귤("tangerine"),
	토마토("tomato"),
	수박("watermelon");
	private String en;
	public String getEn() {
		return en;
	}
	과일명(String en) {
		this.en=en;
	}
}
public class 열거형 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("지역 입력:");
		String loc=scan.next();
		for(전화국번 n:전화국번.values()) {
			if(n.name().contains(loc)) 
				System.out.println(loc+"의 국번은 "+n.getCode()+"입니다.");
		}
		
		System.out.print("과일명 입력:");
        String f=scan.next();
        for(과일명 n:과일명.values())
        {
        	if(n.name().equals(f))
        	{
        		System.out.println(f+"의 영어명은 "+n.getEn()+"입니다.");
        		break;
        	}
        }

	}

}
