import java.util.Arrays;
import java.util.Scanner;

public class 배열_연습문제 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//문제 4. 양의 정수 10개 입력받아 배열에 저장, 3의 배수만 출력
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*1000)+1;
		}
		System.out.println("arr="+Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
			if(arr[i]%3==0 && arr[i]!=0) 
				System.out.print(arr[i]+" ");
		System.out.println();
		/*
		for(int i:arr)
			if(i%3==0 && i!=0) System.out.print(i+" ");
		*/
		
		
		//문제 5. 정수 10개 저장하는 배열, 1~10 난수 추출, 배열의 숫자들과 평균 출력
		int sum=0;
		int[] arr1 = new int[10];
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=(int)(Math.random()*10)+1;
			sum+=arr1[i];
		}
		System.out.println("arr1="+Arrays.toString(arr1));
		System.out.println("평균:"+sum/(double)arr1.length);
		
		
		//문제 6. 배열의 최댓값, 최솟값을 출력하는 프로그램 작성
		int[] num = {94,85,95,88,90};
		int max=num[0], min=num[0];
		for(int i=0;i<num.length;i++) {
			if(num[i]>max) max=num[i];
			if(num[i]<min) min=num[i];
		}
		System.out.println("MAX="+max);
		System.out.println("MIN="+min);
		
		
		//문제 8. 인덱스 1인 곳의 값 출력
		int[] arr2 = {10,20,30,50,3,60,-3};
		System.out.println(arr2[1]);
		
		
		//문제 9. 값이 60인 곳의 인덱스 출력
		int i=0;
		while(i<arr2.length) {
			if(arr2[i]==60) {
				System.out.println("값이 60인 곳:"+i);
				break;
			}
			i++;
		}
		
		
		//달력만들기
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("월 입력:");
		int month=scan.nextInt();
		System.out.println(year+"년 "+month+"월\n");
		
		int[] lastday={31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%4==0 && year%100!=0 || year%400==0)
			lastday[1]=29;
			//매월의 마지막날 -> 윤년 여부에 따라 2월은 달라짐

		int total=0;
		for(i=1;i<year;i++){
			total+=365;
			if(year%4==0 && year%100!=0 || year%400==0)
				total++;
		}
			//전년도까지의 일수 -> 기본 365일, 윤년 조절(4년에 한번 +1, 100년에 한번 -1, 400년에 한번 +1)
		//int total=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		
		for(i=0;i<month-1;i++)
			total+=lastday[i];
			//전달까지의 일수
		
		total++;
		int week=total%7;
			//해당달 1일의 요일
		
		char[] strWeek={'일','월','화','수','목','금','토'};
		for(char c:strWeek)
			System.out.print(c+"\t");
		System.out.println();

		for(int j=0;j<week;j++)
			System.out.print("\t");
			//1일의 요일 시작 전 공백
		for(i=1;i<=lastday[month-1];i++) {
			System.out.printf("%2d\t",i); //날짜 쭉 출력하는데
			week++; //요일 1개씩 증가
			if(week>6) { //7일이 되면 줄바꾸고 초기화
				week=0;
				System.out.println();
			}
		}
		System.out.println();
		
	}

}
