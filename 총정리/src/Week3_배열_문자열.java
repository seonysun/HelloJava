import java.io.FileReader;
import java.util.Scanner;

public class Week3_배열_문자열 {

	public static void main(String[] args) {
		String movie1="1|쇼생크 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세 관람가|프랭크 다라본트";
		String[] data1=movie1.split("\\|");
			//정규식 기호 : ^(부정), ?, |, +, * . -> 역슬래시(\\)를 붙여서 실제 기호와 구분되도록 해야 함
		for(String s:data1) {
			System.out.println(s);
		}
		System.out.println();
		
		
		//
		String data2="버섯으로 관자 느낌 내는 방법! 새송이버섯산장버터구이 만들기";
		if(data2.length()>17) {
			data2=data2.substring(0,17)+"...";
		}
		System.out.println(data2);
		System.out.println();
		
		
		//
		String address="서울특별시 동대문구 전농로23길 78 1F 지번 서울시 동대문구 전농동 221-8 1F";
		String addr1=address.substring(0,address.lastIndexOf("지")).trim();
		System.out.println(addr1);
		String addr2=address.substring(0,address.indexOf("지")+3);
		System.out.println(addr2);
		System.out.println();
		
		
		//
		String[] movie=new String[1938];
		try {
			StringBuffer sb=new StringBuffer();
			FileReader fr=new FileReader("c:\\javadev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			String data=sb.toString();
			String[] temp=data.split("\n");
			i=0;
			for(String s:temp) {
				movie[i]=s;
				i++;
			}
		} catch(Exception ex) {}
		
		for(String s:movie)
			System.out.println(s);
		
		Scanner scan=new Scanner(System.in);
		System.out.print("1~1938 사이의 번호 입력:");
		int mno=scan.nextInt();
		
		String detail=movie[mno-1];
		String[] ss=detail.split("\\|");
		for(String s:ss)
			System.out.println(s);
		
		System.out.print("출연진 이름 입력:");
		String name=scan.next();
		for(String data:movie) {
			if(data.contains(name)) {
				String[] temp=data.split("\\|");
				/*
				for(String d:temp) //해당되는 배열 요소 전체 출력
					System.out.println(d);
				*/
				System.out.println(temp[1]); //제목만 출력
			}
		}
		
	}

}
