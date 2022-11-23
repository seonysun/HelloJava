import java.util.*;

/*
 * 0. 오라클의 데이터형
 * 	- 문자열 String
 * 	- 숫자형 Integer, Double
 * 	- 날짜형 Date, Calendar
 * 
 * 1. 컬렉션(**)
 * 	- 데이터 모아서 관리
 * 		-> 배열은 크기 확장이 어려움(고정적) 
 * 		-> 크기 정해지지 않은 가변형의 데이터 그룹 => 컬렉션
 * 	- 모든 데이터형 등록 가능 -> 형변환 통해 하나로 통일(제네릭스)
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
 * 		1) List -> 대기자명단
 *		 	- 순서 가짐(배열 형식 -> 인덱스), 인덱스번호 순차적으로 자동생성(삭제, 추가 시 순차 이동)
 * 			- 저장된 데이터 중복 가능
 * 			- CURD : Create, Update, Read, Delete
 * 				-> 데이터 처리(추가 INSERT, 수정 UPDATE, 삭제 DELETE, 검색 SELECT)
 * 			- 주요메소드
 * 				- void add(Object o) : 데이터 추가
 * 				- void remove(int index) : 데이터 삭제
 * 				- void set(int index, Object o) : 데이터 수정
 * 				- Object get(int index) : 데이터 읽기
 * 				- int size() : 저장된 갯수 확인
 * 				- void clear() : 전체 삭제
 * 				- boolean isEmpty() : 데이터 존재 여부 확인 
 * 			- 구현 클래스 간 차이점 
 * 				(1) 저장방법 : ArrayList -> 비동기화 (권장)(DB에서 주로 사용)
 * 							Vector -> 동기화 (네트워크에서 사용자 정보 저장 시 사용)
 * 				(2) 저장 시 인덱스번호 조절됨 -> 수정, 추가 빈번한 경우 LinkedList가 빠름
 * 
 * 		2) Set -> 양의 정수 집합
 * 			- 순서 없음 -> forEach로 출력
 * 			- 저장된 데이터 중복 불가 -> 분야별로 분류할 때 사용
 * 								  (List의 데이터 중복 없이 추출할 때)
 * 			- 주요메소드 
 * 				-> List, Set은 모두 Collection 상속받은 인터페이스
 * 				-> 메소드 거의 동일
 * 
 * 		3) Map -> 우편번호
 * 			- 웹에서 지원하는 모든 클래스는 Map 형식 지님
 * 				-> HttpServletRequest : 사용자가 보내주는 데이터
 * 				   HttpServletResponse : 사용자 요청 처리 결과 브라우저로 전송
 * 				   HttpSession : 서버에 데이터 저장
 * 				   Cookie : 사용자의 브라우저에 저장
 * 			- 키(key) + 값(value) 쌍으로 저장
 * 				ex. id + admin
 * 			- 키는 중복 불가, 값은 중복 가능
 * 			- 클래스관리(Spring, MYBatis), 요청값관리, 전송값관리 시 주로 사용
 * 			- 주요메소드
 * 				- HashMap()
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
		System.out.println();
		
		//set
		list.set(2, "박문수");
		for(int i=0;i<list.size();i++) { 
			String name=list.get(i).toString();
			System.out.println(i+". "+name);
		}
		System.out.println();
		
		//remove
		list.remove(3);
		for(int i=0;i<list.size();i++) { 
			String name=list.get(i).toString();
			System.out.println(i+". "+name);
		}
		System.out.println();
		
		//clear, isEmpty
		list.clear();
		if(list.isEmpty())
			System.out.println("저장된 데이터가 없습니다.");
		System.out.println();
		
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
			System.out.println(i);
		}
		System.out.println();

		//copy
		ArrayList list2=new ArrayList(list1.subList(1,5));
											//원하는 부분만(인덱스 1~5 전까지) 자르기
		for(Object i:list2) {
			System.out.println(i);
		}
		System.out.println();
		
		//출력방식
		ArrayList list3=new ArrayList();
		list3.add("포도");
		list3.add("사과");
		list3.add("바나나");
		list3.add("수박");
		list3.add("배");
			//forEach문
		for(Object i:list3) {
			System.out.print(i+" ");
		}
		System.out.println();
			//for문
		for(int i=0;i<list3.size();i++) {
			Object obj=list3.get(i);
			System.out.print(obj+" ");
		}
		System.out.println();
			//배열 자체 출력
		System.out.println(list3);
			//람다식(함수포인터) -> 사용 빈도 적음
		list3.forEach((obj)->System.out.print(obj+" "));
		System.out.println();
		
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
			//포함여부 확인
		System.out.println("4 contains 5:"+list4.containsAll(list5));
			//중복된 데이터만 유지, 나머지 제거
		list4.retainAll(list5); 
		System.out.println("list4:"+list4);
		System.out.println("list5:"+list5);
		
	}

}
