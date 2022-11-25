package com.sist.list;
import java.util.*;

/*
 * - Vector 고유 메소드
 * 		- add : addElement()
 * 		- get : elementAt()
 * 		- remove : removeElementAt()
 * */

public class Vector_ {

	public static void main(String[] args) {
		Vector list=new Vector();
		//추가
		list.addElement("홍길동"); //인덱스 0
		list.addElement("심청이");
		list.addElement("강감찬");
		list.addElement("이순신");
		list.addElement("박문수");
		
		//출력
		for(int i=0;i<list.size();i++) {
			String name=(String)list.elementAt(i);
			System.out.print(name+" ");
		}
		
		list.forEach((name)->System.out.println(name));
		
		for(Object obj:list) {
			System.out.print(obj+" ");
		}
		System.out.println("\n");
		
		//Vector -> ArrayList
			//생성자
		ArrayList list2=new ArrayList(list);
		System.out.println("list2="+list2);
			//addAll
		ArrayList list3=new ArrayList();
		list3.addAll(list);
		System.out.println("list3="+list3);
		
		//수정
		list.setElementAt("을지문덕", 2);
							//배열의 형태로 저장 -> 주소 참조, 기존의 데이터 주소는 GC 대상
		System.out.println(list);
		
		//삭제
		list.removeElementAt(1);
		System.out.println(list);
		list.clear();
		System.out.println("전체 삭제? "+list.isEmpty());
		
	}

}
