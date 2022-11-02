import java.util.Arrays;

/*
 * 1) 배열의 복사
 * 	- 배열의 길이는 상수이므로 변경 불가 
 * 		-> 배열의 길이 변경하기 위해서는 길이 더 큰 새로운 배열 생성하여 기존 값 복사
 * 	- 복사 방법
 * 		- System.arraycopy; : 배열의 크기가 다른 경우, 원하는 위치에 데이터 배치하고자 할 경우
 *		- .clone(); : 있는 그대로 복사
 *		- for문으로 직접 초기화
 *	- 기본 변수 -> Call by Value
 *    참조 변수 -> Call by Reference(주소에 의한 참조) : 배열은 참조 변수
 *   	=> 복사하는 방법이 서로 다름
 * */

public class 배열복사 {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int[] copy = arr;
			//배열은 참조변수 -> 기본변수와 달리 주소를 가져오는 것이므로 arr과 copy가 동일한 메모리 공간을 가짐 -> 동일한 배열이 됨
		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("copy="+Arrays.toString(copy));
		
		copy[0]=100;
		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("copy="+Arrays.toString(copy));
		System.out.println();
	
		
		int[] arr1 = {10,20,30,40,50};
		int[] copy1 = new int[arr1.length];
					//새롭게 베열 생성되었으므로 arr과 copy는 서로 다른 배열
		for(int i=0;i<arr1.length;i++)
			copy1[i]=arr1[i];
			//메모리 공간은 다르고 데이터값만 복사
		System.out.println("arr1="+Arrays.toString(arr1));
		System.out.println("copy1="+Arrays.toString(copy1));
		
		copy1[0]=100;
		System.out.println("arr1="+Arrays.toString(arr1));
		System.out.println("copy1="+Arrays.toString(copy1));
		System.out.println();
		
		
		int[] arr2 = {100,200,300,400,500};
		int[] copy2 = new int[arr2.length*2];
		System.arraycopy(arr2, 0, copy2, 3, 2);
						//arr2의 0번째 인덱스부터 복사하여 copy2의 3번째(실제 4번째) 인덱스부터 2개 인덱스 복사
		System.out.println("arr2="+Arrays.toString(arr2));
		System.out.println("copy2="+Arrays.toString(copy2));
		System.out.println();
		
		
		char[] arr3 = {'A','B','C','D','E'};
		char[] copy3 = new char[arr3.length];
		//System.arraycopy(arr3, 0, copy3, 0, arr3.length);
		copy3=arr3.clone();
		System.out.println("arr3="+Arrays.toString(arr3));
		System.out.println("copy3="+Arrays.toString(copy3));
		System.out.println();
		
 	}

}
