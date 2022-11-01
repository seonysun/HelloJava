import java.util.Arrays;

public class 배열정렬 {
	
	public static void main(String[] args) {
		//select sort 순차적으로 하나씩 선택해서 나머지 모두와 비교 -> 맨 앞부터 고정
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
		
		for(int i=0;i<arr.length-1;i++) { //마지막 배열 요소는 앞에서 이미 비교했으므로 중복되어 제외
			for(int j=i+1;j<arr.length;j++) { //이전 배열 요소는 이미 비교 완료이고 각 배열 요소를 스스로 비교할 필요는 없으므로 i+1부터 시작
				if(arr[i]>arr[j]) { //i번째가 j번째보다 크면 둘 교환
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
			//실제 코딩에서는 Arrays.sort(arr); 사용
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		
		char[] arr2 = new char[10];
		for(int i=0;i<arr2.length;i++) {
			arr2[i] = (char)((Math.random()*26)+65);
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr2));
		
		for(int i=0;i<arr2.length-1;i++) {
			for(int j=i+1;j<arr2.length;j++) {
				if(arr2[i]<arr2[j]) {
					char tmp = arr2[i];
					arr2[i] = arr2[j];
					arr2[j] = tmp;
				}
			}
		}
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr2));
		System.out.println();
		
		
		//bubble sort 인접한 요소들끼리 각각 비교 -> 맨 뒤부터 고정
		int[] arr1 = new int[5];
		for(int i=0;i<arr1.length;i++) {
			arr1[i] = (int)(Math.random()*100);
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr1));
		
		for(int i=0;i<arr1.length-1;i++) {
			for(int j=0;j<arr1.length-1-i;j++) {
					if(arr1[j]>arr1[j+1]) {
						int temp = arr1[j];
						arr1[j] = arr1[j+1];
						arr1[j+1] = temp;
					}
			}
		}
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr1));
		System.out.println();
		
		
		char[] arr3 = new char[10];
		for(int i=0;i<arr3.length;i++) {
			arr3[i] = (char)((Math.random()*26)+65);
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr3));
		
		for(int i=0;i<arr3.length-1;i++) {
			for(int j=0;j<arr3.length-1-i;j++) {
				if(arr3[j]>arr3[j+1]) {
					char tmp = arr3[j];
					arr3[j] = arr3[j+1];
					arr3[j+1] = tmp;
				}
			}
		}
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr3));
		System.out.println();
		
	}

}
