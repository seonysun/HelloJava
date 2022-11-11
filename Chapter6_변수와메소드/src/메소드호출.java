import java.util.Arrays;

/* 
 * - JVM 메모리구조
 * Method area -> static(변수, method)
 * Stack : 메모리 자체 관리; {}이 종료되면 사라짐 -> 지역변수, 매개변수 (메소드 영역에 선언되는 것)
 * Heap : 프로그래머 관리; 프로그램 종료시까지 유지, 사용하지 않거나 null이면 회수 -> 인스턴스변수(클래스 영역에 선언되는 것), 배열
 * */

public class 메소드호출 {
	int[] rand(int no) {
		int[] com=new int[no];
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		return com;
	}
	void rand(int[] com) {
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*45)+1;
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
	}
	
	void first() {
		System.out.println("-first() 진입");
		second();
		System.out.println("-first() 종료");
	}
	void second() {
		System.out.println("--second() 진입");
		last();
		System.out.println("--second() 종료");
	}
	void last() {
		System.out.println("---last() 진입");
		System.out.println("---last() 종료");
	}
	public static void main(String[] args) {
		/*
		int[] arr= {1,2,3,4,5};
		int[] tmp=arr; //배열은 참조변수이므로 tmp와 arr은 동일한 1개의 배열
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(tmp));
		tmp[0]=100;
		tmp[1]=200;
		tmp[2]=300;
		tmp[3]=400;
		tmp[4]=500;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(tmp));
		*/
		
		메소드호출 m=new 메소드호출();
		
		int[] arr=m.rand(7); //결과값으로 int 배열 생성됨 -> 참조변수명 arr로 정해서 저장
		System.out.println(Arrays.toString(arr));
		
		int[] arr1=new int[10];
		m.rand(arr1); //매개변수로 int 배열이 필요 -> 미리 생성 후 참조변수 제시
		System.out.println(Arrays.toString(arr1));
		
		
		// 메소드 호출 순서
		System.out.println("main() 진입");
		System.out.println("m 메모리 제작: "+m);
		m.first();
		System.out.println("main() 종료");
		
	}

}
