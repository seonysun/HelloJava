import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/*
 * 1. 스트림(Stream) : 데이터 이동 통로, 순서가 있는 일련의 데이터
 * - 자바의 입출력은 stream 사용 
 * Queue(FIFO 선입선출)
 * 송수신 1byte, 2byte
 * 
 * 입출력
 * - 메모리 : System.in, System.out
 * stream : 사용자 전송 데이터 값 서버로 받음
 * 장점 - 데이터 저장 위치 알려줌 -> 데이터 손실 없음
 * 단점 - 단방향 -> 양방향으로 만들 때는 프로그램 2개 동시 처리(쓰레드)
 * - 라이브러리 : 
 * 바이트기반 스트림 1byte씩 송수신 -> 다운로드, 업로드
 * 문자기반 스트림 2byte씩 송수신 -> 한글 파일 처리(한 글자당 2byte)
 * 보조 스트림 : 읽고 쓰는 속도를 빠르게 하기 위해 미리 메모리에 올려놓고 시작
 * Buffered
 * 
 * 객체기반 스트림 : 파일 객체 단위로 저장 ArrayList
 * ObjectInputStream
 * ObjectOutputStream
 * 
 * - 파일 : File (파일, 디렉토리에 대한 정보를 지님)
 * 읽기 FileInputStream / FileReader
 * 쓰기 FileOutputStream / FileWriter
 * 
 * - 네트워크 :
 * 전송 OutputStream
 * 수신 BufferedReader
 * Socket -> 전송, 수신 연결
 * 
 * 메소드
 * read()
 * write()
 * close()
 * 컴파일 예외처리 -> 예외처리 필수
 * 
 * 
 * * 파일 목록 읽기 File[] listFiles()
 * 파일 만들기 createNewFile(), mkdir()
 * 파일 속성
 * 파일명 getName()
 * 경로명 getParent()
 * 파일+경로명  getPath()
 * 수정날짜 lastModified()
 * 디렉토리, 파일 여부 확인 isFile(), isDirectory()
 * 숨김여부 isHidden()
 * 쓰기전용여부 canWrite()
 * 읽기전용여부 canRead()
 * getAbsolutePath()
 * 
 * 
 * 
 * ... 1. 스트림 : 데이터 이동 통로 
 *              Queue (FIFO) 
 *              => 송수신 : 1byte / 2byte (~Reader,~Writer) => 한글 
 *                        -----   ------
 *                          |    
 *                        ~InputStream  ==> read()
 *                        ~OutputStream ==> write() => close()
 *              => txt (Reader/Writer) 
 *              -------------------------------------------------
 *              => XML(DoucmentBilder) , HTML(Jsoup) 
 *              => JSON(Simple-Json)
 *              => Ajax , VueJS (JSON) , React(XML,JSON)
 *              -------------------------------------------------
 *              File을 중심으로 => 다운로드 / 업로드 , 추천 => 카페,블로그 
 *              -------------------------------------------------
 *              1) File 
 *              2) FileInputStream / FileOutputStream 
 *              3) FileReader / FileWriter
 *              4) BufferedReader => 웹 데이터를 읽어 올때 
 *              5) ObjectInputStream / ObjectOutputStream (객체 단위로 저장)
 *                 => 역직렬화 , 직렬화 
 *              -------------------------------------------------------- 
 *              
 *              868page 
 *              --------
 *              입출력 (입력(Input),출력(Output))
 *              -----
 *               메모리 
 *                = 표준 입출력 
 *                  System.in , System.out 
 *                        ----         ----
 *                        InputStream   OutputStream 
 *                  Stream : 데이터를 이동하는 통로 
 *                  클라이언트 전송 =====> 서버에 값을 받는다 
 *                  --------------------------------
 *                     보내는 것이 아니라 => 저장된 위치를 알려준다 (그 위치로부터 값을 읽어 온다)
 *                     => 데이터를 잃어버리지 않는다 (데이터 손실이 없다)
 *                     => 스트림의 단점 : 단방향 (양방향 => 쓰레드)  
 *                     => 빨대 
 *                     => FIFO(Queue) 
 *               라이브러리 
 *               -------
 *                  |
 *                  = 바이트기반 스트림 (1byte씩 송수신) => 다운로드/업로드
 *                  = 문자기반 스트림 (2byte 송수신) => 한글 파일을 읽어 올때 
 *                                                *** 한글은 1글자당 2byte이다 (UTF-8)
 *                                                *** 이클립스 : EUC-KR => 운영체제
 *                                                    -------------------------
 *                                                    AWS 리눅스 => 통일 (UTF-8) 
 *                                                    ==> 클래스명,메소드명,변수명 , 테이블명, 파일명 => 통일
 *                  = 보조 스트림 => 읽는 속도 , 쓰는 속도를 빨리하기 위해서 미리 메모리에 올려놓고 시작 
 *                    Buffered=> InputStream / OutputStream 
 *                    =>         Reader / Writer   
 *                  = 객체기반 스트림 : 파일 저장 => 객체단위 저장 (ArrayList)
 *                    ObjectInputStream / ObjectOutputStream
 *                    --------------------------------------
 *               파일 
 *                 = File  (파일 , 디렉토리) => 정보 
 *                 = 파일 읽기 : FileInputStream /  FileReader
 *                 = 파일 쓰기 : FileOutputStream / FileWriter
 *                 ------------------------------------------
 *               네트워크 
 *                -----------------------------------------------
 *                 = 전송 : OutputStream ======> 1byte
 *                 = 수신 : BufferedReader ====> 2byte로 변환 
 *                ----------------------------------------------- Socket
 *                
 *                메소드 : read() , write() , close()
 *                       read() : 한글자 읽기 
 *                       read(byte[],int,int) => 데이터를 모아서 읽기 
 *                       
 *                        write() : 한글자 저장 
 *                        write(byte[],int ,int)
 *                ---> 컴파일 에외처리 ==> 반드시 예외처리 한다 
 * */

public class IO_ {
	public static void main(String[] args) {
		try {
			File dir=new File("c:\\javadev"); //디렉토리 가져옴
			File[] files=dir.listFiles(); //디렉토리의 파일목록 가져옴
			for(File f:files) {
				if(f.isDirectory()) //디렉토리(폴더)일 경우
					System.out.println("<DIR>"+f.getName());
				else System.out.println(f.getName());
			}
			System.out.println();
			
			File dir2=new File("c:\\download");
						//File 클래스로 디렉토리, 파일 모두 관리 가능
			if(!dir2.exists())
				dir2.mkdir();
			File file=new File("c:\\download\\Sawon.txt");
			if(!file.exists())
				file.createNewFile();
			
			System.out.println("파일명:"+file.getName());
			System.out.println("경로명:"+file.getParent());
			System.out.println("경로+파일명:"+file.getPath());
			System.out.println("파일크기:"+file.length());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
			System.out.println("파일수정일자:"+sdf.format(new Date(file.lastModified())));
			System.out.println("숨김파일:"+file.isHidden());
			System.out.println("읽기전용:"+file.canRead());
			System.out.println("쓰기전용:"+file.canWrite());
		} catch(Exception e) {}

	}

}
