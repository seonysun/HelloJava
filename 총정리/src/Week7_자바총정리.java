/*
 * 1. 내부클래스 : 쓰레드 , 네트워크 , 빅데이터 분석 (MapReduce, Spark)
 *  1) 멤버클래스
 *  	- 두개의 클래스가 공유해야되는 데이터나 메소드 존재할 때 주로 사용 
 * 		- class A{ 
 *        	class B{}
 *        }
 * 	2) 익명의 클래스(스프링)
 *      - class A{
 *          B b=new B(){ //상속없이 오버라이딩이 가능한 클래스 
 *          	public void display(){}
 *          }
 *        }
 *        class B{
 *          public void display(){}
 *        }
 * 	3) 지역 클래스 
 *      - class A{
 *          public void display(){
 *          	class B{} //메소드 내에서만 사용 가능
 *          }
 *        }
 *        
 * 2. 종단클래스 : 확장이 불가능한 클래스 
 *   - final class ClassName ==> String,Math,System (java.lang)
 */

class A { // 윈도우 , Server (접속 담당)
	class B { //쓰레드 , 통신 담당 
		public void display() {
			System.out.println("B:display Call...");
		}
	}
	public void aaa() {
		B b=new B();
		b.display();
	}
}
class D {
	E e=new E() {
		public void display() {
			System.out.println("D.E:display() Call...");
		}
	};
}
class E {
	public void display() {
		System.out.println("E:display() Call...");
	}
}
public class Week7_자바총정리{
	public static void main(String[] args) {
		A a=new A();
		a.aaa();
			
		E e=new E();
		e.display();
			
		D d=new D();
		d.e.display();
		
	}
	
}
