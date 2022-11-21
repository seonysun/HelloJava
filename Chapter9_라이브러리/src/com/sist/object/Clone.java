package com.sist.object;

//clone 클래스
class Sawon implements Cloneable{ //클래스 복제 시에는 Clonable 인터페이스 구현
	private String name;
	private String dept;
	private String loc;
	@Override //인터페이스(implements) 메소드 오버라이딩
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
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
}
public class Clone {

	public static void main(String[] args) throws Exception{
											//인터페이스 메소드가 예외 간접처리
		Sawon sa=new Sawon();
		sa.setName("홍길동");
		sa.setDept("개발부");
		sa.setLoc("서울");
		
		Sawon copy=(Sawon)sa.clone();
					//인터페이스에서 가져온 clone() 리턴형이 Object이므로 형변환 필요
		System.out.println("sa:"+sa);
		System.out.println("copy:"+copy); //clone이므로 서로 주소값 다름
		Sawon sa1=new Sawon();
		System.out.println("sa1:"+sa1);
		Sawon sa2=sa;
		System.out.println("sa2:"+sa2);
		
		System.out.println("sa.name="+sa.getName());
        System.out.println("sa.dept="+sa.getDept());
        System.out.println("sa.loc="+sa.getLoc());
        System.out.println("sa1.name="+sa1.getName());
        System.out.println("sa1.dept="+sa1.getDept());
        System.out.println("sa1.loc="+sa1.getLoc());
        System.out.println("copy.name="+copy.getName());
        System.out.println("copy.dept="+copy.getDept());
        System.out.println("copy.loc="+copy.getLoc());

	}

}
