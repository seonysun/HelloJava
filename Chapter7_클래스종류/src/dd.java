/*
 *    1. 클래스 
 *       -----
 *       구성요소 
 *        1) 변수 
 *            = 인스턴스 변수(객체마다 따로 저장하는 변수)
 *            = 정적 변수 (한개만 저장하는 변수 => 데이터베이스 (오라클)) ==> 공유데이터 (웹)
 *        2) 메소드 : 한가지 기능을 수행하는 명령문의 집합 
 *                  다른 클래스와 통신 
 *        3) 생성자 : 초기화 담당 , 처음 시작할때 동작 
 *        ------------------------------------- 무조건 추가 (생성자) : 없는 경우에는 자동 추가(디폴트 생성자)
 *            | 객체 => 생성 => 자동 동작 => 필요한 데이터값을 추가 
 *              예) 데이터베이스 연결 , 서버 연결 , 윈도우에서 화면 UI 
 *            | 생성자를 사용하지 않는 경우 ==> 초기화 블록 
 *              초기화 블록 => 인스턴스 초기화 블록  , 정적변수 초기화 블록
 *                          --------------- {} --------------- static{}
 *              => 기본값 => 명시적 초기화 => 초기화블록 => 생성자 
 *                 int :0 , double:0.0 , boolean:false,모든 클래스: null
 *                 => 초기화블록 / 생성자 => 동시에 사용하는 것은 거의 없다 
 *                 *** 인스턴스 (생성자) , static => static{} => 생성자를 호출할 필요가 없다 
 *                 --------------------------------------------------------------
 *                 클래스내에서 선언되는 내용 : 멤버변수 , 멤버메소드 
 *                 *** 클래스 {}안에서는 구현할 수 없고 선언만 가능하다.
 *                     int a=10; 
 *                     int a;
 *                     a=10;//구현 => 연산자 , 메소드 호출 , 제어문 ==> {}:초기화블록 , 메소드{} , 생성자{}
 *                 *** 초기화블록은 자동처리 , 상속예외 조건 
 *     2. 클래스 
 *        1) 클래스 설계
 *        2) 클래스 메모리에 저장 ==> 저장하는 과정 (인스턴스화) ==> 저장된 상태 (인스턴스,객체)
 *           클래스명 객체=new 클래스명() ==> new 연산자는 메모리를 따로 메모리가 생성 
 *        3) 활용 :
 *           객체.변수 , 객체.메소드() ....
 *        4) 소멸 
 *           객체=null; (주소값을 지운다) ==> GC
 *        *** 인스턴스 호출 
 *            객체명.변수명, 객체명.메소드명()
 *            scan.nextInt()
 *        *** static 호출    
 *            클래스명.메소드명 , 클래스명.변수명 (Math.random(),String.value())
 *     3. 클래스 설계 
 *        1) 사용자 정의 데이터형 (관련된 데이터만 모아서 저장) => 데이터타입형 (캡슐화) => ~VO,~DTO,~Bean
 *        2) 기능 (메소드) => ~DAO , ~Manager , ~Service , ~Controller , ~Model
 *                         -----  -------- 데이터 수집 
 *                          | 데이터베이스 연결  
 *     4. 접근지정어 : 접근 범위 확인 
 *        -------------------------------------------------------------
 *              자신의 클래스   같은 패키지     다른 패키지            모든 클래스  
 *                                       상속을 받은 경우
 *        -------------------------------------------------------------
 *     private    O 
 *        -------------------------------------------------------------
 *     default    O             O
 *        -------------------------------------------------------------
 *   protected    O             O            O
 *        -------------------------------------------------------------
 *      public    O             O            O                  O
 *        -------------------------------------------------------------
 *        
 *        = 멤버변수 : 데이터 보호 => 다른 클래스에서 접근이 불가능 => private (은닉화)
 *        = 메소드 : 다른 클래스와 통신 => public 
 *        = 클래스 : 다른 클래스에서 메모리 할당이 가능 => public 
 *        = 생성자 : 다른 클래스에서 불러서 사용 => public 
 *    ------------------------------------------------------------------
 *    객체지향의 특성을 만든다 (유지보수가 쉽게 제작=> 권장)
 *      = 캡슐화 
 *         데이터보호 동시에 필요시에는 사용이 가능하게 만든다 (변수)
 *           => 변수 (읽기/쓰기) ==> getter/setter 
 *      = 상속/포함 : 재사용 
 *          상속 : 변경이 필요한 경우 => 게시판 => 갤러리게시판  
 *          포함 : 변경없이 사용     => 게시판 => 댓글 
 *          상속 => 예외(초기화블록,생성자,static ,private)
 *                 형식)
 *                     class A extends B
 *                          --         --
 *                       하위클래스      상위 클래스
 *                       B의 모든 내용을 상속을 받아서 A라는 새로운 클래스를 만든다 
 *                       => 단일 상속만 가능하다 
 *                     class A
 *                     {
 *                         B b=new B(); ****** (변경이 가능) => 내부클래스 (익명의 클래스)
 *                     }
 *                          
 *      = 다형성 (오버로딩(new:새로운 기능을 추가),오버라이딩(modify:기존의 기능을 변경)) 
 *      ----------------------------------------------------------------
 *                            오버로딩                  오버라이딩 
 *      ----------------------------------------------------------------
 *        상태              같은 클래스 내                상속이 있는 상태
 *      ----------------------------------------------------------------
 *       메소드              메소드명 동일                 메소드명 동일 
 *      ----------------------------------------------------------------
 *      매개변수           갯수나 데이터형이 다르다            매개변수가 동일 
 *      ----------------------------------------------------------------
 *      리턴형              상관 없다                    리턴형이 동일 
 *      ----------------------------------------------------------------
 *      접근지정어           상관 없다                    접근 지정어가 동일 
 *                                                   확대해서 사용 
 *      접근지정어 범위 
 *                 private < default < protected < public
 *                    ==> 주로 public을 사용한다 
 *        ** 객체의 정의 
 *        ** 캡슐화 VS 은닉화 
 *        ** 오버로딩 VS 오버라이딩 
 *        ** 추상클래스 VS 인터페이스 
 *        ** 제네릭스 
 *        ** ArrayList VS Vector
 *        ** 예외처리 종류 (목적) 
 *        ** 쓰레드의 충돌방지 (동기화시)
 *      ----------------------------------------------------------------
 *      ***
 *          상속 : 생성자가 매개변수를 가지고 있는 클래스를 상속할때 => super()
 *          this => 객체 자신 => 생성자 , 멤버메소드에서만 사용이 가능 (static은 사용이 불가능)
 *                  ** this는 생략이 가능 , 지역변수와 멤버변수가 동일할때 구분시 많이 사용 
 *                  다른 클래스로 현재사용하고 있는 객체를 전송 (윈도우=쓰레드이용)
 *          this() => 자신의 생성자 호출시에 사용 (생성자 => 첫줄에 사용)
 *          super => 상속이 있는 경우 상위 클래스 객체 
 *                   *** 상속을 받으면 하위클래스(상속을 받는 클래스) / 상위클래스(상속을 내리는 클래스)=>하위클래스를 제어하지 못한다
 *                                 => 상위 클래스의 변수나 메소드를 제어 
 *                       상위 클래스 : this 
 *                       하위 클래스 : this , super
 *          super() => 상속 내린 클래스의 생성자 호출 (생성자안에서 사용 => 첫줄)
 *          
 *          예)
 *              public class Parent
 *              {
 *                  public Parent(int a){}
 *                  // 디폴트 생성자는 존재하지 않는다 
 *              }
 *              public class Child extends Parent
 *              {
 *                  public Child()
 *                  {
 *                      // super() ==> super()를 호출하지 않으면 => 자동 호출 
 *                      super(1);
 *                  }
 *              }
 *          
 *              public static void main(String[] arg)
 *              {
 *                  Child c=new Child(); // 오류발생  ==> 1) new Parent() , 2) new Child()
 *                                                        -------------
 *              }
 *              
 *              *** 자동 생성 
 *              1) import java.lang.*; ==> 생략 
 *                        ------------ 자바에서 자주 사용되는 라이브러리 집합 (String , System,Math,Object..)
 *              2) 자바의 모든 클래스:라이브러리 , 사용자 정의 클래스 
 *                 public class A extends Object
 *                               ----------------
 *                 => Object로 부터 상속을 받는다 (Object => 최상위 클래스)
 *              3) 생성자가 없는 경우 => 자동을 생성자를 추가 (디폴트 생성자:매개변수가 없는 생성자)
 *                 public class A
 *                 {
 *                    //  public A(){} => 필요시에만 사용
 *                 }
 *              4) 메소드는 반드시 return을 필요로 한다(한개이상)
 *                 return => 메소드 종료시점 
 *                 void는 return을 생략 할 수 있다 
 *                 public void display()
 *                 {
 *                    // return => 자동으로 추가 
 *                 }
 *              5) 모든 클래스는 예외처리를 가지고 있다 (생략이 가능한 클래스가 존재한다)
 *        지역변수 ==> 반드시 초기화를 해서 사용 
 *          => 메소드안에 선언 변수 , 매개변수 => 메소드나 {}을 벗어나면 자동 삭제가 된다 
 *          public void display()
 *          {
 *              int a=10;
 *              {
 *                 int b=20;
 *                 {
 *                     int c=30;
 *                 }
 *              }
 *          }
 *          ---------------------------------------------------------------
 *          제어자
 *          -----
 *          접근 지정어 : private , protected , public , default
 *          그 외 : static , final , abstract , synchronized
 *          static : 공통적인 
 *          ---------------> 클래스 , 메소드 , 변수 => 지역변수에서는 사용 할 수 없다 
 *          final : 마지막 
 *          --------------> 클래스 , 메소드 , 변수 , 지역변수 
 *                   public final class A => 확장할 수 없는 클래스 (종단 클래스) => 상속을 내리지 못하는 클래스
 *                         => String ,Math , System... (제공한 그대로 사용)
 *                   public final void display(){} : 오버라이딩이 불가능 
 *                   public final int a=10; 변수값 변경이 안된다 
 *          abstract : 추상적인(공통적),미완성 
 *          --------- 추상클래스 / 인터페이스 ==> 관련된 클래스를 모아서 관리 , 서로 관련없는 클래스를 연결 
 *                    사용자 정의 클래스 관리 (스프링)
 *          public abstract class A : 추상 클래스
 *          public interface A : 추상 클래스의 일종 => 추상 클래스의 단점 보완 
 *                                                --------- 단일 상속 
 *                                                --------- 다중 상속 
 *          synchronized : 네트워크나 쓰레드 => 동기화 
 *          
 *          ------------------------------------------------------------------------
 *          조합 
 *          --------------------------------------------
 *           대상              조합 
 *          --------------------------------------------
 *          클래스   public , default , final , abstract
 *                 protected/private (오류)
 *          --------------------------------------------
 *          변수    private (접근지정어 전체) , final, static
 *          --------------------------------------------
 *          메소드   public (접근지정어 전체) , final ,static , abstract
 *          --------------------------------------------
 *          지역변수  final 
 *          --------------------------------------------
 *          
 *          * 메소드에 static/abstract는 동시에 사용이 불가능하다 
 *            접근지정어 / 제어자
 *            public private void disp()  (X)
 *            [접근지정어][제어자] 리턴형 메소드명(매개변수...)
 *            (private|public|protected|default) (final|static|abstract)
 *          * 클래스 abstract | final 동시에 사용 할 수 없다 
 *            [접근지정어][제어자] class ClassName
 *          * 메소드중에 abstract가 있는 경우에 private을 사용하면 않된다
 *          * 메소드중에 private,final을 동시 사용 할 수 없다 
 *          
 *       375page : 추상클래스  : 자신이 메모리 할당을 할 수 없다 , 미완성된 클래스 => 사용시는 구현된 클래스의 주소를 받아서 사용
 *         => class A
 *            class B extends A
 *            
 *            B b=new B(); ==> 불가능 
 *            A a=new B(); ==> (O)
 *            B b1=(B)a;
 *            
 *            /*
	 *   추상 클래스는 
	 *     = 클래스마다 따로 구현 해야 되는 메소드 (선언)
	 *     = 필요시마다 구현 해야되는 메소드 (구현=> 오버라이딩)
	 *     = 멤버 변수도 가지고 있다 
	 *     = 사용시에는 반드시 메소드를 구현한 클래스을 이용해서 메모리 할당을 한다 
	 *     = 관련된 클래스를 여러개 묶어서 한개의 이름으로 제어할때 
	 *
 *       추상 클래스 => 요구사항 (기능만 설정 => 구현은 나중에) *** 미완성 (메소드가 구현이 안된 상태)
 *       -------- 기능이 여러가지 인 경우에 설계 (프로그램에 맞게 구현해서 사용=> 구현 안됨) 
 *                예) 버튼 , 마우스 , 키보드 
 *                ** 메모리 할당이 불가능하다 => 구현한 클래스를 대입해서 사용한다 
 *                ** 데이터베이스의 모든 클래스는 추상 클래스로 제작되어 있다
 *                                        ---------
 *                       | 종류가 많다 (오라클,MySQL, MSSQL , MariaDB,DB2...)
 *                                  ------------         -------
 *      형식)
 *           [접근지정어] abstract class ClassName
 *           {
 *                변수
 *                메소드 
 *                => 구현이 안된 메소드를 포함하고 있다 
 *                public abstract 리턴형 메소드명(); => 선언만 하는 메소드 
 *                => 구현된 메소드를 포함한다
 *           }
 *         
 *           사이트 : 게시판 형식 
 *           게시판 기능은 동일 
 *           -------------
 *            목록출력 / 글쓰기 / 상세보기 / 수정 / 삭제 / 검색 
 *            --------------------------------------- 선언 (구현(X)) => 사이트 맞게 구현해서 사용한다 
 *            ==> 오버라이딩 (레고)
 *            ==> 추상클래스 상속을 받아서 구현후에 사용 
 *                -----------------
 *                  => 관련된 클래스 여러개 모아서 한개의 이름으로 제어 
 *          
 */
public class dd {

}
