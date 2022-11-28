import java.util.*;

/*
 * 1. 제네릭스
 * 	- 컬렉션에 데이터 저장 시 같은 데이터형으로 저장해야 오류 방지, 제어 편리 
 * 		-> 제네릭스로 데이터형 고정(타입의 안정성)
 * 	- 지정된 데이터형으로 모든 메소드 리턴형, 매개변수 통일
 * 		-> 코드 간결화 가능
 * 		cf. 집합체(배열, 컬렉션) : 하나로 묶어서 사용
 * 			-> 일반 데이터형 통일 : 배열
 * 			-> 일반 클래스 통일 : 인터페이스
 * 	- 클래스형으로 사용
 * 		- 기본형은 불가 -> Wrapper 클래스
 * 						cf. 클래스는 자동 형변환(DownCasting) 불가 -> 일치시켜서 입력
 * 		- 사용자 정의 클래스
 * 		- Object : 데이터형을 잘 모를 때
 * 				   클래스 여러개를 하나로 제어할 때
 * 		- 와일드카드 <?> : 모든 클래스가 가능
 * 						-> 한 개의 메소드 이용해서 여러 데이터형을 받는 경우
 * 		- <? extends A> : A로부터 상속받은 클래스 -> 사용자 정의 제네릭스
 * 	- T : 임시변수(클래스형) -> default Object
 * 	  E : Element(사용자 정의 클래스)
 * 	  K : key
 * 	  V : value
 * 		ex. class Box<T>{
 * 				T box;
 * 				void setBox(T box){}
 * 				T getBox(){
 * 					return box}
 * 			} 
 * 			Set<E> -> Set<Music>
 * 			Map<k,V>
 * */

class Box<T>{ //이후 지정 시 한번에 통일
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
		Object obj=box.getItem();
		Box<String> box1=new Box<String>(); //T:String
		box1.setItem("a");
		String str=box1.getItem();
		Box<Integer> box2=new Box<Integer>(); //T:Integer
		box2.setItem(1);
		int i=box2.getItem();

		ArrayList<?> list1=new ArrayList<Integer>();
				//모든 데이터형 저장 가능 -> 프로그램에 맞게 데이터형 조절 가능
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
		vec.add(10.5); //반드시 double형으로 입력(int, float 불가)
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
