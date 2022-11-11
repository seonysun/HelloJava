/*
 * 1. 접근지정어 : 접근 범위의 설정
 * 	1) 종류
 * 		- private : 자신의 클래스에서만 접근 가능 -> 은닉화
 * 		- default : 같은 패키지에서만 접근 가능
 * 		- protected : 같은 패키지에서 접근 가능, 다른 패키지에서 상속 과정이 있으면 접근 가능
 * 		- public : 모든 클래스에서 접근 가능
 * 		- 접근 범위 :
 * 					자신 클래스에서만  같은 패키지에서만  같은 패키지&상속패키지  모든 클래스
 * 		------------------------------------------------------------------
 * 		private			 O(변수)
 * 		------------------------------------------------------------------
 * 		default			 O				O
 * 		------------------------------------------------------------------
 * 		protected		 O				O				O
 * 		------------------------------------------------------------------
 * 		public			 O				O				O			 O
 * 
 * 	2) 접근지정어의 활용 -> 캡슐화
 * 		- 가급적이면 변수빼고 public으로 사용
 * 		- 클래스 : public
 * 		- 생성자 : public
 * 		- 메소드 : public
 * 		- 멤버변수 : private로 은닉화 -> 다른 클래스에서 사용 시에 메소드 통해서 연결(직접 연결 불가)
 * 
 * 	3) 사용법
 * 		- 변수 : [접근지정어] 데이터형 변수명;
 * 		- 메소드 : [접근지정어] 리턴형 메소드명(매개변수){}
 * 		- 클래스 : [접근지정어] class 클래스명{}
 * 		- 접근지정어는 맨 앞에 와야 하지만 static과 public은 순서 관계 없음
 * 		- 멤버(클래스영역)에서만 사용 가능, 지역변수(메소드영역)는 사용 불가
 *			cf. 키워드
 *				 - 클래스 : public, default, final, abstract(추상클래스)
 *				 - 메소드 : 모든 접근 지정어, final, abstract, static
 * 				 - 멤버변수 : 모든 접근 지정어(주로 private), final, static
 * 				 - 지역변수 : final
 * 				 - 생성자 : public, default
 * 
 * 2. 캡슐화
 * 	- 데이터 보호 목적
 * 	- 경계 범위 : 관련된 것만 묶어서 작업할 수 있도록 설정
 * 				ex. 이름 나이 주민번호 성별 차량종류 업체명 키 나이 연식 색상
 * 					-> 이름 나이 주민번호 성별 키 나이 / 차량종류 업체명 연식 색상
 * 	- 변수 은닉화 -> 다른 클래스에서 사용 불가 -> 변수 읽기(get)/쓰기(set) 기능만 첨부하여 접근 가능하도록 설정
 * */

class Saram{
	private String name;
	public String address;
	public String getName() { //읽기 : get
		return name;
	}
	public void setName(String name) { //쓰기 : set
		this.name=name;
	}
		//get, set으로 변수 관리 -> 캡슐화(변수에 직접 접근하지 않고 데이터 보호)
}
public class 접근지정어 {

	public static void main(String[] args) {
		Saram s=new Saram();
		s.setName("홍길동");
		System.out.println(s.getName());

	}

}
