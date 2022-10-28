import java.util.Scanner;

public class 연산자_연습문제 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어, 영어, 수학 점수(90 90 90):");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
		int temp = (int)avg;
		
		System.out.println("국어 점수:"+kor+", 영어 점수:"+eng+", 수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println(temp>60 ? "Pass":"Fail");

	}

}
