package com.sist.exception;

import java.util.Scanner;

public class Main {
	public static int menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("===MENU===");
		System.out.println("1. Top200");
		System.out.println("2. 가요");
		System.out.println("3. POP");
		System.out.println("4. OST");
		System.out.println("5. 트롯");
		System.out.println("6. Jazz");
		System.out.println("7. 클래식");
		System.out.println("8. EXIT");
		System.out.println("==========");
		System.out.print("메뉴 선택:");
		return scan.nextInt();
	}
	public static void main(String[] args) throws Exception{
		MusicSystem ms=new MusicSystem();
		while(true) {
			int m=menu();
			if(m==8) {
				System.out.println("프로그램 종료");
				break;
			} else {
				try {
					MusicVO[] music=ms.musicData(m);
					for(int i=0;i<music.length;i++) {
						System.out.println((i+1)+". "+music[i].getTitle());
					}
				} catch(Exception e) {	
					
				} finally {
					System.out.println("출력 완료!");
				}
			}
		}
		
	}

}
