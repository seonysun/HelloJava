package com.sist.properties;
import java.util.*;
import java.io.*;

/*
 * 4) properties : 파일 읽어서 데이터 가져옴(DB에서 유저 id, pw)
 * 		- Hashtable 상속
 * 			-> key + value 형태로 데이터 저장, (String, String)
 * 		- 스프링에서 주로 사용(유효성 검사), MyBatis(DB 정보 저장)
 * 			-> 중요한 데이터가 있는 경우 웹에 정보 그대로 저장하면 노출 위험 
 * 			-> 파일로 저장해서 감춰서 가져옴
 * 		- 주요메소드
 * 			- load() : 파일 읽기
 * 			- getProperty() : 파일에서 데이터 읽기
 * 			- setProperty() : 파일에 저장할 내용 설정
 * */

public class Properties_ {

	public static void main(String[] args) {
		try {
			//저장한 파일 읽어오기
			Properties prop=new Properties();
			prop.load(new FileInputStream("C:\\Users\\csh99\\git\\seonysun\\Chapter11_컬렉션\\src\\com\\sist\\properties\\info.properties"));
			String name=prop.getProperty("name");
			String address=prop.getProperty("address");
			String tel=prop.getProperty("tel");
			System.out.println(name+" "+address+" "+tel);
			
			//자바에 등록되어있는 파일 읽어오기
			Properties props=System.getProperties();
			System.out.println(props.getProperty("java.version"));
			System.out.println(props.getProperty("user.language"));
			props.list(System.out);
			
			//파일 저장
			Properties props2=new Properties();
			props2.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
			props2.setProperty("url", "jdbc:oracle:thin:@localhost:1521:XE");
			props2.setProperty("username", "hr");
			props2.setProperty("password", "happy");
			try {
				props2.store(new FileOutputStream("db.properties"), "데이터베이스 정보");
				props2.storeToXML(new FileOutputStream("db.Xml"), "database info");
			} catch(Exception e) {}
		} catch(Exception e) {}

	}

}
