import java.io.*;
import java.util.*;

public class FileOutputStream_ {

	public static void main(String[] args) {
		try {
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\sawon.txt",true);
			Scanner scan=new Scanner(System.in);
			Sawon sa=new Sawon();
			System.out.print("사번 입력:");
			sa.setSabun(scan.nextInt());
			System.out.print("이름 입력:");
			sa.setName(scan.next());
			System.out.print("부서명 입력:");
			sa.setDept(scan.next());
			System.out.print("근무지 입력:");
			sa.setLoc(scan.next());
			String save=sa.getSabun()+"|"+sa.getName()+"|"+sa.getDept()+"|"+sa.getLoc()+"\n";
			System.out.println(Arrays.toString(save.getBytes()));
												//한글을 1byte로 바꿈
			System.out.println("사원 저장 완료.");
		}catch (Exception e) {}

	}

}
class Sawon{
	private int sabun;
	private String name;
	private String dept;
	private String loc;
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
}
