import java.util.Arrays;

/* 
 * 1. String
 * 	- 문자열 저장 : String s = ""; 가장 많이 사용(일반 변수처럼 취급)
 * 					cf. 일반 변수가 아닌 클래스형 변수(참조 변수)이므로 주소값으로 저장됨
 * 	- 문자열 제어(라이브러리)
 * 	
 * 	1) String 메소드의 기능
 * 		- 출력 시에 메소드 수행되어도 원본 문자열은 변경되지 않음(초기화를 다시하는 건 변경됨)
 * 		- 문자 변환
 * 			(1) toUpperCase : 알파벳 대문자 변환 -> 검색기
 * 			(2) toLowerCase : 알파벳 소문자 변환
 * 			(3) valueOf(*) : 모든 데이터형 간의 변환
 * 							String.valueOf : 문자열로 변환
 * 							Double.valueOf : 실수형으로 변환
 * 					ex. int a=10; 
 * 						String.valueOf(a) => "10" => parseInt("10") => 10
 * 			(4) toString(*) ; 문자열로 변환
 * 		
 * 		- 문자 제어
 * 			(1) substring(**) : 문자열 자를 때 사용 -> 화면 UI
 * 					ex. substring(int start, int end) -> start부터 end 전까지(end는 제외)
 * 			(2) trim(*) : 좌우 공백 제거 -> 사용자 입력 시 공백 제거
 * 		
 * 		- 문자 변경
 * 			(1) replace(*) : 지정 문자(문자열) 간 변경 -> 오라클 크롤링 시(이미지 저장 & -> ^)
 * 			(2) replaceAll(*) : 정규표현식을 이용하여 지정 문자(문자열)로 변경 -> ip 지정, 챗봇
 * 					ex. replaceAll("[0-9]{1-3}\\.[0-9]{1-3}\\.[0-9]{1-3}\\.[0-9]{1-3}")
 *									//모든 숫자로 1 or 3자리 -> 4번 반복하여 ip 생성
 *					cf. [가-힣]: 한글 전체 [A-Za-z]: 영문 전체 [0-9]: 숫자 전체
 * 			(3) split(*) : 문자열을 매개변수를 기준으로 잘라서 배열로 변경
 * 					ex. String s = "red,blue,green";
 * 						String[] arr = s.split(",") => {"red","blue","green"}
 * 		
 * 		- 문자 비교 -> boolean 반환
 * 			(1) equals(*) : 대소문자 구분하여 비교 -> 로그인
 * 				equalsIgnoreCase : 대소문자 구분하지 않고 비교 -> 검색어
 * 			(2) contains(*) : 포함 여부 비교 -> 검색
 * 			(3) startsWith(*) : 시작문자열 비교 -> 검색기 자동 완성(서제스트)
 * 			(4) endsWith : 끝문자열 비교 -> 검색기 자동 완성
 * 		
 * 		- 문자 찾기
 * 			(1) indexOf(*) : 앞쪽부터 데이터 위치 찾기
 * 			(2) lastIndexOf(*) : 뒷쪽부터 데이터 위치 찾기
 * 					ex. String s = "Hello Java";
 * 						s.indexOf("a") => J 뒤의 a
 * 						s.lastIndexOf("a") => 마지막 a
 * 							-> 동일한 문자가 여러개일 때는 찾는 문자가 달라지므로 번호가 달라지지만 해당 문자가 1개일 경우 결과(번호)는 같음
 * 			(3) length(*) : 문자의 총 갯수 확인
 * 
 * 		- 기타
 * 			(1) concat : 문자열 결합 -> + 연산자를 더 많이 사용
 * 			(2) charAt(*) : 문자열에서 문자 1개(괄호 안의 인덱스번호) 가져올 때
 * 					cf. 인덱스번호 시작 0부터
 * 			(3) toCharArray : 문자열을 문자 배열로 변경
 * */

public class 문자열 {

	public static void main(String[] args) {
		String s = "Hello Java ";
				  //0123456789
		System.out.println(s.length());
							//공백도 문자에 포함
		
		//
		System.out.println(s.trim().length());
		
		//
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		
		//
		System.out.println(s.substring(7));
									//매개변수: 메소드 안에 들어가는 변수
		System.out.println(s.substring(1,6));
		String post = "101-123";
		System.out.println(post.substring(0,3));
		System.out.println(post.substring(4));
		
		//
		String fileName = "문자열_1.java";
		System.out.println(fileName.substring(6));
		System.out.println(fileName.substring(fileName.lastIndexOf(".")+1));
												//확장명 가져오기 위해 마지막 "." 위치 파악 -> 그 다음 문자부터 잘라서 가져옴
		
		//
		System.out.println(s.indexOf("a"));
		System.out.println(s.lastIndexOf("a"));
		
		//
		System.out.println(s.replace('a', 'b'));
		
		//
		String msg="홍길동 version 2";
		System.out.println(msg.replaceAll("[^가-힣]", ""));
		//^: 제외 -> 한글을 제외한 나머지 공백
		System.out.println(msg.replaceAll("[^A-Za-z]", ""));
		System.out.println(msg.replaceAll("[^0-9]", ""));

		//
		char[] c = s.toCharArray();
		System.out.println(Arrays.toString(c));
		
		//
		String s1="Hello ";
		String s2="Java!!";
		System.out.println(s1.concat(s2));
		//System.out.println(s1+s2);

		//
		String movie="범죄, 스릴러 |한국 |105분 |2022.10.26 개봉";
		String[] m = movie.split("\\|"); //^, |, ?, ., +, * 와 같이 이미 사용중인 기호를 출력하기 위해서는 \\역슬래쉬 제시해야 함
		System.out.println(Arrays.toString(m));
		
	}

}
