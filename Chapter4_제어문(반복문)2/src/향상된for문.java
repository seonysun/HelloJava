/*
 * 2) 향상된 for문(forEach)
 * 	- 하나의 배열에 저장된 실제 데이터값을 출력 
 * 		-> 미리 저장된 데이터 존재할 때만 사용 가능
 * 		-> 여러개의 배열에 저장된 데이터 출력할 때는 일반 for문 사용
 * 	- 데이터 모두 출력되면 자동으로 종료
 * 	- 웹에서 많이 사용
 * 	- for(데이터형 변수명 : 배열/컬렉션명)
 * 		-> 데이터형은 배열/컬렉션의 타입(크기가 같거나 큰 실제 데이터형 받아올 수 있음)
 * 	- 배열에 저장된 데이터값을 읽어오는 것이므로 값 변경 등은 불가
 * */

public class 향상된for문 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for(int i=0;i<5;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		/* for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ")
		}
		 */

	}

}
