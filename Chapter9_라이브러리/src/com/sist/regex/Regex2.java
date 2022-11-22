package com.sist.regex;

import java.util.*;
import java.util.regex.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Regex2 {

	public static void main(String[] args) {
		String[] movie= {
			"올빼미",	
			"블랙팬서: 와칸다 포에버",	
			"동감",	
			"유포자들",	
			"데시벨",	
			"스트레인지 월드",	
			"원피스 필름 레드",	
			"창밖은 겨울",	
			"폴: 600미터",	
			"그녀가 말했다"
		};
		Scanner scan=new Scanner(System.in);
		System.out.println("영화목록==================");
		for(int i=0;i<movie.length;i++) {
			System.out.println((i+1)+"."+movie[i]);
		}
		System.out.print(".> 영화 선택:");
		int movieId=scan.nextInt();
		String title=movie[movieId-1];
		System.out.println("선택된 영화명:"+title);
//		try {
//			String url="https://www.youtube.com/results?search_query="+title;
//			Document doc=Jsoup.connect(url).get();
//			String pattern="/watch//?v=[^가-힣]+";
//			String data3=doc.toString();
//			Pattern p3=Pattern.compile(pattern);
//			Matcher m3=p3.matcher(data3);
//			String key="";
//			int i;
//			while(m3.find()) {
//				if(i==1) {
//					key=m3.group();
//					break;
//				}
//				i++;
//			}
//			key=key.substring(key.indexOf("=")+1,key.indexOf("/"));
//		} catch(Exception e) {}

	}

}
