package com.sist.set;
import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Music {
	public static Set musicGenie() {
		Set set=new HashSet();
		try {
			int k=1;
			for(int i=1;i<=2;i++) {
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20221124&hh=15&rtm=Y&pg="+i).get();
				Elements title=doc.select("table.list-wrap a.title");
				for(int j=0;j<title.size();j++) {
									//Elements : ArrayList
					System.out.println(k+"."+title.get(j).text());
					set.add(title.get(j).text());
					k++;
				}
			}
		} catch(Exception e) {}
		return set;
	}
	public static Set musicMelon() {
		TreeSet set=new TreeSet();
		try {
			int k=1;
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title=doc.select("div.wrap_song_info div.rank01 a");
			for(int j=0;j<title.size();j++) {
				System.out.println(k+"."+title.get(j).text());
				set.add(title.get(j).text());
				k++;
			}
		} catch(Exception e) {}
		return set;
	}
	public static void main(String[] args) {
		Set genie=musicGenie();
		Set melon=musicMelon();
		System.out.println("=> 지니\n"+genie);
		System.out.println("=> 멜론\n"+melon);
		
		genie.removeAll(melon);
		System.out.println("=> Genie Only\n"+genie);
		
	}

}
