class Member{
	int mno=1;
	String name="홍길동";
	String address="서울";
	String tel="010-1111-1111";
	Member(){
		
	}
	Member(String name, String address, String tel){
		++mno; //회원번호는 자동입력되도록 처리
		this.name=name;
		this.address=address;
		this.tel=tel;
	}
	Member(int mno, String name, String address, String tel){
		this.mno=mno;
		this.name=name;
		this.address=address;
		this.tel=tel;
	}
	void print() {
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
		System.out.println("주소:"+address);
		System.out.println("전화:"+tel);
		System.out.println();
	}
}
class Moovie{
	int mno;
	String title;
	String genre;
	Moovie(){
		//매개변수 생성자가 있으므로 기본생성자 자동 생성 안됨 -> 클래스영역에서 변수가 선언만 되었으므로 기본값 초기화 필요하면 만들어줘야 함
	}
	Moovie(Moovie m){
			//객체 생성할 때 이전에 생성된 객체의 데이터 이용하는 경우에 주로 사용(인스턴스 복사)
		this.mno=m.mno;
		title=m.title;
		genre=m.genre;
	}
	void print() {
		System.out.println("mno:"+mno);
		System.out.println("title:"+title);
		System.out.println("genre:"+genre);
		System.out.println();
	}
}
public class 생성자2 {

	public static void main(String[] args) {
		Member m1=new Member();
		m1.print();
		Member m2=new Member("박문수","경기","010-2222-2222");
		m2.print();
		Member m3=new Member(3,"이순신","부산","010-3333-3333");
		m3.print();
		Member m4=new Member("강감찬","인천","010-4444-4444");
		m4.print();
		
		
		//
		Moovie v1=new Moovie();
		v1.mno=1;
		v1.title="홍길동전";
		v1.genre="액션";
		v1.print();
		
		Moovie v2=new Moovie(v1);
		v2.print();
		
		v1.mno=10;
			//v1과 v2는 별도로 저장된 각각의 인스턴스 -> 값 변경 시 v1에만 적용
		v1.print();
		v2.print();
		
	}

}
