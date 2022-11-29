package com.sist.music;

import java.util.*;

public class MusicMain {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		MusicSystem ms=new MusicSystem();
	    System.out.print("지니뮤직(1),멜론(2) 선택:");
	    int cno=scan.nextInt();
	        
	    ArrayList<Music> list=ms.movieCategoryData(cno);
	        if(cno==1)
	        	System.out.println("=== 지니뮤직 Top100 ===");
	        else
	        	System.out.println("=== 멜론뮤직 Top50 ===");
	    for(Music m:list) {
	    	System.out.println(m.getMno()+"."+m.getTitle()+" "+m.getSinger());
	    }
	    
	}

}
