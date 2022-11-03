import java.util.Arrays;
import java.util.Scanner;

public class a {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=0, sum=0;
		while(true) {
			System.out.print(">>");
			num=scan.nextInt();
			if(num!=0) sum+=num;
			else break;
		}
		System.out.println("합계:"+sum);
		
		
		//
		for(int i=1;i<=100;i++) {
			System.out.print("i="+i);
			int tmp=i;
			do {
				if(tmp%10%3==0 && tmp%10!=0)
					System.out.print("짝");
			} while((tmp/=10)!=0);
			System.out.println();
		}
		

		int apple=123, basket=10;
		int su = (apple/basket)+((apple%basket)>0?1:0);
		
		
		//197p 5-7 랜덤 셔플
		int[] numArr = new int[10];
		for(int i=0;i<numArr.length;i++) {
			numArr[i]=i;
		}
		System.out.println("numArr="+Arrays.toString(numArr));
		for(int i=0;i<numArr.length;i++) {
			int n=(int)(Math.random()*10);
			int tmp=numArr[i];
			numArr[i]=numArr[n];
			numArr[n]=tmp;
		}
		System.out.println("numArr="+Arrays.toString(numArr));
		
		
		//
		int[] no = new int[10];
		for(int i=0;i<no.length;i++) {
			no[i] = (int)(Math.random()*10);
		}
		System.out.println(Arrays.toString(no));
		for(int i=0;i<no.length-1;i++) {
			
		}
		
	}

}
