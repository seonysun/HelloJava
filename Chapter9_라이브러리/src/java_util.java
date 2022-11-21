import java.util.*;

/*
 * 2. util : 자주 사용되는 클래스 
 * 	- import 사용 필수
 * 
 * 	1) Random : 난수 추출
 * 		- nextInt() : 정수 난수추출(범위 int로 지정)
 * 			ex. nextInt(100) -> 0~99
 * 		- nextBoolean(), nextDouble()
 * 	2) Scanner : 입력값 받는 경우
 * 		- next(), nextInt()
 * 	3) StringTokenizer : 구분자 기준으로 문자열을 자를 경우
 * 		- 네트워크(DB 연결, 서버 개설)에서 많이 사용
 * 		- 생성자 : new StringTokenizer(문자열, 구분문자)
 * 		- countTokens() : 분리된 단어 갯수 셀 때
 * 		- nextToken() : 분리된 문자열 읽을 때
 * 						-> 갯수 확인 필수(잘려진 갯수보다 많은 메소드 호출할 수 없음)
 * 						-> 직접 가져오기보다는 루프 사용
 * 		- hashMoreTokens() : 루프(while) 사용 시
 * 	4) Date
 * 	5) Calender
 * 
 * List - ArrayList, Vector, LinkedList, Quene, Stack
 * Set - HashSet, TreeSet
 * Map = Hashtable, Hashmap
 * */

public class java_util {

	public static void main(String[] args) {
		//random
		Random r=new Random();
		int i=r.nextInt(31)+1;
		System.out.println(i+"\n");
		
		int[] reserve=new int[r.nextInt(10)+11];
		for(int j=0;j<reserve.length;j++) {
			reserve[j]=r.nextInt(31)+1;
		}
		Arrays.sort(reserve);
		System.out.println("==예약 가능 날짜==");
		for(int j:reserve) {
			if(j>=21)
				System.out.print(j+" ");
		}
		System.out.println("\n");
		
		
		//stringTokenizer
		String date="2022-11-21";
		StringTokenizer st=new StringTokenizer(date,"-");
													//구분자에서 공백은 생략 가능
//		String year=st.nextToken();
//		String month=st.nextToken();
//		String day=st.nextToken();
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}

}
