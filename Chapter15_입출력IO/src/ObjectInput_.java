import java.util.*;
import java.io.*;

/*
 * 직렬화 : 객체를 데이터 스트림으로 만든 것
 * 역직렬화 : 연속적인 메모리 구조(데이터 스트림)를 다시 객체 형태로 변경
 * 
 * 
 * ------------------------------------------
 * 자바/오라클 => 웹(80%)
 * 		------------------
 * 		=> 자바 (JSP/Spring)
 * 	    IO (InputStream, OutputStream)
 * 		=> 입출력
 * 		 	= 메모리 입출력
 * 			  System.in / System.out
 * 			  BufferedReader
 * 			= 파일 입출력 (가장 많이 사용되는 입출력) ==> 웹
 * 			  FileInputStream / FileOutputStream
 * 			  FileReader / FileWriter
 * 			  ObjectInputStream / ObjectOutputStream
 * 			  => 보조 스트림
 * 				 BufferedInputStream / BufferedOutputStream
 * 				 BufferedReader 	 / BufferedWriter
 * 				 *** Stream / OutputStream ==> 바이트 스트림 (읽기/쓰기 => 1byte) => 한글제어가 아니라
 * 																 => 파일 복사/ 업로드 / 다운로드
 * 																 => zip.mpg ...
 * 																 => 그림파일, 동영상
 * 				 *** Reader / Writer ==> 문자 스트림 (읽기/쓰기 => 2byte) => 한글 출력 / 한글 읽기
 * 					-------------------------------------------------------------------
 * 			= 네트워크 입출력 : 네트워크 => 전송할떄 1byte (OutputStream), 받을떄 2byte (Reader)
 * 								    => Stream(1byte) => Reader(2byte)
 * 									   InputStreamReader
 * 			= 객체단위 데이터 입출력
 * 			  ---------------
 * 			  입력 => ObjectInputStream
 * 			  출력 => ObjectOutputStream
 * 			  직렬화 / 역직렬화
 * 			  ----	 -----
 * 			  직렬화 : 객체를 데이터스트림 형태로 만든것
 * 						  -------- 읽기/쓰기를 하기위해 반드시 메모리가 연속적으로 구성돼야함
 * 		 	  역직렬화 : 연속적인 메모리구조를 객체형태로 변경
 * 			  => 객체형태를 -> 배열형태로 변경
 * 			  => 저장되는 데이터 : Serializable (interface)
 * 			  class Sawon implements Serializable {
 * 		
 * 			  }	
 * 			   => 객체단위 저장
 * 			   => readObject()
 * 			   => writeObject()
 * 			   => close()
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
public class ObjectInput_ {

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
