import java.util.Random;
import java.util.Scanner;

public class 조건문_연습문제 {

	public static void main(String[] args) {
		//문제1. 정수 한 개를 입력받아서, 그 수가 50 이상의 수인지 50미만의 수인지 판단해보자.
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 한 개를 입력하세요:");
		int num1 = scan.nextInt();
		if(num1>=50) {
			System.out.println(num1+"은(는) 50 이상입니다.");
		} else {
			System.out.println(num1+"은(는) 50 미만입니다.");
		}
		
		
		//문제2. 정수 한 개를 입력받아서, 그 수가 3의 배수인지 판단해보자.
		System.out.println("정수 한 개를 입력하세요:");
		int num2 = scan.nextInt();
		if(num2%3==0) {
			System.out.println(num2+"은(는) 3의 배수입니다.");
		} else {
			System.out.println(num2+"은(는) 3의 배수가 아닙니다.");
		}
		
		
		//문제3. 1학년부터 4학년까지 중간고사 시험을 보았다. 4학년은 70점 이상이면 합격, 그 이외의 학년은 60점 이상이면 합격이다. 점수가 0미만 100초과이면 경고문구 출력!
		System.out.println("학년을 입력하세요(1~4):");
		int year = scan.nextInt();
		System.out.println("점수를 입력하세요:");
		int score = scan.nextInt();
		
		if(score>=0 && score<=100) {
			if(year==4) {
				if(score>=70) System.out.println(year+"학년 합격!");
				else System.out.println(year+"학년 불합격");
			} else if(score>=60) {
				System.out.println(year+"학년 합격!");
			} else {
				System.out.println(year+"학년 불합격");
			}
		} else System.out.println("잘못 입력하셨습니다.");
			//오류 범위 따로 설정해도 되지만 보통은 정상 입력 조건 주고 else로 처리
			//따로 설정 시 -> if(score<0 || score>100) System.out.println("잘못 입력하셨습니다.");

		
		//문제4. 세 개의 정수를 난수 추출하여 그 수들의 최댓값과 최솟값을 구해보자.
		int a = (int)(Math.random()*100)+1;
		int b = (int)(Math.random()*100)+1;
		int c = (int)(Math.random()*100)+1;
		System.out.println("a:"+a+", b:"+b+", c:"+c);
		
		int max = 0;
		if(max<a) max=a;
		if(max<b) max=b;
		if(max<c) max=c;
		System.out.println("최댓값:"+max);
		
		int min = 1000;
		if(min>a) min=a;
		if(min>b) min=b;
		if(min>c) min=c;
		System.out.println("최솟값:"+min);
		
		
		//문제5. 사용자로부터 정수를 입력받아 양수인지 음수인지 확인하는 프로그램 작성
		System.out.println("정수 입력:");
		int num5 = scan.nextInt();
		if(num5>=0) System.out.println(num5+"은(는) 양수입니다.");
		else System.out.println(num5+"은(는) 음수입니다.");
			// num5>=0?"양수":"음수"
		
		
		//문제6. 임의의 문자를 추출하여 대문자인지 소문자인지 확인하는 프로그램 작성
		int i = (int)(Math.random()*2);
						//랜덤으로 대문자와 소문자를 추출해야 하므로 두 가지 변수(0과 1)로 옵션 설정
		int no = (int)(Math.random()*26)+65;
						//문자는 랜덤으로 추출 불가 -> int 추출하여 char로 형변환
		char alpha = ' ';
		
		if(i==0) {
			alpha = (char)no;
		} else {
			alpha = (char)(no+32);
		} 
		
		System.out.println("alpha:"+alpha);
		if(alpha>='A' && alpha<='Z') {
			System.out.println(alpha+"은(는) 대문자입니다.");
		} else System.out.println(alpha+"은(는) 소문자입니다.");
		
		
		//문제7. 점수 3개를 입력받아서 총점과 평균을 구하고 학점을 구하는 프로그램 (97이상 A+, 94이상 A0, 90이상 A-, 80 B, 70 C,60 D, 나머지 F)
		System.out.println("국어,영어,수학:");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		int total = kor+eng+math;
		int avg = total/3;
		
		char grade = 'A';
		char ch = '0';
		
		if(avg>=90) { grade = 'A';
			if(avg>=97) ch = '+';
			else if(avg<94) ch = '-';
		}	// ch의 초기값 설정해두면 한 가지 옵션 생략 가능
		else if(avg>=80) { grade = 'B';
			if(avg%10>=7) ch = '+';
			else if(avg%10<4) ch = '-';
		}
		else if(avg>=70) { grade = 'C';
			if(avg%10>=7) ch = '+';
			else if(avg%10<4) ch = '-';
		}
		else if(avg>=60) { grade = 'D';
			if(avg%10>=7) ch = '+';
			else if(avg%10<4) ch = '-';
		}
		else grade = 'F';
		
		System.out.println("학점:"+avg+"점, "+grade+ch);

	}

}
