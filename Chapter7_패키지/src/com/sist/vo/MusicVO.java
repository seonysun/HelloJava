package com.sist.vo;

/*
 * VO; Value Object : 값만 제어하는 클래스
 * 						-> 변수 지정
 * 
 * 0|That That (Prod. & Feat. SUGA of BTS)|싸이 (Psy)|싸다9|8dJyRm2jJ-U
 * */

public class MusicVO {
	private int mno;
	private String title;
	private String singer;
	private String album;
	private String key;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
