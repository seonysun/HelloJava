import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 * 0. 객체지향의 특성
 * 	1) 재사용 : 상속(변경해서 사용) -> is-a
 * 			  포함(있는 그대로 사용) -> has-a
 * 	2) 보안 : 은닉화, 캡슐화
 * 	3) 다형성 : 수정, 추가
 * 	4) 추상화
 * 
 * 1. 멤버변수의 초기화
 * 	1) 명시적 초기화 -> 명시적 초기화가 불가능한 경우 2)/3) 고려
 * 	2) 생성자 : 구현해서 변수값을 구하는 경우
 * 	3) 초기화 블록 : 구현해서 변수값을 구하는 경우(생성자가 없을 때 사용 가능)
 * 		- 인스턴스 블록 : 인스턴스 변수, static 변수에 대한 초기화
 * 			ex. class A {
 * 					int a=10;
 * 					{ a=100; } //인스턴스 블록
 * 				}
 * 		- static 블록 : static 변수에 대한 초기화
 * 			ex. class A {
 * 					static int a=10;
 * 					static{ a=100; } //static 블록
 * 				}
 * 		cf. 초기화 블록, 생성자, static -> 상속 예외
 * 	
 * 2. 초기화 순서
 *  1) 클래스 변수(static) : 기본값 → 명시적 초기화 → 클래스 블록 → 생성자
 *  2) 인스턴스 변수 : 기본값 → 명시적 초기화 → 인스턴스 블록 → 생성자
 *  	cf. 클래스 블록 → 인스턴스 블록
 *  	cf. 초기화 블록과 생성자를 함께 사용하지는 않음(결국 생성자 설정값으로 초기화) -> 둘 중 하나 선택하여 사용
 *  			=> 클래스 변수 : 클래스 블록 사용(생성자 호출하지 않아도 됨)
 *  			   인스턴스 변수 : 생성자 사용(객체 생성 시 생성자 자동 호출)
 *  
 *  <ol class="list_movieranking">
                                    <li>
                        <div class="item_poster">
                            <div class="thumb_item">
                                <div class="poster_movie">
                                        <img src="https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2Ff2e234313de6543bb1ba4ad0e5d6ae389a26765b" class="img_thumb" alt="블랙 팬서: 와칸다 포에버">
                                    <span class="rank_num">1</span>
                                        <span class="txt_tag">
                                            <span class="ico_movie ico_see see12">12세이상관람가</span>
                                        </span>
                                </div>
                                <div class="poster_info">
                                    <a href="/moviedb/main?movieId=133423" class="link_story" data-tiara-layer="poster">
                                        “와칸다를 지켜라!”거대한 두 세계의 충돌, 운명을 건 최후의 전투가 시작된다! 국왕이자 ‘블랙 팬서’인 '티찰라'의 죽음 이후수많은 강대국으로부터 위협을 받게 된 '와칸다'.'라몬다', '슈리' 그리고 '나키아', '오코예, '음바쿠'는각자 사명감을 갖고 '와칸다'를 지키기 위해 외로운 싸움을 이어간다.한편, 비브라늄의 패권을 둘러싼 미스터리한 음모와 함께깊은 해저에서 모습을 드러낸 최강의 적 '네이머'와 '탈로칸'의 전사들은'와칸다'를 향해 무차별 공격을 퍼붓기 시작하는데…
                                    </a>
                                </div>
                            </div>
                            <div class="thumb_cont">
                                <strong class="tit_item">
                                    <a href="/moviedb/main?movieId=133423" class="link_txt" data-tiara-layer="moviename">블랙 팬서: 와칸다 포에버</a>
                                </strong>
                                <span class="txt_append">
                                    <span class="info_txt">평점<span class="txt_grade">7.4</span></span>
                                    <span class="info_txt">예매율<span class="txt_num">69.2%</span></span>
                                </span>
                                <span class="txt_info">
							        개봉<span class="txt_num">22.11.09</span>
						        </span>
                            </div>
                        </div>
                    </li>
 * */

class Movie{ //변수 중심 : 데이터형 클래스
	int mno;
	String title, story, reserve;
}
class MovieSystem{ //메소드 중심 : 액션 클래스
	static Movie[] movie=new Movie[20];
	static {
		try {
			Document doc=Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
			//System.out.println(doc.toString());
			Elements title=doc.select("ol.list_movieranking strong.tit_item a");
			Elements story=doc.select("ol.list_movieranking div.poster_info a");
			Elements reserve=doc.select("ol.list_movieranking span.txt_append span.txt_num");
			
			for(int i=0;i<title.size();i++) {
				movie[i]=new Movie();
				movie[i].title=title.get(i).text();
				movie[i].story=story.get(i).text();
				movie[i].reserve=reserve.get(i).text();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class MovieSystem2{
	Movie[] movie2=new Movie[20];
	MovieSystem2(){
		try {
			Document doc=Jsoup.connect("https://movie.daum.net/ranking/reservation").get();
			//System.out.println(doc.toString());
			Elements title=doc.select("ol.list_movieranking strong.tit_item a");
			Elements story=doc.select("ol.list_movieranking div.poster_info a");
			Elements reserve=doc.select("ol.list_movieranking span.txt_append span.txt_num");
			
			for(int i=0;i<title.size();i++) {
				movie2[i]=new Movie();
				movie2[i].title=title.get(i).text();
				movie2[i].story=story.get(i).text();
				movie2[i].reserve=reserve.get(i).text();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class A{
	int a=10;
	static int b=20;
	{
		a=100;
	}
	static {
		b=200;
	}
	A(){
		a=1000;
		b=2000;
	} //최종 a, b -> 생성자 내의 값 (사실 이 경우는 명시적 초기화로 설정하는 것이 가장 편함)
}
public class 초기화블록 {

	public static void main(String[] args) {
		A a=new A();
		
		System.out.println("===========클래스===========");
		Movie[] m=MovieSystem.movie; //static이므로 객체 생성 불필요
		for(Movie mm:m) {
			System.out.println(mm.title);
			System.out.println(mm.story);
			System.out.println(mm.reserve);
			System.out.println();
		}
		
		System.out.println("==========인스턴스===========");
		MovieSystem2 ms=new MovieSystem2(); //인스턴스이므로 객체 생성 필요
		Movie[] m2=ms.movie2;
		for(Movie mm:m2) {
			System.out.println(mm.title);
			System.out.println(mm.story);
			System.out.println(mm.reserve);
			System.out.println();
		}

	}

}
