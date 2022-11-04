import java.util.Scanner;

public class 메소드_구구단 {
	static void gugudan(int dan) {
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"*"+i+"="+dan*i);
				//메소드 내에서 자체적으로 출력을 수행하므로 따로 넘겨줄 결과값이 없음 -> void
		}
	}
	static String gugudan2(int dan) {
		String result="";
		for(int i=1;i<=9;i++) {
			result+=dan+"*"+i+"="+dan*i+"\n";
				//메소드 실행 결과가 결과값인 result(String)에 저장되어 넘겨줌 -> 결과값 출력하려면 나중에 메소드 사용할 때 출력 명령 따로 내려야 함
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("단 입력:");
		int dan=scan.nextInt();
		
		gugudan(dan); //메소드 불러오기만 하면 출력까지 수행
		
		System.out.println("======");
		
		String s=gugudan2(dan); //메소드 실행 결과값을 동일 데이터형으로 받아와서 사용
		System.out.println(s);
		//System.out.println(gugudan2(dan));

	}

}
