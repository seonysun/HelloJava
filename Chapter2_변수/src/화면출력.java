import java.util.Scanner;
//다른 클래스 읽어오는 것(메모리에 저장) -> 여러개 사용 가능
		//라이브러리에 있는 패키지

/*
 * 0. 프로그램(소스 코딩 반복) => 응용 
 * 
 *   데이터 저장  ===> 데이터 조작 ===> 화면 출력  
 *    (변수)       (연산자,제어문) 
 *   
 * 1. 화면 출력
 * System.out.println(); 세로 출력 In newLine 
 * 						  -> 출력 후 줄바꿈
 * System.out.print(); 가로 출력 
 * 						-> 출력 후 줄 그대로
 * System.out.printf(); 서식있는 출력(출력 형식 만들어서 진행)
 * 						 -> 데이터형 출력 종류 : %d 정수 %f 실수 %c 문자 %s 문자열
 * 										  : %와 숫자가 함께 나오면 출력 칸 수 -> 간격 조절 시 사용
 * 											(양수: 오른쪽 정렬, 음수: 왼쪽 정렬)
 * 										  : %o(8진법) , %x(16진법) , %e(지수) , %b(boolean)
 * 
 * 2. 특수 문자 
 * 	 \t : 일정 간격 처리 tab
 * 	 \n : 다음줄 출력 newLine
 *   \" : 경로명
 *   
 * 3. 입력 : System.in(키보드 입력값) , Scanner , BufferedReader(예외처리)
 * 	- 자바 코딩 순서 
 *  	1) package : 현재 클래스의 경로 지정 -> 한번만 사용 가능
 * 		2) 다른 클래스 읽어오기 : import -> 여러개 사용 가능 
 *    	3) public class className {
 *         		 public static void main(String[] args){
 *           }
 *       }
 * */

public class 화면출력 {

	public static void main(String[] args) {
			//System.out.println(); = System.out.print("\n");
		System.out.println("Hello");
		System.out.print("Java"); //다음 줄의 !!이 Java 옆에 위치
		System.out.println("!!");
		System.out.println("^^");
		System.out.print("Hello\t");
		System.out.println("Java");
		
		System.out.printf("%s, %s", "Hello", "Java");
						  //문자열1, 문자열2의 형태로 출력 -> 옆에 1과 2 입력 필요
		System.out.printf("\n%s, %s", "Hello", "Java");
						   //위에 줄이 println이 아니므로 줄 바꾸도록 설정
		System.out.printf("\n평균:%.2f",(86/3.0)); 
							//바뀌는 문자열이 아니라 그냥 문구 삽입할 때는 서식에 바로 써줘도 됨
								  //실수, 이때 소수점 둘째자리까지 반올림
		
		System.out.printf("\n%5d%5d%5d", 90,80,70); 
							 //정수, 이때 칸 5개에 뒤(+)에서부터 채워짐 -> 간격 설정 가능
		System.out.printf("\n%-5d%-5d%-5d", 90,80,70); 
							 //정수, 이때 칸 5개에 앞(-)에서부터 채워짐 -> 간격 설정 가능
		
		
		int kor, eng, math, total;
		double avg;
		Scanner scan = new Scanner(System.in);
			//클래스; 여러 메소드(한 가지 기능 지님) 포함
					  //new를 써야 메모리에 저장이 된다(동적메모리 할당)
									//system.in : 키보드 입력값을 받아 변수에 대입
		System.out.print("국어 점수 입력");
		kor=scan.nextInt();
		System.out.print("영어 점수 입력");
		eng=scan.nextInt();		
		System.out.print("수학 점수 입력");
		math=scan.nextInt();
					//Scanner의 기능, 정수값 받아 저장
					//cf. next(): 문자열, nextDouble(): 실수형, nextBoolean(): 논리형
		
		total=kor+eng+math;
		avg=total/3.0;
		
		System.out.printf("%-6d%-6d%-6d%-8d%-6.2f",kor,eng,math,total,avg);
	}

}
