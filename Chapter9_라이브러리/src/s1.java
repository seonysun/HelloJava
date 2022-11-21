import java.util.Arrays;
import java.util.StringJoiner;

public class s1 {

	public static void main(String[] args) {
		//join
		String color="red,green,blue,black,white,yellow,magenta";
		String[] colors=color.split(",");
		for(String c:colors) {
			System.out.println(c);
		}
		System.out.println();
		
		String s=String.join("-", colors);
		System.out.println(s);
		s=color.replace(",", "-");
		System.out.println(s);
		System.out.println();
		
		StringJoiner sj=new StringJoiner("/","{","}");
										//구분자,접두어(prefix),접미어(suffix)
		for(String ss:colors) {
			sj.add(ss);
		}
		System.out.println(sj.toString());
		
		
		//byte 배열
		try {
			String name="자바";
			//인코딩(한글을 byte 배열로 변환)
			byte[] b=name.getBytes("UTF-8");
			System.out.println(Arrays.toString(b));
			for(byte bb:b) {
				System.out.print(String.format("%02X", bb));
			}
			
			//디코딩
			byte[] b2=name.getBytes("CP949");
			for(byte bb:b2) {
				System.out.print(String.format("%02X", bb));
			}
		} catch(Exception e) {}

		
		//format
		int a=10;
		int b=20;
		String temp=String.format("%d + %d = %d", a,b,a+b);
						//문자를 원하는 형식으로 변경 후 출력 -> 웹에서는 printf가 없으므로 format 사용
		System.out.println(temp);
	}

}
