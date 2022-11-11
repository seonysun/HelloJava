import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Music{
	int mno;
	String mtitle, singer, album, poster, state;
		//입력 후 변화되지 않는 정보 : String
	int idcrement, rank;
		//데이터가 누적됨에 따라 계속해서 변화될 수 있는 정보 : 숫자
}
public class 클래스배열 {

	public static void main(String[] args) {
		Student[] std=new Student[3]; //참조변수 선언 시 일반 변수처럼 배열 사용 가능 -> 참조변수 배열
			//같은 폴더(패키지) 내에서는 import 없이 다른 클래스 불러오기 가능 -> 동일한 이름의 클래스 2개 생성 불가
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<std.length;i++) {
			std[i]=new Student();
				//std[] 배열로 참조변수 선언되었으나 자동초기화로 기본값(null)인 상태 -> 객체 생성(주소값 초기화) 후 사용 가능
				//Student[] std={new Student(), new Student(), new Student()} : 명시적 초기화
			System.out.print("이름 입력:");
			std[i].name=scan.next();
			System.out.print("국어점수:");
			std[i].kor=scan.nextInt();
			System.out.print("영어점수:");
			std[i].eng=scan.nextInt();
			System.out.print("수학점수:");
			std[i].math=scan.nextInt();
		}
		for(int i=0;i<std.length;i++) {
			System.out.print(std[i].name+":"+std[i].kor+","+std[i].eng+","+std[i].math);
			System.out.println();
		}
		
		
		//
		Music[] music=new Music[200];
		try {
			int k=0;
			for(int i=1;i<=4;i++) {
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20221107&hh=12&rtm=Y&pg="+i).get();
				Elements title=doc.select("tr.list a.title");
				Elements singer=doc.select("tr.list a.artist");
				Elements album=doc.select("tr.list a.albumtitle");
				Elements etc=doc.select("tr.list span.rank");
				Elements poster=doc.select("tr.list a.cover img");
				for(int j=0;j<title.size();j++)	{
					music[k]=new Music();
					music[k].mno=k+1;
					music[k].mtitle=title.get(j).text();
					music[k].singer=singer.get(j).text();
					music[k].album=album.get(j).text();
					String s=etc.get(j).text();
					music[k].state=s.replaceAll("[^가-힣]", "");
					music[k].poster=poster.get(j).text();
					System.out.println(k+1);
					System.out.println(title.get(j).text());
					System.out.println(singer.get(j).text());
					System.out.println(album.get(j).text());
					System.out.println("===========================================");
					k++;
				}
			}
		} catch(Exception ex) {}
		
		for(int i=0;i<music.length;i++) {
			String str="";
			if(music[i].state.equals("유지"))
				str="-";
			else if(music[i].state.equals("상승"))
				str="▲";
			else if(music[i].state.equals("하강"))
				str="▼";
			else
				str="NEW";
			System.out.println((i+1)+"."+str+" "+music[i].mtitle+" "+music[i].singer+" "+music[i].album);
		}

	}

}
