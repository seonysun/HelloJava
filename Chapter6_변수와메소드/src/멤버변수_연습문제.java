class SignUp{
	String id;
	String name;
	String pw, pwHint, pwHintA;
		//비밀번호 확인은 저장하지 않음 -> pw를 이용해서 동일 여부 체크
	String sex;
	String tel, fax, phone;
	String email;
	String post, addr, addrdetail;
}
class 사원정보{
	int empNo;
	String ename;
	String job;
	String mgr;
	String hireDate;
	int sal;
	String comm;
	int deptNo;
}
class Board{
	int num;
	String writer, title, wDate;
		//페이지나 글쓰기 버튼은 메소드로 처리해야 함
}
class Category{
		//class -> 카테코리 1개에 대한 정보만 저장 -> 이후 배열로 설정해서 여러개 출력
	String poster;
		//그림은 파일명이 들어가므로 String
	String title;
	String detail;
}
class 맛집{
	String title;
	int score;
	String addr, tel, type, price, parking, opentime, breaktime, holiday;
	String[] menu;
}
class Movie{
	String poster;
	String title;
	boolean isOpen;
	String openDate, jenre, nation, grade, runTime;
	int score, audience, rank;
	String cookie, detail;
}
class Recipe{
	String poster, title, writer;
	int score, review, viewer;
}
class MemberRank{
	int rank;
	String pic, nickName;
	int recipe, file, viewer, friends;
}
public class 멤버변수_연습문제 {

	public static void main(String[] args) {

	}

}
