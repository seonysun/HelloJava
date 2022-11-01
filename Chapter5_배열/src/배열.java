import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 배열 : 같은 타입의 여러개 변수를 하나로 묶어서 관리
 * 				-> 참조변수; 메모리 주소(stack)를 이용하여 접근하는 방식
 * 					(arr라는 배열: arr은 참조변수, 실제 데이터값을 저장하는 것이 아니라 데이터가 저장된 주소를 저장하는 것)
 * 						cf. stack : 메모리 주소, heap : 실제 데이터 저장
 * 	- 서로 관련된 같은 타입의 데이터 3개 이상일 때 -> 배열 사용하는 것이 좋음
 * 	- 일차 배열, 다차원 배열, 가변 배열
 * 	
 *	1) 장점 - 변수 여러 개를 한 개의 이름으로 제어 -> 반복문 사용하기 좋음
 *		   - 연속적으로 메모리 배치 -> 인덱스 번호 이용해서 처리 가능 	
 * 	   단점 - 고정적임(한 번 결정하면 변화시키기 어려움) -> 컬렉션(가변형) 이용
 * 		   - 같은 데이터형만 모아서 관리 가능
 * 
 * 	2) 선언 : 참조변수(배열명)의 선언
 *		- 데이터형[] 배열명; : 권장사항
 *		- 데이터형 배열명[]; : C언어 호환
 * 
 *	3) 생성(초기화) : 실제 데이터값 저장 위한 공간(배열 요소) 생성
 *		- new 이용하여 데이터 저장 공간 생성, 자동 초기화(0)
 *				-> int(0), char('\0'):공백, double(0.0), boolean(false), String(null)
 *			: 데이터형[] 배열명 = new 데이터형[메모리 갯수];
 *				-> 이후 직접 초기화, 난수, 입력값, 웹에서 데이터 읽기
 *		- 초기화 : 배열명[인덱스(배열 요소의 번호)] = 값; 
 *					-> 일반 변수 1개와 동일하게 취급하므로 필요시마다 값 변경 가능
 *			ex. int[] arr = new int[5];
 *				arr[0]=10;
 *				arr[1]=20;
 *		- 명시적 초기화	: 선언과 생성, 초기화를 동시에
 *					: 데이터형[] 배열명 = {값,값..}; 
 *		- 인덱스 : 상수, 변수, 수식 모두 사용 가능
 *					ex. for문에서 인덱스를 변수 i로 사용
 *			   : 0부터 시작
 *
 *	4) 출력
 *		- 일반 for문 : 데이터 변경 가능(인덱스번호 이용하여 변경)
 *				앞에서부터 출력 : for(int i=0;i<갯수;i++) {
 *								System.out.println(변수명[i]); 
 *							  }
 *				뒤에서부터 출력 : for(int i=갯수-1;i>=0;i--) {}
 *			cf. while문을 사용해도 되지만 배열은 횟수가 정해져있는 것이므로 for문을 주로 많이 사용
 *		- forEach문 : 실제 배열의 저장된 데이터값을 0번부터 출력 -> 뒤에서부터 출력 불가
 *					  for(int i:배열명) {
 *						System.out.println(i); 
 *					  }
 *							-> 배열의 데이터형보다 크거나 같아야 함
 *		- Arrays.toString 메소드 : System.out.println(Arrays.toString(배열명));
 *		- 배열의 갯수 : 배열명.length -> 상수(변경 불가)
 * */

public class 배열 {

	public static void main(String[] args) {
		/* int a=80, b=70, c=60, d=50, e=100;
		int max=0;
		if(max<a) max=a;
		if(max<b) max=b;
		if(max<c) max=c;
		if(max<d) max=d;
		if(max<e) max=e;
			//같은 형태 5번 반복이지만 변수가 a,b,c,d,e로 계속 변화하므로 반복문 돌릴 수 없음 -> 배열 사용
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
		System.out.println("max="+max);
		*/
		
		int[] arr = {80,70,60,50,100};
				//배열 인덱스 번호는 0번부터 시작 -> arr[0] ~ arr[4]
		int max=0;
		for(int i=0;i<5;i++)
			System.out.println("arr["+i+"]="+arr[i]);
		for(int i=0;i<5;i++)
			if(max<arr[i]) max=arr[i];
		System.out.println("max="+max);

		
		//명시적 초기화
		int[] arr1 = {10,20,30,40,50};
					//중괄호 안에 입력된 수만큼 연속하여 저장
		System.out.println("2번째 데이터:"+arr1[1]);
		
		
		//값 변경
		System.out.println(arr1[2]);
		arr1[2]=300;
		System.out.println(arr1[2]);
		
		
		//데이터 난수로 저장
		int[] arr2 = new int[5];
		for(int i=0;i<arr2.length;i++) {
					//배열의 인덱스 번호는 0부터 시작하므로 등호 쓰면 안됨
			arr2[i]=(int)(Math.random()*100)+1;
		}
		for(int i:arr2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		//배열의 데이터값 변경 후 다시 출력
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=arr2[i]+(i+1);
		}
		
		/*
		arr2[0]=arr2[0]+1;
		arr2[1]=arr2[1]+2;
		arr2[2]=arr2[2]+3;
		arr2[3]=arr2[3]+4;
		arr2[4]=arr2[4]+5;
		 */
		
		for(int i:arr2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		//입력값으로 데이터 저장 - 학점구하기
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<3;i++) {
			System.out.print((i+1)+"번째 국어 점수:");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어 점수:");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학 점수:");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
		}
		
		for(int i=0;i<avg.length;i++) {
			switch((int)(avg[i]/10)) {
			case 10: case 9:
				score[i]='A';
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default: 
				score[i]='F';
			}
		}
		
		System.out.println("  국어  영어  수학   총점     평균   학점");
		for(int i=0;i<3;i++) {
			System.out.printf("%d:%-5d%-5d%-5d%-5d%7.2f%3c%n",i+1,kor[i],eng[i],math[i],total[i],avg[i],score[i]);
		}
		
		
		//정리 - 알파벳 출력
		char[] alpha = new char[26];
		char c='A';
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=c;
			c++;
			//alpha[i]=c++;
		}
		for(char ch:alpha) {
			System.out.print(ch+" ");
		}
		System.out.println();

		for(char ch:alpha) {
			ch=(char)(ch+32);
			//출력 시에만 변경, 실제 배열의 데이터값은 바뀌지 않음
			System.out.print(ch+" ");
		}
		System.out.println();
		
		
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)(alpha[i]+32);
			//실제 배열의 데이터값을 변경하고자 할 때는 인덱스 번호를 이용해야 함
		}
		for(char ch:alpha) {
			System.out.print(ch+" ");
		}
		System.out.println();
		
	}

}
