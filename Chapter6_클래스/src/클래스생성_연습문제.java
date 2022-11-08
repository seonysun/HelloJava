class Moviee{
	String mposter, name, opendate, janre, nation, rating, runtime;
	double mscore;
	int attendance, rank;
	String etc;
}
class Food{
	String fposter, title;
	double fscore;
	String fadd, ftel, ftype, price, parking, opentime, menu;
}
class Recipe{
	String rposter, rmpic, rid, rtitle, state;
}
class Member{
	String id, pw, pwcheck, name, nic, idnum, birth, sex, email;
	boolean ereceive;
	String postnum, maddr, mtel, mmobile, job, hobby, mstate;
}
class Goods{
	String gposter, gtitle, subtitle;
	int dis, gprice;
	String disc, coupon;
	int gscore, review;
	String ship;
}
class News{
	String comp;
	int uptime;
	String site, state, pic;
}
class Shop{
	String spic, stel, website, homelang, stime, holiday, etc, saddr, traffic;
}
class Board{
	
}
public class 클래스생성_연습문제 {

	public static void main(String[] args) {
		Moviee mov1=new Moviee();
		mov1.name="동감";
		mov1.opendate="2022.11.16";
		mov1.janre="로맨스/멜로";
		mov1.nation="한국";
		mov1.rating="12세이상관람가";
		mov1.runtime="114분";
		mov1.mscore=8.7;
		mov1.attendance=247;
		mov1.rank=2;
		mov1.etc="1999년, '용'은 첫눈에 반하게 된 '한솔'을 사로잡기 위해 친구에게 HAM 무전기를 빌린다.";
		
		Food food1=new Food();
		Recipe recipe1=new Recipe();
		Member signin=new Member();
		Goods goods1=new Goods();
		News news1=new News();
		Shop shop1=new Shop();
		Board board1=new Board();
		
		
	}

}
