package com.sist.string;

import java.util.Scanner;
import java.io.*;
		//IO : 모든 클래스가 컴파일예외 -> 예외처리 필수

public class StartsWith {
	public static String[] musicAllData() {
		String[] music=new String[100];
		FileReader fr=null;
		try {
    		fr=new FileReader("c:\\javaDev\\genie.txt");
    		int i=0;
    		String data="";
    		while((i=fr.read())!=-1)
    		{
    			data+=String.valueOf((char)i);
    		}
    		//System.out.println(data);
    		String[] musicData=data.split("\n");
    		int k=0;
    		for(String m:musicData) {
    			String[] tmp=m.split("\\|");
    			music[k]=tmp[1];
    		    k++;	
    		}
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		try {
    			if(fr!=null)
    				fr.close();
    		} catch(Exception ex){}
    	}
		return music;
	}
	public static void main(String[] args) {
		musicAllData();
		String[] title=musicAllData();
		 //startsWith ==> 접두어 (시작하는 문자열 확인)
        // 원형 : public boolean startsWith(String prefix) ==> LIKE => A%
        Scanner scan=new Scanner(System.in);
        System.out.print("검색어 입력:");
        String fd=scan.next();
        
        /*for(String s:title)
        {
        	if(s.startsWith(fd)) // 있는 경우가 true ==> true일때 수행 
        	{
        		System.out.println(s);
        	}
        }*/
        // 원형 : public boolean endsWith(String suffix) => 접미어   ==> %A
        /*for(String s:title)
        {
        	if(s.endsWith(fd)) // 끝나는 문자열이 같은 경우에 출력 (여러글자 사용도 가능)
        	{
        		System.out.println(s);
        	}
        }*/
        // contains ==> 포함 => 원형 : public boolean contains(String s) => 실제 검색
        
	    for(String s:title) {if(s.contains(fd))
    	{
    		System.out.println(s);
    	}
	        	System.out.println(s);
	    }

	}

}
