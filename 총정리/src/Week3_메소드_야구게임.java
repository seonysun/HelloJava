//Ch5 배열활용 숫자야구게임 이용
import java.util.Arrays;
import java.util.Scanner;

public class Week3_메소드_야구게임 {
	static int[] rand() {
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
		return com;
	}
	static int[] userInput() {
		Scanner scan = new Scanner(System.in);
		int[] user = new int[3];
		while(true) {
			System.out.print("세 자리 정수(100~999) 입력:");
			int input1 = scan.nextInt();
			if(!(input1>=100 && input1<=999)) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			user[0]=input1/100; //100의 자리 수
			user[1]=((input1%100)/10); //10의 자리 수
			user[2]=input1%10; //1의 자리 수
			
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2]) {
				System.out.println("같은 수는 사용할 수 없습니다.");
				continue;
			}
			if(user[0]==0 || user[1]==0 || user[2]==0) {
				System.out.println("0은 사용할 수 없습니다.");
				continue;
			}
			break;
		}
		return user;
	}
	static int compare(int[] com, int[] user) {
		int st=0, ba=0; //st: 같은 자리, ba: 다른 자리
		for(int i=0;i<3;i++) { //com
			for(int j=0;j<3;j++) { //user
				if(com[i]==user[j]) {
					if(i==j) st++;
					else ba++;
				}
			}
		}
		return st;
	}
	static void hint(int[] user, int st, int ba) {
		System.out.printf("Input Number:%d%d%d, Result:%dS-%dB%n", user[0],user[1],user[2],st,ba);
	}
	static boolean isEnd(int st) {
		if(st==3)
			return true;
		return false;
	}
	public static void main(String[] args) {
		int[] com=rand();
		System.out.println(Arrays.toString(com));
		while(true) {
			int[] user=userInput();
			int st=compare(com,user);
			if(isEnd(st)) {
				break;
			}
		}
	}

}
