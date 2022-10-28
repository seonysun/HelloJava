import java.util.Scanner;

public class 제어문_연습문제 {

	public static void main(String[] args) {
		//문제 8. 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
		int total=0;
		for(int i=2;i<=100;i+=2) {
			total+=i;
		}
		System.out.println("1부터 100까지 짝수 합: "+total);
		
		
		//문제 9. 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
		for(int i=5;i<=50;i+=5) {
			System.out.print(i+" ");
		}
		System.out.println();

		
		//문제 10. B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
		for(char i='B';i<='N';i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		//문제 11. 한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라
		int n = (int)(Math.random()*100)+1;
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		System.out.println("1~"+n+"까지의 합:"+sum);
		
		
		//문제 12. 1부터 30까지의 정수에서 짝수만 한 줄에 4개씩 출력하라
		for(int i=1;i<=30;i++) {
			if(i%2==0) {
				System.out.printf("%3d",i);
				if(i%8==0)
					System.out.println(); //3의 배수에서 줄바꿈
			}
		}
		System.out.println();
		
		
		//문제 13. 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 
		int a=0;
		for(int i=1;i<=10;i++) {
			if(i%2!=0) a+=i;
			else a-=i;
		}
		System.out.println("1-2+3-4+5-6+7-8+9-10:"+a);
		
		
		//문제 14. 1~10 사이의 숫자 중 3의 배수를 제외하고 출력하라 (continue 사용)
		for(int i=1;i<=10;i++) {
			if(i%3==0) 
				continue; //제외하고 나머지 출력
			System.out.printf("%4d",i);
		}
		System.out.println();
		
		
		//문제 15. Scanner 클래스를 이용하여 2자리의 정수(10~99사이)를 입력받고, 십의 자리와 1의 자리가 같은 지 판별하여 출력하는 프로그램을 작성하라.
		int num = (int)(Math.random()*90)+10;
		System.out.print(num+"은(는) ");
		if(num/10 == num%10) 
			//십의 자리  //일의 자리
			System.out.println("십의 자리와 일의 자리가 같습니다.");
			else 
				System.out.println("십의 자리와 일의 자리가 같지 않습니다.");
		
		
		//문제 16. 숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울, 그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라. if-else 문과 switch 둘 다 이용해 볼 것.
		Scanner scan = new Scanner(System.in);
		System.out.print("월(1~12)을 입력하세요 >>");
		int month = scan.nextInt();
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println(month+"월은 봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println(month+"월은 여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println(month+"월은 가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println(month+"월은 겨울입니다.");
			break;
		default:
			 System.out.println("잘못 입력하셨습니다.");
		}
		
		/*
		if(!(month>=1 && month<=12)) 
			System.out.println("잘못 입력하셨습니다.");
		else if(month>=3 && month<=5) System.out.println("봄");
		else if(month>=6 && month<=8) System.out.println("여름");
		else if(month>=9 && month<=11) System.out.println("가을");
		else System.out.println("겨울");
		*/
		
	}

}
