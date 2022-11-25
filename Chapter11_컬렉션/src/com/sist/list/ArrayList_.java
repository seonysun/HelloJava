package com.sist.list;
import java.util.*;

/*
//컴포넌트 : 기능 갖는 클래스 
//	-> java : CBD(Component Based Developer) 이미 만들어진 라이브러리 조립하여 프로그래밍
//컨테이너 : 메인 클래스(조립기)
//형상관리 : 깃, 협업
 * 
 * 0. 오라클의 데이터형
 * 	- 문자열 String
 * 	- 숫자형 Integer, Double
 * 	- 날짜형 Date, Calendar
 * 
 * 1. 컬렉션(**)
 * 	- 데이터 모아서 관리(저장)
 * 		-> 배열은 크기 확장이 어려움(고정적) 
 * 		-> 크기 정해지지 않은 가변형의 데이터 그룹 => 컬렉션
 * 	- 모든 데이터형 등록 가능(Object) -> 형변환 통해 하나로 통일(제네릭스)
 * 	- 컬렉션 프레임워크 -> 컬렉션들이 표준화된 방식으로 다뤄짐
 *	- 종류 
 * 						Collection
 * 				  ┌──────────┴───────────┐
 * 				 List 				    Set 			   Map
 * 			  ------------------------------------------------- (인터페이스)
 * 		┌─────────┼─────────┐	     ┌───┴───┐	  		┌───┴───┐
 * 	ArrayList 	Vector 	  Queue	  HashSet TreeSet 	Hashtable HashMap
 * 	   (*)				    |									(*)
 * 					    LinkedList
 * 
 * 	- 용도 -> 데이터 수집 : ArrayList, 데이터 전송 : Map, 데이터 중복 제거 : Set
 * 
 * 		1) List -> 대기자명단, DB
 *		 	- 순서 가짐(배열 형식 -> 인덱스), 인덱스번호 순차적으로 자동생성(삭제, 추가 시 순차 이동)
 * 			- 저장된 데이터 중복 허용
 * 			- 구현된 클래스
 * 				- ArrayList(*) : 비동기화 -> DB의 데이터 모아서 브라우저에 전송
 * 					cf. 메모리 크고 메모리 누수현상 있지만 가장 간단하고 출력 속도 빨라서 주로 사용
 * 				- Vector : 동기화 -> 서버 개발(네트워크)
 * 				- LinkedList : C언어 호환
 * 					- 인덱스 통한 단순 배열 형식이 아니라 다음 주소값(없으면 null)과 실제 데이터값을 함께 저장 
 * 						-> 메모리 크고 데이터에 대한 접근성이 낮음
 * 					cf. 속도비교
 * 						- 데이터 읽기는 ArrayList가 빠름
 * 							-> 웹은 DB 읽어오는 과정이 많으므로 ArrayList 위주
 * 					  	- 데이터 수정, 삭제 많을 때는 LinkedList가 빠름(인덱스 번호 수정 불필요)
 * 							-> 앱은 프로그램 자체에서 처리하는 과정이 많으므로 LinkedList 위주
 * 				------------------------------------------------------------------------ 메소드 동일
 * 				- Stack : LIFO(후입선출) -> 메모리, 메소드 호출
 * 				- Queue : FIFO(선입선출) -> 네트워크, 운영체제 스케줄러
 * 
 * 			- 주요메소드 
 * 				cf. 데이터 관리 인터페이스 
 * 					-> 자료구조 CURD : Create, Update, Read, Delete
 * 									(추가 INSERT, 수정 UPDATE, 삭제 DELETE, 검색 SELECT)
 * 				- void add(Object o) : 데이터 추가
 * 				- void set(int index, Object o) : 데이터 수정
 * 				- Object get(int index) : 데이터 읽기
 * 				- int size() : 저장된 갯수 확인
 * 				- void remove(int index) : 데이터 삭제
 * 				- void clear() : 전체 삭제
 * 				- boolean isEmpty() : 데이터 존재 여부 확인 
 * 
 * 				- removeAll() : 차집합(공통되지 않은 요소) -> (오라클) MINUS
 * 				- addAll() : 합집합(전체, 교집합 중복 제거) -> (오라클) UNION(중복제거)/UNIONALL(중복유지)
 * 				- retainAll() : 교집합(공통된 요소) -> (오라클) INTERSECT
 * 				- iterator() : 데이터 모아서 한번에 관리 
 * */

public class ArrayList_ {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
				//제네릭스 -> Object형 한번에 데이터형 바꿀 수 있음(wrapper 클래스형으로 바꿔야 함)
		//add
		list.add("홍길동"); //인덱스 0 -> 순차 저장
		list.add("심청이"); //1 
		list.add("이순신"); //3 -> 인덱스 2번 지정되었으므로 밀려서 3번
		list.add("강감찬"); //4
		list.add(2, "을지문덕"); //인덱스번호 지정 2
		for(int i=0;i<list.size();i++) { //인덱스 순차적으로 빈칸없이 채워지므로 for문 가능
					//저장된 갯수
			String name=list.get(i).toString();
						//제네릭스 설정하지 않았을 때 : get() 메소드의 리턴형 Object -> 형변환 필요
			System.out.println(i+". "+name);
		}
		
		//set
		list.set(2, "박문수");
		System.out.println(list);
		
		//remove
		list.remove(3);
		System.out.println(list);
		
		//clear, isEmpty
		list.clear();
		if(list.isEmpty())
			System.out.println("저장된 데이터가 없습니다.\n");
		
		//sort
		ArrayList list1=new ArrayList();
		list1.add(7);
		list1.add(4);
		list1.add(3);
		list1.add(6);
		list1.add(2);
		list1.add(5);
		list1.add(1);
		Collections.sort(list1);
		for(Object i:list1) { //forEach문은 데이터형 반드시 일치해야 함
			System.out.print(i+" ");
		}
		System.out.println();

		//copy
		ArrayList list2=new ArrayList(list1.subList(1,5));
											//원하는 부분만(인덱스 1~5 전까지) 자르기
		for(Object i:list2) {
			System.out.print(i+" ");
		}
		System.out.println("\n");
		
		//출력방식
		ArrayList list3=new ArrayList();
		list3.add("포도");
		list3.add("사과");
		list3.add("바나나");
		list3.add("수박");
		list3.add("배");
			//람다식(함수포인터) -> 사용 빈도 적음
		list3.forEach((obj)->System.out.print(obj+" "));
		System.out.println("\n");
		
		//비교
		ArrayList list4=new ArrayList();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(4);
		list4.add(5);
		list4.add(6);
		list4.add(7);
		System.out.println("list4:"+list4);
		ArrayList list5=new ArrayList();
		list5.add(1);
		list5.add(2);
		list5.add(3);
		list5.add(4);
		list5.add('A');
		list5.add('B');
		list5.add('C');
		System.out.println("list5:"+list5);
			//containsAll 포함여부 확인
		System.out.println("4 contains 5:"+list4.containsAll(list5));
			//retainAll 교집합만 유지, 나머지 제거
		list4.retainAll(list5); 
		System.out.println("list4:"+list4);
		System.out.println("list5:"+list5);
		
	}

}
