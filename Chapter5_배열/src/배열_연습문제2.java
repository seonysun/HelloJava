import java.util.Arrays;

public class 배열_연습문제2 {

	public static void main(String[] args) {
		//문제 1.
		int[] score = {100, 90, 85};
		for(int i=0;i<score.length;i++) {
			System.out.println((i+1)+"번 학생:"+score[i]+"점");
		}
		int sum=0;
		for(int i:score) {
			sum+=i;
		}
		System.out.println("총점:"+sum);
		System.out.println();
		
		
		//문제 2. 
		int[] result = {50,45,35,12,70};
		for(int i=0;i<result.length;i++)
			System.out.println("사원("+(i+1)+")"+result[i]);
		sum=0;
		for(int i:result)
			sum+=i;
		System.out.printf("1월 실적> 총점:%d, 평균:%.2f%n", sum,(double)sum/result.length);
		int max=result[0], min=result[0];
		for(int i:result) {
			if(i>max) max=i;
			else if(i<min) min=i;
		}
		for(int i=0;i<result.length;i++) {
			if(result[i]==max) System.out.printf("최고 실적: 사원(%d), %d%n", i+1,max);
			else if(result[i]==min) System.out.printf("최저 실적: 사원(%d), %d%n", i+1,min);
		}
		System.out.println();
		
		
		//문제 3.
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		
		//문제 5.
		int[] arr1 = new int[10];
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=(int)(Math.random()*100)+1;
		}
		int evenTotal=0, oddTotal=0;
		for(int i:arr1) {
			if(i%2==0) evenTotal+=i;
			else oddTotal+=i;
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println("짝수의 합:"+evenTotal);
		System.out.println("홀수의 합:"+oddTotal);
		System.out.println();
		
		
		//문제 6.
		int[] arr2 = new int[100];
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=(int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(arr2));
		int[] count = new int[10];
		for(int i=0;i<arr2.length;i++)
			count[arr2[i]]++;
		for(int i=0;i<count.length;i++)
			System.out.println(i+"의 개수:"+count[i]);
		System.out.println();
		
		
		//문제 7.
		char[] alpha = new char[5];
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)(Math.random()*26+65);
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(alpha));
		
		for(int i=0;i<alpha.length-1;i++) {
			for(int j=0;j<alpha.length-1-i;j++) {
				if(alpha[j]<alpha[j+1]) {
					char tmp = alpha[j];
					alpha[j]=alpha[j+1];
					alpha[j+1]=tmp;
				}
			}
		}
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(alpha));
		
	}

}
