import java.io.IOException;

public class 예외처리_간접처리 {
	public static void a() throws InterruptedException, IOException{
		
	}
	public static void b() throws NumberFormatException, NullPointerException{
		
	}
	
	public static void method1() throws Exception{
		method2();
	}
	public static void method2() throws Exception{
		throw new Exception();
	}
	public static void main(String[] args) throws Exception {
												//InterruptedException, IOException 둘 다 사용 가능
		b(); //RuntimeException -> 예외처리 생략 가능
		a(); //CheckException -> 예외처리 필수
		method1();
		method2();

	}

}
