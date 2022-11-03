import java.util.Arrays;
import java.util.Scanner;

public class 메소드_정렬 {
	static void sort(int[] arr) {
		Arrays.sort(arr);
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println("\n=============");
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}
	static void gugudan() {
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++)
				System.out.printf("%d*%d=%d\t",j,i,j*i);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		sort(arr);		
		System.out.println();
		
		gugudan();
		
	}

}
