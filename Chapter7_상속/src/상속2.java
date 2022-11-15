class Super2{
	int a=1;
	int b=2;
	public void display() {
		System.out.println("Super2:display() Call..");
	}
}
class Sub2 extends Super2{
	int c=3;
	public void display() {
		System.out.println("Sub2:display() Call..");
	}
}

class A{
	int a=10;
	public void display() {
		System.out.println("A:display Call..");
	}
}
class B extends A{
	int a=100;
	public void display() {
		System.out.println("B:display Call..");
	}
}
public class 상속2 {

	public static void main(String[] args) {
		Sub2 sub=new Sub2(); //하위 변수, 하위 메소드
		System.out.println("sub.a="+sub.a);
		System.out.println("sub.b="+sub.b);
		System.out.println("sub.c="+sub.c);
		sub.display();
		
		Super2 sup=new Sub2(); //상위 변수, 하위 메소드
		System.out.println("sup.a="+sup.a);
		System.out.println("sup.b="+sup.b);
		//System.out.println("sup.c="+sup.c); //하위클래스의 변수에는 접근 불가
		sup.display();
		
		//Sub2 sub2=new Super2(); //하위 변수, 상위 메소드 -> 형변환 오류
		//Sub2 sub2=(Sub2)new Super2(); //형변환 시에는 생성자가 같아야함 -> 컴파일 시 오류
		Super2 sup2=new Sub2(); 
		Sub2 sub2=(Sub2)sup2;
		System.out.println("sub2.a="+sub2.a);
		System.out.println("sub2.b="+sub2.b);
		System.out.println("sub2.c="+sub2.c);
		sub2.display();
		System.out.println();
		
		
		//
		B b=new B();
		System.out.println(b.a);
		b.display();
		
		A c=new B();
		System.out.println(c.a);
		c.display();
		
		B d=(B)c;
		System.out.println(d.a);
		d.display();

	}

}
