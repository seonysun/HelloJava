import java.util.*;

class A{
	
}
class B extends A{
	
}
class C extends A{
	
}
class D extends C{
	
}
class E{
	
}
public class 제네릭스_매개변수3 {

	public static void main(String[] args) {
		ArrayList<? extends A> list1=new ArrayList<A>();
				//A로부터 상속받은 클래스 사용 가능
		ArrayList<? extends A> list2=new ArrayList<B>();
		ArrayList<? extends A> list3=new ArrayList<D>();
		//ArrayList<? extends A> list4=new ArrayList<E>();
													//E는 A 상속 아니므로 불가
		

	}

}
