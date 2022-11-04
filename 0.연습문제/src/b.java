import java.util.Arrays;
import java.util.Scanner;

/*
 * 형상관리 : 깃(협업)
 */
public class b {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int year=(int)(Math.random()*23)+2000;
		int month=(int)(Math.random()*12)+1;
		
		char[] strWeek= {'일','월','화','수','목','금','토'};
		for(char c:strWeek)
			System.out.print(c+"\t");
		
		int[] monthDay= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%4==0 && year%100!=0 || year%400==0)
			monthDay[1]=29;
		
		int day=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;

		int week = day%7;

		int i;
		for(i=0;i<month-1;i++)
			day+=monthDay[i];
		day++;
		System.out.println();
		for(i=0;i<=monthDay[month-1];i++) {
			if(i==1) {
				for(int j=0;j<week;j++)
					System.out.println();
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
		}
		System.out.println();
	}

}
