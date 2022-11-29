import java.util.*;

public class 제네릭스_매개변수 {
	public static void display1(ArrayList<String> list) {
		for(String f:list)
			System.out.print(f+" ");
		System.out.println();
	}
	public static void display2(ArrayList<Integer> list) {
		for(int f:list)
			System.out.print(f+" ");
		System.out.println();
	}
	public static void display3(ArrayList<Double> list) {
		for(double f:list)
			System.out.print(f+" ");
		System.out.println();
	}
	public static void display(ArrayList<?> list) {
									//일반 데이터형의 경우 관계없지만 클래스형이 들어오면 데이터형 고려
		for(Object o:list)
			System.out.print(o+" ");
	}
	public static void main(String[] args) {
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("사과");
		list1.add("배");
		list1.add("바나나");
		display1(list1);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		display2(list2);
		ArrayList<Double> list3=new ArrayList<Double>();
		list3.add(10.0);
		list3.add(20.0);
		list3.add(30.0);
		display3(list3);
		
		display(list1);
		display(list2);
		display(list3);
		
	}

}
