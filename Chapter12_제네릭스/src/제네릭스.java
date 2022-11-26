import java.util.*;

/*
 * 1. 제네릭스
 * 	- 컬렉션에 데이터 저장 시 같은 데이터형으로 저장해야 제어 편리 -> 제네릭스
 * 	- <? extends A> : A로부터 상속받은 클래스 -> 사용자 정의 제네릭스
 * <?> : 모든 클래스가 가능
 * -> 한 개의 메소드 이용해서 여러 데이터형을 받는 경우
 * 여러개의 데이터 이용할 때 데이터 통합되지 않으면 제어하기 어려움 -> 하나로 통일
 * 데이터형을 잘 모를 때 : Object
 * 클래스가 여러개, 하나로 제어할 때 : Object
 * 집합체(배열, 컬렉션) : 하나로 묶어서 사용
 * 	-> 일반 데이터형 통일 : 배열
 * 	-> 일반 클래스 통일 : 인터페이스
 * */

class Box<T>{ //<T>: 임시 저장 클래스형 데이터(Wrapper) -> 자동형변환 불가, 일치시켜서 입력
	T item;
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
}
public class 제네릭스 {

	public static void main(String[] args) {
		Box box=new Box(); //T:Object
		box.setItem("");
		Box<String> box1=new Box<String>(); //T:String
		box1.setItem("");
		Box<Integer> box2=new Box<Integer>(); //T:Integer
		box2.setItem(1);

		//
		ArrayList<?> list1=new ArrayList<Integer>();
		list1=new ArrayList<Double>();
		
		
		//ArrayList
		ArrayList<String> list =new ArrayList<String>();
		list.add("사과");
		list.add("포도");
		for(String s:list)
			System.out.print(s+" ");
		System.out.println();
		
		//HashSet
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(10);
		set.add(20);
		System.out.println(set);
		
		//Vector
		Vector<Double> vec=new Vector<Double>();
		vec.add(89.9);
		vec.add(10.5); //클래스형이므로 반드시 double형으로 입력(int, float 불가)
		for(double d:vec)
			System.out.print(d+" ");
		System.out.println();
		
		//LinkedList
		LinkedList<Character> in=new LinkedList<Character>();
		in.add('A');
		in.add('B');
		System.out.println(in);
		
		//HashMap
		HashMap<String,Boolean> map=new HashMap<String,Boolean>();
		map.put("one", true);
		map.put("two", false);
		Set key=map.keySet();
		System.out.println(key);
		for(Object o:key)
			System.out.println(map.get(o));
		
	}

}
