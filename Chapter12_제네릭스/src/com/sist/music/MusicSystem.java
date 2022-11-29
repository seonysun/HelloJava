package com.sist.music;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicSystem {
	private static ArrayList<Music> list=new ArrayList<Music>();
	//데이터 수집
	static {
		int mno=1;
		try {
				//지니
			for(int i=1;i<=2;i++) { //지니는 50개씩 구분, 100개 가져오려고 반복
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20221125&hh=14&rtm=Y&pg="+i).get();
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
				if(state.contains("동일"))
					in=0;
				else in=Integer.parseInt(tempetc.replaceAll("[^0-9]", "").trim());
				m.setState(state);
				m.setCrement(in);
				list.add(m);
				mno++;
			}
		} catch(Exception e) {}
	}
	//목록 - 지니/멜론 나눠서 처리; cno
	public ArrayList<Music> movieCategoryData(int cno) {
	   ArrayList<Music> mList=new ArrayList<Music>();
	   for(Music m:list) {
		   if(m.getCno()==cno)
			   mList.add(m);
	   }
	   return mList;
	   }
	//노래 검색
	//상세보기; mno
	public static void main(String[] args) {
		MusicSystem m=new MusicSystem();

	}
	
}
