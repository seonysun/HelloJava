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
	public static void main(String[] args) {
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		sort(arr);		
		
	}

}
