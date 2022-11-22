package com.sist.text;

import java.util.*;
import java.io.*;
import java.text.*;

class Movie{
	private int rank;
	private String title;
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
}
public class Format_2 {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("c:\\javadev\\movie.txt");
			/* cf. 파일 읽어오는 클래스
			 * 	FileInputStream(1byte) -> 파일 업/다운로드
			 * 	FileReader(2byte) -> 한글(1글자당 2byte) */
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1) {
				sb.append(String.valueOf((char)i));
			}
			fr.close();

			String data=sb.toString();
			String[] movie=data.split("\n");
			for(String m:movie) {
				Object[] obj=m.split("\\|");
				String msg="순위:{0}\n제목:{1}\n장르:{2}\n출연:{4}\n개봉일:{5}\n등급:{6}\n감독:{7}\n";
				System.out.println(MessageFormat.format(msg, obj));
			}
		} catch(Exception e) {}

	}

}
