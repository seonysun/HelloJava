import java.io.*;
import java.util.*;
class Student1
{
	private int hakbun;
	private String name;
	private int eng,math,kor;
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
}
public class FileWriter_ {

	public static void main(String[] args) {
		// 학생목록 
		ArrayList<Student1> list=new ArrayList<Student1>();
			try
			{
				String data="1|홍길동|90|80|90\n"
						   +"2|박문수|75|88|87\n"
						   +"3|심청이|65|78|98\n"
						   +"4|이순신|56|89|67\n"
						   +"5|강감찬|78|87|92";
				FileWriter fw=new FileWriter("c:\\java_data\\student.txt");
				fw.write(data);
				fw.close();
				System.out.println("데이터 저장 완료!!");
			}catch(Exception ex){}
			
	}
	
}
