import java.io.*;
import java.util.*;
//빅데이터를 저장할때 => 분석, 마이닝 => 아파치로그
/*
 * 키워드
 * 	- Serializable : 직렬화 -> Object 자체 저장
 * 	- transient : 직렬화에서 제외
 * 	- synchronized : 동기화
 */

class Student implements Serializable{
	private int hakbun;
	private String name;
	transient private String subject;
		//직렬화 시 제외
	private int kor,eng,math;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
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
	public Student(int hakbun, String name, String subject, int kor, int eng, int math) {
		this.hakbun = hakbun;
		this.name = name;
		this.subject = subject;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Student() {}
}
class School{
	private static ArrayList<Student> list=new ArrayList<>();
	/* //맨 처음 한 번만 실행해야 추가로 저장된 학생 데이터가 초기화되지 않음
	 static {
		list.add(new Student(1,"홍길동","수학과",80,90,78));
		list.add(new Student(2,"김두한","컴공과",85,92,70));
		list.add(new Student(3,"박문수","수학과",86,93,60));
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c:\\java_data\\student.txt"));
			oos.writeObject(list);
			oos.close();
		} catch(Exception e) {}
	}
	*/
	//메뉴
	public int menu() {
		Scanner scan=new Scanner(System.in);
		System.out.println("학생 관리 메뉴=====");
		System.out.println("1. 학생 목록");
		System.out.println("2. 상세보기");
		System.out.println("3. 학생 찾기");
		System.out.println("4. 학생 등록");
		System.out.println("5. 종료");
		System.out.print(".> ");
		return scan.nextInt();
	}
	//학생저장
	public void studentSave(Student s) {
		list.add(s);
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c:\\java_data\\student.txt"));
			oos.writeObject(list);
			oos.close();
		} catch(Exception e) {}
	}
	//학생목록
	public ArrayList<Student> studentListData(){
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("c:\\java_data\\student.txt"));
			list=(ArrayList<Student>)ois.readObject();
			ois.close();
		} catch(Exception e) {}
		return list;
	}
	//학생상세
	public Student studentDetailData(int hakbun) {
		Student s=new Student();
		for(Student ss:list) {
			if(ss.getHakbun()==hakbun) {
				s=ss;
				break;
			}
		}
		return s;
	}
	//학생찾기
	public ArrayList<Student> studentFindData(String name){
		ArrayList<Student> sList=new ArrayList<Student>();
		for(Student ss:list) {
			if(ss.getName().contains(name))
				sList.add(ss);
		}
		return sList;
	}
	//종료
	public void exit() {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("c:\\java_data\\student.txt"));
			oos.writeObject(list);
			oos.close();
			System.out.println("저장 완료.");
		} catch(Exception e) {}
	}
	public void process() {
		while(true) {
			int m=menu();
			switch(m) {
			case 1:{
				ArrayList<Student> sList=studentListData();
				for(Student s:sList)
					System.out.println(s.getHakbun()+"."+s.getName()+":"
							+s.getKor()+" "+s.getEng()+" "+s.getMath()+" "+String.format("%.2f", (s.getKor()+s.getEng()+s.getMath())/3.0));
			}
				break;
			case 2:{
				Scanner scan=new Scanner(System.in);
				String hak="";
				for(Student s:list) {
					hak+=s.getHakbun()+",";
				}
				hak=hak.substring(0,hak.lastIndexOf(","));
				System.out.print("학생 선택("+hak+"):");
				int i=scan.nextInt();
				Student ss=studentDetailData(i);
				System.out.println("<상세보기>");
				System.out.println("학번:"+ss.getHakbun());
				System.out.println("이름:"+ss.getName());
				System.out.println("국어:"+ss.getKor());
				System.out.println("영어:"+ss.getEng());
				System.out.println("수학:"+ss.getMath());
			}
				break;
			case 3:{
				Scanner scan=new Scanner(System.in);
				System.out.print("학생 이름 입력:");
				String name=scan.next();
				ArrayList<Student> sList=studentFindData(name);
				for(Student s:sList)
					System.out.println(s.getHakbun()+"."+s.getName()+":"
							+s.getKor()+" "+s.getEng()+" "+s.getMath()+" "+String.format("%.2f", (s.getKor()+s.getEng()+s.getMath())/3.0));
			}
				break;
			case 4:{
				Scanner scan=new Scanner(System.in);
				int max=0;
				for(Student s:list) {
					if(s.getHakbun()>max)
						max=s.getHakbun();
				}
				Student s=new Student();
				s.setHakbun(max+1);
				System.out.print("이름 입력:");
				s.setName(scan.next());
				System.out.print("국어:");
				s.setKor(scan.nextInt());
				System.out.print("영어:");
				s.setEng(scan.nextInt());
				System.out.print("수학:");
				s.setMath(scan.nextInt());
				
				studentSave(s);
			}
				break;
			case 5:{
				exit();
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			default:
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
}
public class ObjectOutput {
	public static void main(String[] args) {
		School s=new School();
		s.process();

	}

}
