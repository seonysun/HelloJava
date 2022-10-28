/*
 * 0. UpCasting : 데이터형을 큰 걸로 변환 -> 주로 자동 형변환
 * 					ex. 변수 초기값 제시 시 double d = 10; --> d = 10.0
 * 									   int a = 'A'; --> a = 65
 * 						연산 처리시 int + double --> double
 * 	  DownCasting : 데이터형을 작은 걸로 변환 -> 주로 강제 형변환
 * 
 * 1. 자동 형변환
 *  1) 연산 시 큰 데이터형으로 변환되어 진행
 *  2) 변수에 값을 입력할 때 
 *  		ex) int a = 'A' --> a = 65
 *  	이 때, 변수는 값보다 크거나 같아야 함
 *  		int a = 10.5 --> 오류
 *  		int a = (int)10.5 
 *  3) int 이하 데이터형(byte, short, char)이 연산되면 int(주로, int 이상 다 가능)로 변환
 *  	byte + char = int
 *     	byte + byte = int
 *     		ex) byte b1 = 10; byte b2 = 20; 
 *     		    int b3 = b1 + b2;
 *     
 * 2. 강제 형변환
 *  1) 1.3)의 경우에서 byte b1 = 10; byte b2 = 20; 
 *     		 		byte b3 = (byte)(b1 + b2);
 *     							--> 사용하지 않는 것이 좋음, 오버플로우 발생 가능
 *  2) 일부 연산 시 
 *  		ex) 정수/정수 -> 정수가 아닐 수도 있음 -> 형변환 해주지 않으면 소수점 출력 불가
 *  3) 예외: 유니코드(int) -> char 는 작아지는 방향으로도 가능
 * */

public class 형변환 {

	public static void main(String[] args) {
		int m = 10; int n = 3;
		System.out.println(m/n);
		System.out.println(m/(double)n);
		System.out.println((double)m/n);
		
		int k = 10;
		System.out.println(-k);
		
	}
}
