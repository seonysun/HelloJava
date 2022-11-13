import java.util.Arrays;
import java.util.Scanner;

//245p 사용자 정의 타입 클래스
class Time{
	int hour;
	int minute;
	float second;
	void setHour(int hour) {
		if(hour<0 || hour>23) return;
		this.hour=hour;
	}
	int getHour() {
		return hour;
	}
}
//306p 
class Product{
	static int pno; //모든 객체가 공유하는 변수는 static으로 설정
	{ //객체가 생성될 때마다 static 변수의 설정값 변화되도록 블록 설정
		pno+=1;
	}
	void print(){
		System.out.println("no."+pno);
	}
}
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
		
		//
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
		
		//
		Product p1=new Product();
		p1.print();
		Product p2=new Product();
		p2.print();
		Product p3=new Product();
		p3.print();
		
	}

}
