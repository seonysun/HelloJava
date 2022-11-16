class A{
	
}
class B extends A{
	
}
public class 예외처리실행순서 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(10/0); //에러 발생 시 catch절로 탈출 -> 이하의 문장은 수행되지 않음
			System.out.println(5);
		} catch(RuntimeException ex) { //catch절 제외 시 finally 수행 후 비정상 종료 -> 8, 9 출력되지 않음
			System.out.println(6);
		} finally {
			System.out.println(7);
		}
		System.out.println(8);
		System.out.println(9);
		
		
		//
		try { //catch절 수행 시 다시 돌아오지는 않음 -> 위에서 오류 발생 시 아래 문장 수행하지 않음
											//(catch절 여러 개일 때는 해당되는 오류 1개만 찾을 수 있음)
			B b=(B)new A();
			
			String str1=" 10"; //공백은 정수로 변환 불가 -> .trim()
			System.out.println(Integer.parseInt(str1.trim()));
			System.out.println(Integer.parseInt(str1));
			
			String str=null;
			System.out.println(str.trim());
			
			System.out.println(10/0); 
		} 
		catch(ArrayIndexOutOfBoundsException ex) {
			//배열 범위 초과할 경우
			System.out.println("배열의 범위를 초과하였습니다.");
		}
		catch(ArithmeticException ex) {
			//0으로 나눴을 경우
			System.out.println("0으로 나눌 수 없습니다.");
		}
		catch(NumberFormatException ex) {
			//문자열이 정수로 변환되지 않을 경우
			System.out.println("정수로 변환될 수 없습니다.");
		}
		catch(NullPointerException ex) {
			//객체, 클래스의 주소값이 없는 경우
			System.out.println("참조변수에 저장된 주소가 없습니다.");
		}
		catch(ClassCastException ex) {
			//형변환이 잘못됐을 경우
			System.out.println("형변환을 확인해주세요.");
		}
		catch(RuntimeException ex) {
			//위에 있는 모든 예외처리 -> 예상하지 못하는 경우(기타)
			System.out.println("RuntimeException");
		}
		
	}

}
