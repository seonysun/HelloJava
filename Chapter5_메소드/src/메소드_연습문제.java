import java.util.Arrays;
import java.util.Scanner;

public class 메소드_연습문제 {
	static void binary() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력:");
		int a=scan.nextInt();
		
		int[] arr = new int[16];
		int index=15;
		
		while(true) {
			arr[index]=a%2;
			a/=2;
			if(a==0) break;
			index--;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	static void binary2() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력:");
		int a=scan.nextInt();
		
		String result="";
		
		while(true) {
			if(a%2==0) result+=0;
			else result+=1;
			a/=2;
			if(a==0) break;
		}
		char[] c=result.toCharArray();
		for(int i=c.length-1;i>=0;i--) {
			System.out.print(c[i]+"");
		}
		System.out.println();
	}
	
	static void sort() {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력(1~10):");
		int a = scan.nextInt();
		int[] arr = new int[a];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
		}
		
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
	}
	
	static int[] asc_sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		return arr;
	}
	static int[] desc_sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		return arr;
	}
	static int[] sortAll(int[] arr, String type) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(type.equals("ASC")) {
					if(arr[i]>arr[j]) {
						int tmp=arr[i];
						arr[i]=arr[j];
						arr[j]=tmp;
					}
				}
				else if(type.equals("DESC")){
					if(arr[i]<arr[j]) {
						int tmp=arr[i];
						arr[i]=arr[j];
						arr[j]=tmp;
					}
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		binary();
		binary2();
		System.out.println();
		
		
		sort();
		System.out.println();
		
		
		int[] num = new int[5];
		for(int i=0;i<num.length;i++) {
			num[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(num));
		
		System.out.println("오름차순:");
		int[] num1 = asc_sort(num);
		System.out.println(Arrays.toString(num1));
		/* 
		int[] num3 = sortAll(num, "ASC");
		System.out.println(Arrays.toString(num3));
		 */
		
		System.out.println("내림차순:");
		int[] num2 = desc_sort(num);
		System.out.println(Arrays.toString(num2));
		/*
		int[] num4 = sortAll(num, "DESC");
		System.out.println(Arrays.toString(num4));
		 */
		
	}

}
