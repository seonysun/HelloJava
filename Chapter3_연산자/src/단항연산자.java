/*
 * 0. 연산자 : 연산 수행 기호
 * 	  피연산자 : 연산자 작업 대상 -> 변수, 상수, 리터럴, 수식 등
 * 
 * 1. 단항연산자 = 피연산자 1개
 *  1) 증감연산자 (++, --) : 값 무조건 1씩 증감
 *  		- 정수형 또는 문자형에서 사용 가능
 *   		- 전치 연산자 ++a -> 다른 변수에 대입 시 증가 후 대입
 *   							b = ++a -> b = a
 *   		- 후치 연산자 a++ -> 다른 변수에 대입 시 대입 후 증가
 * 								b = a++ -> b+1 = a
 * 			- 게임에서 총알 발사 횟수, 자동으로 옆으로 이동, 조회수 증가 등에 사용
 * 
 *  2) 부정연산자 (!) : 반드시 boolean만 사용 가능 
 *  		- (!true) = false
 *  		- 1:1 턴 -> 반대 효과
 *  		- 좌석 예매 시스템(이선좌..), 컴퓨터 vs 플레이어 게임, 예약일 조회 등
 * 
 *  3) 형변환연산자 (type)
 *  		- 자동 처리, 필요 시(숫자; 정수, 문자, 실수)에 강제 처리
 *  		- 강제 형변환 시 오버플로우에 주의(가급적이면 사용하지 않는 것을 추천)
 *  		- 최우선순위 연산자 : ()
 *  		- 클래스 형변환
 *  
 *  4) 음수/양수 (+, -)
 *  
 *  5) 반전연산자 (~) : 음수 표현(양수 -> 음수로 변환)
 *  		- 음수 표현 시에는 2의 보수법에 의해 1을 더하고 마이너스
 * */

public class 단항연산자 {

	public static void main(String[] args) {
		//증감연산자
		int a = 10;
		int b = ++a;
		System.out.println("a="+a+",b="+b);
		int c = 10;
		int d = c++;
		System.out.println("c="+c+",d="+d);
		
		
		//부정연산자
		boolean bCheck = false;
		bCheck = !bCheck;
		System.out.println(bCheck);
		System.out.println(!true);
		
		
		//형변환연산자
		int e = (int)(Math.random()*100)+1;
						//0.0~0.99 중 난수 추출 -> double형, 100 곱해서 int로 형변환 -> 0~99의 정수 난수 추출 가능
		System.out.println("e="+e);
		
		char f = (char)((Math.random()*25)+65);
								//0~24 + 65 -> 65~89 : 알파벳 유니코드
		System.out.println("f="+f);
		
		char g = 'A';
		char g1 = (char)(g+32);
						 //대문자 -> 소문자 : 유니코드 32 차이
		System.out.println("g1="+g1);
		
		char g2 = 'A'+32;
		System.out.println("g2="+g2);
			/* g1과 달리 g2에서 형변환이 필요하지 않은 이유
			 * g1 : g라는 char형 변수와 정수 리터럴의 연산
			 * g2 : 'A' 문자 리터럴과 정수 리터럴의 연산
			 * 			-> 연산 결과를 바로 변수 g2의 값으로 저장하기 때문에 오류가 생기지 않음 */
		
		int k = 'A'+32;
		System.out.println(k);
		System.out.println((char)k);		
		
	}

}
