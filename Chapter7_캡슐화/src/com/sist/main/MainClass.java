package com.sist.main;

import com.sist.vo.*;
import com.sist.manager.*;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		MusicManager m=new MusicManager();
		MusicVO[] music=m.musicListData();
		for(MusicVO vo:music) {
			System.out.println(vo.getTitle());
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("음악 선택(0~99):");
		int index=scan.nextInt();
		String key=m.musicDetailData(index);
		
		try {
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
					+"http://youtube.com/embed/"+key);
		} catch(Exception ex) {}

	}

}
