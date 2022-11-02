import java.util.Scanner;

import javax.lang.model.util.Elements;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class 반복while문2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
				//무한루프 사용 시 종료하는 프로그램을 반드시 만들어야 함 
			System.out.println("====menu====");
			System.out.println("1. 로그인"); //String
			System.out.println("2. 회원가입"); //IO
			System.out.println("3. 영화목록");//try-catch -> jsoup
			System.out.println("4. 영화 상세보기");
			System.out.println("5. 영화 예매");
			System.out.println("6. 종료");
			System.out.println("============");
			
			System.out.print("메뉴를 선택하세요.> ");
			int menu = scan.nextInt();
			switch(menu) {
			case 1: 
				break;
				//case 1에 해당되면 switch문을 탈출 -> 다시 while문 루프 -> case 6에서 프로그램 exit 할 때까지
			case 2: 
				break;
			case 3: 
				movieList();
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default: System.out.println("존재하지 않는 메뉴입니다.(404)");
			}
		}
		
	}
		//영화 목록 출력 기능 메소드
	static void movieList() {
		try {
			Document doc = Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
							//jsoup: 데이터 수집
			org.jsoup.select.Elements title = doc.select("strong.tit_item a.link_txt");
			org.jsoup.select.Elements reserve = doc.select("span.info_txt span.txt_num");
			for(int i=0;i<title.size();i++) {
				System.out.println((i+1)+"."+title.get(i).text()+"("+reserve.get(i).text()+")");
			}
		} catch(Exception e) {}
	}
	
}
