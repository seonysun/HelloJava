/*
 * 1. 메소드의 종류
 * 	1) 인스턴스 메소드 : 서로 다른 메모리에 저장 -> 각각 다르게 동작
 * 	2) 클래스(static) 메소드 : 하나의 메모리에 저장 -> 공유
 * 		- 클래스 메소드 안에서는 인스턴스 메소드 호출 불가 -> 동적메모리 할당 필요
 * 			클래스명 메소드명 = new 클래스명();
 * 
 * void a() { b, c, d 모두 호출 가능}
 * static void b() {c만 호출 가능}
 * static void c() {b만 호출 가능
 * 메소드종류 a=new 메소드종류(); -> 메모리할당 처리하면 a도 호출 가능
 * }
 * void d() {a, b, c 모두 호출 가능}
 * 
 * 	3) 추상 메소드 : 선언부 / 구현부
 * */
public class 메소드종류 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
