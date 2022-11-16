package com.sist.model;
import java.util.Scanner;

public class MainClass {
	public static int menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("======== MENU ========");
		System.out.println("1.HOME");
		System.out.println("2.회원가입");
		System.out.println("3.영화");
		System.out.println("4.공지사항");
		System.out.println("5.게시판");
		System.out.println("6.종료");
		System.out.println("======================");
		System.out.print("메뉴 선택:");
		return scan.nextInt();
	}
	public static void main(String[] args) {
		Move mm=null;
			//각각의 개체를 만들 필요 없이 인터페이스 형성해서 클래스 여러개 묶음
			//1개의 메모리에 저장된 주소값 바꾸기 -> 메모리 누수현상 방지
		while(true) {
			int m=menu();
			switch(m) {
			case 1: 
				mm=new Home();
				mm.move();
				break;
			case 2: 
				mm=new Join();
				mm.move();
				break;
			case 3: 
				mm=new Movie();
				mm.move();
				break;
			case 4: 
				mm=new Notice();
				mm.move();
				break;
			case 5: 
				mm=new Board();
				mm.move();
				break;
			case 6: 
				System.out.println("사이트를 종료합니다!");
				System.exit(0);
			}
		}

	}

}
