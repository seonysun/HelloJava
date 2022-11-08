import java.io.*;
import java.util.Scanner;
public class MovieSystem {
	Movie[] movie=new Movie[1938];
	{
		try {
			int k=0;
			FileReader fr=new FileReader("c:\\javadev\\movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			String data=sb.toString();
			String[] temp=data.split("\n");
			for(String s:temp) {
				String[] m=s.split("\\|");
				movie[k]=new Movie();
				movie[k].mno=Integer.parseInt(m[0]);
				movie[k].title=m[1];
				movie[k].genre=m[2];
				movie[k].poster=m[3];
				movie[k].actor=m[4];
				movie[k].regdate=m[5];
				movie[k].grade=m[6];
				movie[k].director=m[7];
				k++;
			}
		} catch(Exception ex) {}
	}
	
	public static void main(String[] args) {
		MovieSystem ms=new MovieSystem();
		for(Movie m:ms.movie) {
			//movie(Movie): 데이터모음 클래스, ms(MovieSystem): 객체 배열 생성해서 파일에서 데이터 불러오는 클래스
			System.out.println(m.mno+"."+m.title);
		}
		Scanner scan=new Scanner(System.in);
		System.out.print("장르 입력:");
		String genre=scan.next();
		for(Movie m:ms.movie) {
			if(m.genre.contains(genre)) {
				System.out.println(m.title+"("+m.genre+")");
			}
		}
		
	}

}
