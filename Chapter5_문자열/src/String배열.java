import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 문자열 배열 : 문자열 여러개를 저장할 수 있는 공간
 * 	- String[] 배열명 = new String[배열 갯수];
 * 		cf. String은 클래스이므로 배열요소도 주소값(int, 4byte)을 저장(객체 배열)(일반 변수의 배열요소는 데이터값을 직접 저장)
 * 				-> 초기값이 ""(공백)이 아닌 null(주소가 없는 상태, 선언만 된 상태)
 * 				-> 실제 입력값은 따로 저장됨
 * 	- String[] 배열명 = {초기값};
 * */

public class String배열 {

	public static void main(String[] args) {
		System.out.println("홍길동".length());
						 //문자열 자체로 변수처럼 사용 가능
		
		String[] names = {"홍길동","이순신","강감찬","박문수","김두한"};
		for(int i=0;i<names.length;i++)
			System.out.print(names[i]+" ");
		System.out.println();
		for(String i:names)
			System.out.print(i+" ");
		System.out.println();
		System.out.println(Arrays.toString(names));
		
		
		//
		String[] books = {
				"Java And Oracle",
				"Java And JSP",
				"HTML5 & CSS3",
				"Spring & VueJS",
				"SpringBoot & ReactJS",
				"JPA와 Java",
				"MyBatis & Java",
				"혼자 배우는 자바",
				"Java의 정석"
		};
		System.out.println("===== 전체 출력 =====");
		for(int i=0;i<books.length;i++)
			System.out.println(i+1+"."+books[i]);
		System.out.println("==================");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd = scan.next();
		for(String i:books) {
			if(i.contains(fd)) System.out.println(i);
						//검색어
		}
		System.out.println("===== startsWith =====");
		for(String i:books) {
			if(i.startsWith(fd)) System.out.println(i);
		}
		System.out.println("===== endsWith =====");
		for(String i:books) {
			if(i.endsWith(fd)) System.out.println(i);
		}
		
	}

}
