package com.sist.list;
import java.util.*;

class Sawon{
	private int sabun;
	private String name;
	private String dept;
	private String loc;
	private int pay;
	public Sawon(int sabun, String name, String dept, String loc, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.loc = loc;
		this.pay = pay;
	}
	public Sawon() {
		
	}
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
}
public class ArrayList_2 {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add(new Sawon(1,"홍길동","개발부","서울",3000));
		list.add(new Sawon(2,"심청이","기획부","경기",3500));
		list.add(new Sawon(3,"박문수","자재부","경기",3200));
		list.add(new Sawon(4,"이순신","영업부","서울",4000));
		list.add(new Sawon(5,"강감찬","총무부","부산",4500));
		
		for(int i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
				//메소드를 받아와야 하므로 Object로 받을 수 없음, 형변환 형태로
			System.out.println("사번 "+s.getSabun()+
					":"+s.getName()+"/"+s.getDept()+
					"/"+s.getLoc()+"/"+s.getPay());
		}
		System.out.println();
		
		//사원 추가
		Scanner scan=new Scanner(System.in);
		Sawon sa=new Sawon();
		System.out.print("이름 입력:");
		sa.setName(scan.next());
		System.out.print("부서 입력:");
		sa.setDept(scan.next());
		System.out.print("근무지 입력:");
		sa.setLoc(scan.next());
		System.out.print("연봉 입력:");
		sa.setPay(scan.nextInt());
		int max=0; //사번은 자동 설정(마지막 번호 다음으로)
		for(int i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
			if(max<s.getSabun())
				max=s.getSabun();
		}
		sa.setSabun(max+1);
		
		list.add(sa);
		
		for(int i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
			System.out.println("사번:"+s.getSabun()+
					" "+s.getName()+"/"+s.getDept()+
					"/"+s.getLoc()+"/"+s.getPay());
		}
		System.out.println();
		
		//검색-이름
		System.out.print("이름 입력:");
		String name=scan.next();
		for(int i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
			if(s.getName().equals(name)) {
				System.out.println(s.getName()+"/"+s.getDept()+
						"/"+s.getLoc()+"/"+s.getPay());
				break;
			}
		}
		System.out.println();
		
		//검색-부서
			//부서명 찾기
		ArrayList deptList=new ArrayList();
		for(int i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
			deptList.add(s.getDept());
		}
			//중복 제거
		HashSet hs=new HashSet();
		for(int i=0;i<deptList.size();i++) {
			hs.add(deptList.get(i));
		}
		int i=1;
		for(Object obj:hs) {
			System.out.println(i+"."+obj);
			i++;
		}
			//해당 부서 사원 찾기
		System.out.print("부서명 입력:");
		String dept=scan.next();
		for(i=0;i<list.size();i++) {
			Sawon s=(Sawon)list.get(i);
			if(s.getDept().equals(dept))
				System.out.println(s.getName()+"("+s.getDept()+")");
		}

	}

}
