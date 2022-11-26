package com.sist.music;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicSystem {
	private static ArrayList<Music> list=new ArrayList<Music>();
	/* 초기화
	 * 	- 명시적 초기화 : 기본형 데이터만 가능
	 * 	- 생성자 : instance 변수 초기화 
	 * 	- 초기화 블럭 : static 변수 초기화 */
	static {
		int mno=1;
		try {
			//데이터 수집
				//지니
			for(int i=1;i<=2;i++) { //지니는 50개씩 나뉘어져있어서 100개 가져오려고 반복
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20221125&hh=14&rtm=Y&pg="+i).get();
				/* <div>
				 * 	<div class="a">
				 * 		<span id="b">aaa</span> //span 태그 안에 있는 b라는 값 가진 데이터 요청
				 * 		<span class="c">bbb</span>
				 * */
				Elements title=doc.select("table.list-wrap td.info a.title");
				Elements singer=doc.select("table.list-wrap td.info a.artist");
				Elements album=doc.select("table.list-wrap td.info a.albumtitle");
				Elements etc=doc.select("span.rank span.rank");
				for(int j=0;j<title.size();j++) {
					Music m=new Music();
					m.setMno(mno);
					m.setCno(1); //지니=1
					m.setTitle(title.get(j).text());
					m.setSinger(singer.get(j).text());
					m.setAlbum(album.get(j).text());
					String tempetc=etc.get(j).text();
					int in=0;
					String state=tempetc.replaceAll("[^가-힣]", "");
					if(state.equals("유지"))
						in=0;
					else in=Integer.parseInt(tempetc.replaceAll("[^0-9]", "").trim());
					m.setState(state);
					m.setCrement(in);
					list.add(m);
					mno++;
				}
			}
			mno=101;
				//멜론
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title=doc.select("tr.lst50 div.rank01");
			Elements singer=doc.select("tr.lst50 div.rank02");
			Elements album=doc.select("tr.lst50 div.rank03");
			Elements etc=doc.select("tr.lst50 div.wrap span.rank_wrap");
			for(int i=0;i<title.size();i++) {
				Music m=new Music();
				m.setMno(mno);
				m.setCno(2); //멜론=2
				m.setTitle(title.get(i).text());
				m.setSinger(singer.get(i).text());
				m.setAlbum(album.get(i).text());
				String tempetc=etc.get(i).text();
				int in=0;
				String state=tempetc.replaceAll("[^가-힣]", "");
				if(state.equals("유지"))
					in=0;
				else in=Integer.parseInt(tempetc.replaceAll("[^0-9]", "").trim());
				m.setState(state);
				m.setCrement(in);
				list.add(m);
				mno++;
			}
		} catch(Exception e) {}
	}
	//요청 처리
	//목록 - 지니/멜론 나눠서 처리; cno
//	public ArrayList<Music> musicCategoryData(int cno){
//		return;
//	}
	//노래 검색
	//상세보기; mno
	public static void main(String[] args) {
		MusicSystem m=new MusicSystem();
	}
}
