import java.util.Arrays;

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
		
	}

}
