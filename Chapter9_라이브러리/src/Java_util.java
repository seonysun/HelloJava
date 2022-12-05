import java.lang.reflect.Method;
import java.util.*;

/*
 * 2. util : 자주 사용되는 클래스 
 * 	- import 사용 필수
 * 
 * 	1) Random : 난수 추출
 * 		- nextInt(int i) : 정수 난수추출(범위 int로 지정)
 * 			ex. nextInt(100) -> 0~99
 * 		- nextBoolean(), nextDouble()
 * 
 * 	2) Scanner : 입력값 받는 경우
 * 		- next(), nextInt()
 * 
 * 	3) StringTokenizer : 구분자 기준으로 문자열을 자를 경우
 * 		- 네트워크(DB 연결, 서버 개설)에서 많이 사용
 * 		- StringTokenizer 객체명 = new StringTokenizer(문자열, 구분자);
 * 		- int countTokens() : 잘린 단어 갯수 셀 때
 * 		- String nextToken() : 분리된 문자열 읽을 때
 * 						-> 갯수 확인 필수(잘려진 갯수보다 많은 메소드 호출할 수 없음)
 * 						-> 직접 가져오기보다는 루프 사용
 * 		- boolean hasMoreTokens() : 루프(while) 사용 시
 * 		- 		split			  StringTokenizer
 *		   ----------------------------------------
 * 			  배열로 반환			     문자열로 반환
 * 			  공백 토큰 O				  공백 토큰 X
 * 				 //|					 |
 * 			구분자 문자 여러개 가능	   구분자 문자 1개만 가능
 * 
 * 	4) Date
 * 	5) Calender
 * */

class Member{
	private String id;
	private String pwd;
	private String sex;
	private String name;
	private String tell;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
}
public class Java_util {

	public static void main(String[] args) {
		//Random
		Random r=new Random();
		int i=r.nextInt(31)+1;
		System.out.println(i+"\n");
		
		int[] reserve=new int[r.nextInt(10)+11];
		for(int j=0;j<reserve.length;j++) {
			reserve[j]=r.nextInt(31)+1;
		}
		Arrays.sort(reserve);
		System.out.println("==예약 가능 날짜==");
		for(int j:reserve) {
			if(j>=21)
				System.out.print(j+" ");
		}
		System.out.println("\n");
		
		
		//StringTokenizer
		String date="2022-11-21";
		StringTokenizer st=new StringTokenizer(date,"-");
												//구분자가 공백일 경우 생략 가능
		/*String year=st.nextToken();
		String month=st.nextToken();
		String day=st.nextToken();*/
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		//
		String[] data= {
				"100|hong|남자|대기실",
				"200|자바방|5|공개",
				"210|자바방|hong",
				"300|hong|shin|Hi~",
				"400|hong"};
		for(String msg:data) {
			StringTokenizer st1=new StringTokenizer(msg,"|");
			int protocol=Integer.parseInt(st1.nextToken());
			switch(protocol) {
			case 100:{
				//System.out.println("문자열 갯수:"+st1.countTokens());
				//반드시 확인 후 메소드 호출 -> 아니면 루프 돌려서 호출
				String id=st1.nextToken();
				String sex=st1.nextToken();
				String loc=st1.nextToken();
				System.out.println(id+"님이 "+loc+"에 입장하셨습니다.");
			}
			break;
			case 200:{
				String rName=st1.nextToken();
				String rInwon=st1.nextToken();
				String rState=st1.nextToken();
				System.out.println(rName+"("+rInwon+"명):"+rState);
			}
			break;
			case 300:{
				String myId=st1.nextToken();
				String yourId=st1.nextToken();
				String m=st1.nextToken();
				System.out.println(myId+"님이 "+yourId+"님께 메시지를 보냈습니다.\n> "+m);
			}
			break;
			case 400:{
				String id=st1.nextToken();
				System.out.println(id+"님이 퇴장하셨습니다.");
			}
			}
		}
		System.out.println();
			
		//
		String data1="list.jsp?id=admin&pwd=1234&sex=남자&name=홍길동&tel=010-1111-1111";
		data1=data1.substring(data1.indexOf("?")+1);
		StringTokenizer st2=new StringTokenizer(data1,"&");
		try {
			Class clsName=Class.forName("Member");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			while(st2.hasMoreTokens()) {
				StringTokenizer st3=new StringTokenizer(st2.nextToken(),"=");
				String prefix=st3.nextToken();
				String suffix=st3.nextToken();
				
				for(Method m:methods) {
					String name=m.getName();
					if(name.equalsIgnoreCase("set"+prefix)) {
						m.invoke(obj, suffix);
					}
				}
			}
			Member mem=(Member)obj;
			System.out.println("ID:"+mem.getId());
			System.out.println("PW:"+mem.getPwd());
			System.out.println("SEX:"+mem.getSex());
			System.out.println("NAME:"+mem.getName());
			System.out.println("TELL:"+mem.getTell());
		} catch(Exception e) {}
		
	}

}
