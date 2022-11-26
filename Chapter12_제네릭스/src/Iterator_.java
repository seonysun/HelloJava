import java.util.*;

/*
 * 1. Iterator
 * 	- 컬렉션에 저장되어있는 데이터를 모아서 한번에 접근
 * 		-> 표준화(ArrayList, Vector, LinkedList, HashSet, HashMap)
 * 
 * 	1) Iterator -> 단방향
 * 		- hasNext() : 1->5
 * 		- next() : 실제 해당 위치의 데이터를 읽어옴
 * 		- remove() : 데이터 삭제
 * 
 * 	2) ListIterator -> 양방향
 * 		- List -> ArrayList, Vector, LinkedList에서만 사용 가능
 * 		- hasPrevious() : 5->1
 * */

public class Iterator_ {

	public static void main(String[] args) {
		//ArrayList
		ArrayList<String> list=new ArrayList<String>();
		list.add("사과");
		list.add("배");
		list.add("수박");
		list.add("바나나");
		list.add("귤");

		Iterator<String> it=list.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
		System.out.println();
		
		//Vector
		Vector<String> vec=new Vector<String>();
		vec.add("hong");
		vec.add("shin");
		vec.add("park");
		vec.add("lee");
		vec.add("kang");
		
		Iterator<String> it2=vec.iterator();
		while(it2.hasNext())
			System.out.print(it2.next()+" ");
		System.out.println();
		
		//LinkedList
		LinkedList<Integer> list2=new LinkedList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);

		Iterator<Integer> it3=list2.iterator();
		while(it3.hasNext())
			System.out.print(it3.next()+" ");
		System.out.println();
		
		//HashSet
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		
		Iterator<Integer> it4=set.iterator();
		while(it4.hasNext())
			System.out.print(it4.next()+" ");
		System.out.println();
		
		
		//ListIterator
		ArrayList<Integer> list11=new ArrayList<Integer>();
		list11.add(1);
		list11.add(2);
		list11.add(3);
		list11.add(4);
		list11.add(5);
		
		ListIterator<Integer> it11=list11.listIterator();
		while(it11.hasNext())
			System.out.print(it11.next()+" ");
		while(it11.hasPrevious())
			System.out.print(it11.previous()+" ");
		
	}

}
