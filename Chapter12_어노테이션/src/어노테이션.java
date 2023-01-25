import java.lang.reflect.Method;
import java.util.*;

/*
 * 1. 어노테이션
 * 	- 소스 코드 안에서 정리(주석) -> 기능은 없고 검색 도와주는 역할
 * 	- 스프링, 마이바티스, JPA에서 주로 사용
 * 	- 구분자 (인덱스, 검색용) -> if문 대체, switch문
 * 	- 사용법 : @어노테이션명
 * 		- 라이브러리, 사용자 지정
 *  - 종류
 *  	@ 클래스 구분(TYPE)
 * 		public class A{
 * 			- @Controller, @RestController, @Repository, @Service, @Component, @ControllerAdvice 
 * 		@ 멤버변수 구분(FIELD)
 * 		private B b;
 * 			- @Autowired, @Resource
 * 		@ 생성자 구분(CONSTRUCTOR)
 * 		public A(){}
 * 			- @Autowired
 * 		@ 메소드 구분(METHOD)
 * 		public void display(@ 매개변수 구분(PARAMETER) B b){}
 * 			- @RequestMapping, @GetMapping, @PostMapping
 * 	- 주요 어노테이션
 * 		- @Override : 메소드 오버라이딩
 * 		- @Deprecated : 새로운 메소드 있음 경고
 * 		- @SuperessWarnings : 경고 나타나지 않게 함
 * 		- @FuntionallInterface : 람다식 설정
 * 
 * 2. 사용자 정의 
 *   - Target : 구분자 
 *      클래스 : Target(TYPE) 
 *      		cf. type(클래스와 관련) : 클래스형, 인터페이스, 열거형 
 *      @
 *      class ClassName {
 *         --------------------
 *          변수 : Target(FIELD)
 *            => 일반변수는 사용하지 않는다 
 *          @
 *          ClassName c;
 *         --------------------
 *          메소드 : Target(METHOD)
 *          @
 *          public void display() {
 *          }
 *         --------------------
 *          public void display(@ ) 매개변수 : Target(PARAMETER)
 *         --------------------
 *          생성자 : Target(CONSTRUCTOR) 
 *          @
 *          public 생성자() {
 *          }
 *      }
 * */

class Board{
	@RequestMapping("write.do") //구분자("write.do") 이용 시 메소드 write() 호출
	public void write() {
		System.out.println("글쓰기 처리");
	}
	@RequestMapping("list.do")
	public void list() {
		System.out.println("게시물 목록 출력");
	}
	@RequestMapping("update.do")
	public void update() {
		System.out.println("게시물 수정");
 	}
	@RequestMapping("delete.do")
	public void delete() {
		System.out.println("게시물 삭제");
	}
	@RequestMapping("find.do")
	public void find() {
		System.out.println("게시물 검색");
	}
	@RequestMapping("detail.do")
	public void detail() {
		System.out.println("상세보기");
	}
}
public class 어노테이션 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("기능 요청:");
		String cmd=scan.next();
		
		/*
		Board board=new Board();
		if(cmd.equals("write.do")) //메소드 호출 시 조건문으로 쓰면 너무 복잡 -> 어노테이션으로 호출
			board.write();
		else if(cmd.equals("list.do"))
			board.list();
		else if(cmd.equals("update.do"))
			board.update();
		else if(cmd.equals("delete.do"))
			board.delete();
		else if(cmd.equals("find.do"))
			board.find();
		else if(cmd.equals("datail.do"))
			board.detail();
		 */
		
		try {
			//클래스 정보 읽기 
        	Class clsName=Class.forName("com.sist.Board");
        	//메모리 할당 
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	//클래스안에 선언된 모든 메소드 읽기 
        	Method[] methods=clsName.getDeclaredMethods();
        	for(Method m:methods) {
        		RequestMapping rm=m.getAnnotation(RequestMapping.class);
        		//Method위에 있는 메소드 찾기 
        		if(rm.value().equals(cmd)) {
        			m.invoke(obj, null); //메소드 호출 
        			break;
        		}
        	}
        }catch(Exception ex) {}
		
	}

}
