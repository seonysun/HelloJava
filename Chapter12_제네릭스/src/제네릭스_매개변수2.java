import java.util.*;

class Sawon{
	private int sabun;
	private String name;
	private String dept;
	private String loc;
	private int pay;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public Sawon(int sabun, String name, String dept, String loc, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.loc = loc;
		this.pay = pay;
	}
	public Sawon() {}
}
public class 제네릭스_매개변수2 {

	public static void main(String[] args) {
		ArrayList<Sawon> list=new ArrayList<Sawon>(); //사용자정의 데이터형
		list.add(new Sawon(1,"홍길동","개발부","서울",3700));
		list.add(new Sawon(2,"이순신","기획부","경기",4200));
		list.add(new Sawon(3,"강감찬","인사부","부산",3000));
		for(Sawon sa:list)
			System.out.println(sa.getSabun()+"."+sa.getName()+":"+sa.getDept()+"("+sa.getLoc()+")");

	}

}
