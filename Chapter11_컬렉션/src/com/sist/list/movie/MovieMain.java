package com.sist.list.movie;
import java.util.*;
import com.sist.list.*;

public class MovieMain {

	public static void main(String[] args) {
		MovieSystem ms=new MovieSystem();
		//
		int totalpage=ms.movieTotalPage();
		Scanner scan=new Scanner(System.in);
		System.out.print("페이지 입력(1~"+totalpage+"):");
		int curpage=scan.nextInt();
		ArrayList list=ms.movieAllData(curpage);
		System.out.println("====="+curpage+"page 영화목록=====");
		for(int i=0;i<list.size();i++) {
			MovieVO m=(MovieVO)list.get(i);
			System.out.println(m.getMno()+"."+m.getTitle());
		}
		System.out.println();
		
		//
		System.out.print("==> 영화 번호 입력(상세보기):");
		int mno=scan.nextInt();
		MovieVO m=ms.movieDetailData(mno);
		System.out.println("순위:"+m.getMno());
		System.out.println("영화명:"+m.getTitle());
		System.out.println("출연진:"+m.getActor());
		System.out.println("감독:"+m.getDirector());
		System.out.println("장르:"+m.getGenre());
		System.out.println("등급:"+m.getGrade());
		System.out.println("개봉일:"+m.getRegdate());
		System.out.println();
		
		//
		System.out.println("검색 타입");
		System.out.println("1. 제목");
		System.out.println("2. 출연진");
		System.out.println("3. 장르");
		System.out.print("==> 검색 타입 선택:");
		int type=scan.nextInt();
		System.out.print("==> 검색어 입력:");
		String fd=scan.next();
		ArrayList fList=ms.movieFind(type,fd);
		System.out.println(">"+fList.size()+"개의 영화가 검색되었습니다.");
		for(int i=0;i<fList.size();i++) {
			MovieVO mm=(MovieVO)fList.get(i);
			System.out.println("제목:"+mm.getTitle());
			System.out.println("장르:"+mm.getGenre());
			System.out.println("출연진:"+mm.getActor());
			System.out.println();
		}
		
	}

}
