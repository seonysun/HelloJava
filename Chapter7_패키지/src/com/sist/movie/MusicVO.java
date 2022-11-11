package com.sist.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //get 메소드 생성
@Setter	//set 메소드 생성
@NoArgsConstructor //기본생성자 생성
@AllArgsConstructor //매개변수 생성자 생성
public class MusicVO {
	//@Getter //클래스 밖에서 @getter 설정 시 변수 전체, 클래스 안에서 설정 시 바로 아래 위치한 변수만 생성
	private int mno;
	private String title, singer, album, state;
	private int crement;
}
