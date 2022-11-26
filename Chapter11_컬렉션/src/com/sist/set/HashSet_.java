package com.sist.set;
import java.util.*;

/*
 * 2) Set -> 접속자 정보, 장바구니, 양의 정수 집합
 * 		- 순서 없음 -> forEach로 출력
 * 		- 저장된 데이터 중복 불가 -> List의 데이터 중복 없이 추출할 때(분야별로 분류), MAP의 데이터 읽을 때 사용
 * 		- 구현된 클래스
 * 			- TreeSet : 검색
 * 			- HashSet(*) : 중복 데이터 제거 -> (DB) DISTINCT
 * 		- 주요메소드 
 * 			-> List, Set은 모두 Collection 상속받은 인터페이스
 * 			-> 메소드 거의 동일
 * 				cf. 수정(set) 불가 -> 순서(인덱스)가 없으므로 지정할 수 없음
 * 			- headSet() : 범위 설정(매개변수까지), TreeSet만 사용 가능
 * 			- tailSet() : 범위 설정(매개변수부터), TreeSet만 사용 가능
 * */

class Person implements Cloneable{
						//clone() 메소드 사용하기 위함
	String name;
	int age;
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String toString() { 
				//객체 출력 시 자동으로 toString() 추가되어 주소값이 문자열로 출력
		return name+":"+age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
public class HashSet_ {

	public static void main(String[] args) throws Exception {
		String[] names= {"홍길동","심청이","박문수","이순신","강감찬","손흥민","박지성","김민재","홍길동","박문수"};
		Set set=new HashSet();
					//Set은 인터페이스이므로 구현 클래스로 받음
		//출력
			//for문
		for(String name:names) {
			set.add(name); //데이터 추가 과정에서 자동으로 중복 제거
		}
		System.out.println(set);
			//배열 -> list 변환 후 list -> set 복사
		List list=Arrays.asList(names);
		set.addAll(list);
		System.out.println(set);
		
		//삭제
		set.remove("박문수");
		System.out.println(set);
		
		set.clear();
		if(set.isEmpty())
			System.out.println("데이터 없음:"+set.size());
		System.out.println();
		
		//로또번호 추출
		for(;;) { //반복 횟수를 숫자로 주면 중복이 있을 때 삭제되고 저장되므로 횟수보다 적은 수의 숫자가 채워질 수 있음
			int r=(int)(Math.random()*45)+1;
			set.add(r);
			if(set.size()==6) break;
		}
		list=new ArrayList(set);
		Collections.sort(list); //HashSet은 sort 불가 -> list 변환 후 진행
		System.out.println(list);
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("\n");
		
		//참조변수 중복
		Set set1=new HashSet();
		set1.add("ABC"); //기본형은 리터럴 사용 -> 바로 중복 제거 가능
		set1.add("ABC");
		Person p1=new Person("홍길동",25);
		Person p2=new Person("홍길동",25); //매개변수 같지만 서로 다른 객체
		set1.add(p1); 
		set1.add(p2); //중복 제거 불가
		Person p3=p1; //동일 주소 참조
		set1.add(p3); //중복 제거
		Person p4=(Person)p1.clone(); //새로운 주소 참조
		set1.add(p4); //중복 제거 불가
		System.out.println(set1);
		System.out.println();
		
		//교집합, 차집합, 합집합
		Set set2=new HashSet();
		set2.add("A");
		set2.add("B");
		set2.add("C");
		set2.add("D");
		set2.add("E");
		set2.add("F");
		set2.add("G");
		
		Set set3=new HashSet();
		set3.add("L");
		set3.add("M");
		set3.add("N");
		set3.add("D");
		set3.add("E");
		set3.add("O");
		set3.add("P");
		
		System.out.println("set2="+set2);
		System.out.println("set3="+set3);
//		set2.retainAll(set3);
		System.out.println("교집합"+set2);
		set2.removeAll(set3);
		System.out.println("차집합"+set2);
		set2.addAll(set3);
		System.out.println("합집합"+set2);

	}

}
