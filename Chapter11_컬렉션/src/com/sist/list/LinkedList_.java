package com.sist.list;
import java.util.*;

public class LinkedList_ {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add("1");
		list.add("2");
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		
		//수정
		list.set(1, 20);
		System.out.println(list);
		
		//삭제
		list.remove(3);
		System.out.println(list);
		
		list.clear();
		if(list.isEmpty())
			System.out.println("데이터가 없습니다");

	}

}
