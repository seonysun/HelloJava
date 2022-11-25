package com.sist.map;
import java.util.*;

/*
 * 3) Map -> 우편번호
 * 		- 키(key) + 값(value) 쌍으로 저장; Map<K,V>
 * 			-> key는 중복 불가, value는 중복 가능
 * 			-> key 이용해서 value 얻는 방식으로 구현
 * 			ex. id = admin
 * 		- 사용처
 * 			- 클래스관리(외부 지원 라이브러리; Spring, MyBatis), 요청값관리, 전송값관리 시 주로 사용
 * 			- 웹에서 지원하는 모든 클래스 : Map 형식
 * 				-> HttpServletRequest : 사용자가 보내주는 데이터
 * 				   HttpServletResponse : 사용자 요청 처리 결과 브라우저로 전송
 * 			   	   HttpSession : 서버에 데이터 저장
 * 			   	   Cookie : 사용자의 브라우저에 저장
 * 		- 구현된 클래스
 * 			- Hashtable
 * 			- HashMap(*) : Hashtable의 단점 보완
 * 		- 주요메소드
 * 			- put(String key, Object value) : 데이터 추가
 * 			- get(String key) : 데이터 읽기
 * 			- keySet() : key 모아서 가져옴
 * 			- values()
 * */

public class Map_ {

	public static void main(String[] args) {
		Map map=new HashMap();
		map.put("id", "admin");
		map.put("password", "1234");
		map.put("name", "홍길동");
		map.put("sex", "남자");
		map.put("age", "25");
		map.put("password", "4567"); //key가 중복되면 덮어쓰기
		
		//출력
		System.out.println("ID:"+map.get("id"));
		System.out.println("PW:"+map.get("password"));
		System.out.println("이름:"+map.get("name"));
		System.out.println("성별:"+map.get("sex"));
		System.out.println("나이:"+map.get("age"));
		System.out.println();
		
		Set s=map.keySet(); //key만 저장(중복 없이-> Set)
		System.out.println(s);
		for(Object obj:s) {
			String key=(String)obj;
			System.out.println(key+":"+map.get(key));
		}

	}

}
