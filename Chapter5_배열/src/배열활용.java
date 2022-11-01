import java.util.Arrays;
import java.util.Scanner;

public class 배열활용 {

	public static void main(String[] args) {
		//랜덤 숫자 빈도수 계산
		int[] arr=new int[30];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*3);
		}
		System.out.println(Arrays.toString(arr));
		
		int a=0, b=0, d=0;
		for(int i:arr) {
			if(i==0) a++;
			else if(i==1) b++;
			else if(i==2) d++;
		}
		System.out.println("0:"+a);
		System.out.println("1:"+b);
		System.out.println("2:"+d);
		
				
		//2진법 출력
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력(0~32767):");
		int input = scan.nextInt();
		int[] binary = new int[16];
		int index=15;
		while(true) {
			binary[index]=input%2;
			input/=2;
			if(input==0)
				break;
			index--;
		}
		for(int i=0;i<binary.length;i++) {
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}
		System.out.println();
		
				
		//로또 번호 추첨(중복 없이)
		int[] lotto = new int[6];
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) { //i 이전의 숫자들 j로 설정하여 비교
				if(lotto[i]==lotto[j]) { //i가 j와 같을 경우
					i--; //저장하지 않고
					break; //비교하는 for문 종료 -> i--되어 다시 랜덤 추출하는 for문 진행
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
	
		
		//OX 맞추기
		char[] quiz = new char[10];
		for(int i=0;i<quiz.length;i++) {
			int n = (int)(Math.random()*2);
			if(n==0) quiz[i]='O';
			else quiz[i]='X';
		}
		
		char[] user = new char[10];
		int correct=0, wrong=0;
		for(int i=0;i<user.length;i++) {
			System.out.print((i+1)+"번째 O/X 입력:");
			user[i]=scan.next().charAt(0);
			if(!(user[i]=='O' || user[i]=='X')) {
				System.out.println("잘못된 입력입니다.");
				i--; //잘못된 입력 횟수를 세면 안되므로 증가된 수 다시 감소 시켜야 함
				continue; //입력하는 for문 다시 진행
			}
			if(user[i]==quiz[i])
				correct++;
			else wrong++;
		}
		System.out.println(Arrays.toString(quiz));
		System.out.println(Arrays.toString(user));
		System.out.println("정답 갯수:"+correct);
		System.out.println("오답 갯수:"+wrong);
		
		
		//알파벳 최대,최소 출력
		char[] alpha = new char[10];
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)(Math.random()*26+65);
		}
		System.out.println(Arrays.toString(alpha));
		char max = alpha[0];
		char min = alpha[0];
		for(char c:alpha) {
			if(c>max) max=c;
			else if(c<min) min=c;
		}
		System.out.println("MAX="+max);
		System.out.println("MIN="+min);
		
		
		//
		int[] com = new int[3];
		for(int i=0;i<com.length;i++) {
			com[i] = (int)(Math.random()*9)+1;
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		
		int[] user1 = new int[3];
		while(true) {
			System.out.print("세 자리 정수 입력:");
			int input1 = scan.nextInt();
			if(input1<100 || input1>999) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			user1[0]=input1/100; //100의 자리 수
			user1[1]=((input1%100)/10); //10의 자리 수
			user1[2]=input1%10; //1의 자리 수
			
			if(user1[0]==user1[1] || user1[1]==user1[2] || user1[0]==user1[2]) {
				System.out.println("같은 수는 사용할 수 없습니다.");
				continue;
			}
			if(user1[0]==0 || user1[1]==0 || user1[2]==0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			
			int st=0, ba=0;
			for(int i=0;i<3;i++) { //com
				for(int j=0;j<3;j++) { //user
					if(com[i]==user1[j]) {
						if(i==j) st++;
						else ba++;
					}
				}
			}
			System.out.printf("Input Number:%d, Result:%dS-%dB%n", input1,st,ba);
			
			if(st==3) {
				System.out.println("Game Over!!");
				break;
			}
		}
		
	}

}
