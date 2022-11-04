import java.util.Scanner;

public class Week3_메소드 {
	//문제 1.
	static void print(int a, int b) {
		for(int i=a;i<=b;i++)
			System.out.print(i+" ");
		System.out.println();
	}
	//문제 2.
	static int sum(int a, int b) {
		int sum=0;
		for(int i=a;i<=b;i++) {
			sum+=i;
		}
		return sum;
	}
	//문제 3.
	static int total(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
	//문제 4.
	static String div(int a, int b) {
		String result="";
		if(b==0) result="0으로 나눌 수 없습니다.";
		else result=String.valueOf(a/(double)b); //결과값을 실수->문자열로 변경
		return result;
	}
	//문제 5.
	static String change(String a) {
		return a.toUpperCase();
	}
	//문제 6.
	static boolean symm(String s) {
		boolean result=true;
		for(int i=0;i<s.length()/2;i++) {
			int last=s.length()-1-i;
			if(s.charAt(i)!=s.charAt(last)) {
				result=false;
			}
		}
		return result;
	}
	//문제 7.
	static void rev(String s) {
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	//문제 9.
	static boolean year(int y) {
		boolean result=false;
		if(y%4==0 && y%100!=0 || y%400==0)
			result=true;
		return result;
	}
	//문제 10.
	static int max(int a, int b) {
		int max=a;
		if(a<b) max=b;
		return max;
		// return a<b?b:a;
	}
	//문제 11.
	static String evenodd(int a) {
		if(a%2==0)
			return a+"는 짝수";
		return a+"는 홀수";
	}
	//문제 12.
	static boolean tripp(int a) {
		boolean result=false;
		if(a%3==0 && a!=0)
			result=true;
		return result;
	}
	//문제 14.
	static void revnum(int num) {
		String s=String.valueOf(num);
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String[] args) {
		//문제 1.
		print(1,10);
				
		//문제 2.
		System.out.println(sum(1,10));
				
		//문제 3.
		System.out.println(total(10));
				
		//문제 4.
		int a=(int)(Math.random()*100)+1;
		int b=(int)(Math.random()*100)+1;
		String result=div(a, b);
		System.out.println("a:"+a+" b:"+b);
		System.out.println("-> "+result);
		
		//문제 5.
		System.out.println(change("hi"));
				
		//문제 6.
		System.out.println(symm("tfhgj"));		
		
		//문제 9.
		boolean y=year(2022);
		if(y==true)
			System.out.println("윤년입니다.");
		else System.out.println("윤년이 아닙니다.");
				
		//문제 10.
		max(3,53);
		
		//문제 11.
		String ans=evenodd(23849);
		System.out.println(ans);

		//문제 12.
		boolean tripp=tripp(23841);
		System.out.println(tripp);
		
		//문제 14.
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		revnum(num);
	}

}
