package com.sist.music;

import java.util.*;

public class MusicMain {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);


int[] arr = {10, 20, 30, 40, 50, 60, 70, 40, 30, 20};
Set<Integer> set=new HashSet<Integer>();
for(int i:arr)
	set.add(i);
System.out.println(set);
List<Integer> list=new ArrayList<Integer>(set);
Collections.sort(list);

		
		ArrayList list1=new ArrayList();
		ArrayList list2=new ArrayList();
		ArrayList kyo=new ArrayList();
		ArrayList cha = new ArrayList();// 차집합
		ArrayList hap=new ArrayList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		list1.addAll(list2);
		System.out.println(list1);
		list1.retainAll(list2);
		System.out.println(list1);
		list1.removeAll(list2);
		System.out.println(list1);
		
	}

}
