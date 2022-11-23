package com.sist.movie;
import java.util.*;
import java.io.*;

public class MovieSystem {
	private static ArrayList movieList=new ArrayList();
	static {
		try {
			FileReader fr=new FileReader("c:\\javadev\\movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			String movie=sb.toString();
			String[] temp=movie.split("\n");
			for(String m:temp) {
				String[] mm=m.split("\\|");
				MovieVO mov=new MovieVO();
				mov.setMno(Integer.parseInt(mm[0]));
				mov.setTitle(mm[1]);
				mov.setGenre(mm[2]);
				mov.setPoster(mm[3]);
				mov.setActor(mm[4]);
				mov.setRegdate(mm[5]);
				mov.setGrade(mm[6]);
				mov.setDirector(mm[7]);
				
				movieList.add(mov);
			}
		} catch(Exception e) {}
	}
	public ArrayList movieAllData(int page) { //웹 -> 페이지 나눠서 출력
		ArrayList list=new ArrayList();
		int j=0;
		int pagecnt=(page*20)-20; //각 페이지 시작 번호
		for(int i=0;i<movieList.size();i++) {
			if(j<20 && i>=pagecnt) {
				MovieVO m=(MovieVO)movieList.get(i);
				list.add(m);
				j++;
			}
		}
		return list;
	}
	public int movieTotalPage() {
		return (int)(Math.ceil(movieList.size()/20.0));
	}
	public MovieVO movieDetailData(int mno) {
		return (MovieVO)movieList.get(mno-1);
	}
	public ArrayList movieFind(int type,String fd) {
		ArrayList list=new ArrayList();
		for(int i=0;i<movieList.size();i++) {
			MovieVO m=(MovieVO)movieList.get(i);
			if(type==1) {
				if(m.getTitle().contains(fd))
					list.add(m);
			} else if(type==2) {
				if(m.getActor().contains(fd))
					list.add(m);
			} else if(type==3) {
				if(m.getGenre().contains(fd))
					list.add(m);
			}
		}
		return list;
	}
}
