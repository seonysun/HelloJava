/*
 * 1. 자바에서 정수 표현
 * 	1) 10진법 : 10, 20, 30 -> 프로그램은 가독성이 좋아야 하므로 10진법 사용
 *  2) 2진법 : 0, 1 
 *  3) 8진법 : 0~7 --> 0~~
 * 			2진법 수를 뒤에서 3개씩 끊어서
 *  4) 16진법 : 0~9 + 10(A),11(B),12(C),13(D),14(E),15(F) --> 0x~~
 *  		2진법 수를 뒤에서 4개씩 끊어서
 *  
 * 2. 음수 표현 : 2의 보수 방법을 사용
 * 		- 10을 2진법으로 00001010
 * 		   -> 1의 보수 11110101
 * 		   -> 2의 보수 +      1
 *                   11110110
 *      - 어떤 수의 음수 표현은 2의 보수로 나타냄 -> 더했을 때 (자리 올림 발생 후) 0이 되는 수
 *  */

public class 진법출력 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(27)); //11011
		System.out.println("0"+Integer.toOctalString(27)); //033
		System.out.println("0x"+Integer.toHexString(27)); //0x1B
		
		System.out.println(~165); //~로 음수 표현할 떄는 1을 더함
		
	}

}
