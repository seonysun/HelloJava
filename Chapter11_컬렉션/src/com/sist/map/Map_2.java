package com.sist.map;
import java.util.*;

interface Model{
	public void execute();
}
class BoardModel implements Model{
	public void execute() {
		System.out.println("게시판 처리");
	}
}
class NoticeModel implements Model{
	public void execute() {
		System.out.println("공지사항 처리");
	}
}
class ReserveModel implements Model{
	public void execute() {
		System.out.println("예약 처리");
	}
}
class Container{
	private Map map=new HashMap();
	public Container() {
		map.put("board", new BoardModel());
		map.put("notice", new NoticeModel());
		map.put("reserve", new ReserveModel());
	}
	public Model getBean(String key) {
		return (Model)map.get(key);
	}
}
public class Map_2 {

	public static void main(String[] args) {
		Container c=new Container();
		Scanner scan=new Scanner(System.in);
		System.out.print("메뉴 선택:");
		String menu=scan.next();
		
		Model m=c.getBean(menu);
		m.execute();

	}

}
