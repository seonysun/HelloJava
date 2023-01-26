import java.util.*;
import java.io.*;

/*
 * 1. 직렬화 : 객체를 데이터 스트림(연속적인 데이터)으로 만드는 것
 * 		- ObjectOutputStream
 * 	  역직렬화 : 연속적인 데이터(데이터 스트림)를 다시 객체 형태로 변경
 * 		- ObjectInputStream
 * 
 * 2. 키워드
 * 	- Serializable : 직렬화 -> Object 자체 저장
 * 	- transient : 직렬화에서 제외
 * 	- synchronized : 동기화
 * */

class Sawon11 implements Serializable{
	private int sabun;
	private String name;
	private String dept;
	private String loc;
	private String job;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Sawon11(int sabun, String name, String dept, String loc, String job) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.loc = loc;
		this.job = job;
	}
	public Sawon11() {}
}
public class ObjectStream_ {

	public static void main(String[] args) {
		ArrayList<Sawon11> list=new ArrayList<Sawon11>();
		list.add(new Sawon11(1,"홍길동","개발부","서울","대리"));
		list.add(new Sawon11(2,"김두한","기획부","부산","사원"));
		list.add(new Sawon11(3,"이순신","자재부","제주","과장"));
		list.add(new Sawon11(4,"강감찬","총무부","인천","사원"));
		list.add(new Sawon11(5,"박지성","개발부","서울","부장"));
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c:\\java_data\\sawon1.txt"));
			oos.writeObject(list);
			oos.close();
			System.out.println("저장 완료!");
		} catch(Exception e) {}

		ArrayList<Sawon11> list1=new ArrayList<Sawon11>();
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("c:\\java_data\\sawon1.txt"));
			list=(ArrayList<Sawon11>)ois.readObject();
			ois.close();
			for(Sawon11 s:list1) {
				System.out.println(s.getSabun()+"."+s.getName()+":"+s.getDept()+" "+s.getLoc()+" "+s.getJob());
			}
		} catch(Exception e) {}
		
	}

}
