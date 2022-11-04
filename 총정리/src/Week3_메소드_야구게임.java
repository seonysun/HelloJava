//Ch5 배열활용 숫자야구게임 이용
import java.util.Arrays;
import java.util.Scanner;

public class Week3_메소드_야구게임 {
	//난수발생
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
	//사용자입력
	static int[] userInput() {
		Scanner scan = new Scanner(System.in);
		int[] user = new int[3];
		while(true) {
			System.out.print("세 자리 정수(100~999) 입력:");
			int input = scan.nextInt();
			if(!(input>=100 && input<=999)) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			user[0]=input/100; //100의 자리 수
			user[1]=((input%100)/10); //10의 자리 수
			user[2]=input%10; //1의 자리 수
			
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
	//비교, 힌트
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
		System.out.printf("Input Number:%d%d%d, Result:%dS-%dB%n", user[0],user[1],user[2],st,ba);
		return st;
	}
	//종료여부
	static boolean isEnd(int st) {
		if(st==3)
			return true;
		return false;
	}
	//전체 게임 통합
	static void process() {
		int[] com=rand();
		while(true) {
			int[] user=userInput();
			if(isEnd(compare(com,user))) {
				System.out.println("정답입니다!");
				Scanner scan = new Scanner(System.in);
				System.out.print("게임을 다시 시작할까요?(Y/N)");
				String yn=scan.next();
				if(yn.equalsIgnoreCase("Y")) {
					System.out.println("새 게임을 시작합니다.");
					process(); //재귀함수
				} else {
					System.out.println("Game Over!!");
					System.exit(0);
				}
			}
		}
	}
	public static void main(String[] args) {
		process();
		
	}

}
