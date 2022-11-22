package com.sist.string;

import java.util.Scanner;
import java.io.*;
		//IO : 모든 클래스가 컴파일예외(CheckedException) -> 예외처리 필수

public class StartsWith {
	public static String[] musicAllData() {
		String[] music=new String[100];
		FileReader fr=null;
		try {
    		fr=new FileReader("c:\\javaDev\\genie.txt");
    		String data="";
    		int i=0;
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
		String[] title=musicAllData();
        Scanner scan=new Scanner(System.in);
        System.out.print("검색어 입력:");
        String fd=scan.next();
        
        for(String s:title) {
        	if(s.contains(fd))
        		System.out.println(s);
        }
        System.out.println("============");
        
        for(String s:title) {
        	if(s.startsWith(fd))
        		System.out.println(s);
        }
        System.out.println("============");
        
        for(String s:title) {
        	if(s.endsWith(fd))
        		System.out.println(s);
        }

	}

}
