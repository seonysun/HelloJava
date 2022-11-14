package com.sist.manager;

import java.io.FileReader;
import com.sist.vo.MusicVO;
	//패키지가 다르므로 import 설정 필요

/*
 * Manager; 관리 프로그램 : 사용자 정의 타입 
 * 							-> 메소드 설정
 * */

public class MusicManager {
	public static MusicVO[] music=new MusicVO[100];
	static { //파일을 읽어와서 데이터 초기화 해야 함 -> static이므로 블록 이용
		try {
			FileReader fr=new FileReader("c:\\javadev\\genie.txt");
			String mu="";
			int i=0;
			while((i=fr.read())!=-1) {
				mu+=String.valueOf((char)i);
			}
			fr.close();
			
			String[] m=mu.split("\n"); //배열 m에 txt 파일 내용 한 줄씩 나눠서 채우기
			i=0;
			for(String s:m) {
				String[] ss=s.split("\\|"); //배열 ss에 m을 | 기준으로 하나씩 나눠서 채우기
				music[i]=new MusicVO(); //객체 배열로 만들었으면 주소 기본 null값이므로 참조변수 설정해줘야 함
				music[i].setMno(Integer.parseInt(ss[0]));
								//mno는 int이므로 형변환 필요
				music[i].setTitle(ss[1]);
				music[i].setSinger(ss[2]);
				music[i].setAlbum(ss[3]);
				music[i].setKey(ss[4]);
				i++;
			}
		} catch(Exception ex) {}
	}
	public MusicVO[] musicListData() {
		return music;
	}
	public String musicDetailData(int index) {
		return music[index].getKey();
	}
}
