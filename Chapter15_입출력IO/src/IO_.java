import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/*
 * 0. IO : Input/Output 입출력
 * 
 * 1. 스트림(Stream) : 데이터 이동 통로
 * 		- 단방향 -> 입출력 위해서는 stream 2개 필요(Input / Output)
 * 		- FIFO 구조 : 선입선출(먼저 보낸 데이터 먼저 받음)
 * 			-> 순서가 있는 일련의 데이터
 * 
 * 2. 입출력
 * 	- 컴파일 예외처리 필수
 * 	1) 메모리(표준 입출력) : 콘솔(도스창)을 통한 데이터 입력과 데이터 출력
 * 		- System.in : 콘솔로부터 데이터 입력
 * 		- System.out, System.err : 콘솔로 데이터 출력
 * 		- stream : 사용자 전송 데이터 값 주소 서버로 받음
 * 			- 장점 : 데이터 저장 위치 알려줌 -> 데이터 손실 없음
 * 			- 단점 : 단방향 -> 양방향으로 만들 때는 프로그램 2개 동시 처리(쓰레드)
 * 
 * 	2) 라이브러리
 * 		- 바이트기반 스트림 : 1byte씩 송수신
 * 			- InputStream / OutputStream
 * 			- 다운로드, 업로드
 * 			- byte[] : buffer
 * 		- 문자기반 스트림 : 2byte씩 송수신, 인코딩
 * 			- Reader / Writer
 * 			- 한글 파일 처리(한글자당 2byte)
 * 			- char[]
 * 		- 보조 스트림 : 읽고 쓰는 속도를 빠르게 하기 위해 미리 메모리에 올려놓고 시작
 * 			- BufferedInputStream / BufferedOutputStream
 * 			- 독립적으로 사용 불가, 주 스트림에 속도 보완 위해 사용
 * 			- buffer : byte 배열, 배열로 여러 바이트 한번에 입출력
 * 				- 입력 : 입력소스로부터 버퍼 크기의 데이터 버퍼(스트림)에 저장
 * 						-> 프로그램은 버퍼에서 데이터 읽기
 * 				- 출력 : 버퍼 크기의 데이터 버퍼(스트림)에 저장
 * 						-> 버퍼 가득차면 출력소스에 데이터 출력
 * 						-> 데이터양이 버퍼보다 작으면 버퍼에 데이터 남아있을 수 있으므로 close, flush 메소드 호출 필수
 * 					- close() : flush() 호출, 스트림 인스턴스 반환
 * 					- flush() : 버퍼에 저장된 내용 출력소스에 출력 후 버퍼 비움
 * 		- 객체기반 스트림 : 파일 객체 단위로 저장 ArrayList
 * 			- ObjectInputStream / ObjectOutputStream
 *		- 스트림 객체 생성과 수정
 *		  	- create : new FileOutputStream("") -> 파일을 생성
 *      	- append : new FileOutputStream("",true) -> 기존의 파일에 데이터 추가
 * 
 * 	3) 파일(*) : File (파일, 디렉토리에 대한 정보를 지님)
 * 		- 읽기 FileInputStream / FileReader
 * 		- 쓰기 FileOutputStream / FileWriter
 * 		- 메소드
 * 			파일 목록 읽기 : listFiles()
 * 			파일 생성 : createNewFile(), mkdir()
 * 			파일명 : getName()
 * 			경로+파일명 : getPath()
 * 			절대경로명 : getAbsolutePath()
 * 			조상디렉토리(파일이 속해있는 디렉토리) : getParent()
 * 			수정날짜 l : astModified()
 * 			디렉토리, 파일 여부 확인 : isFile(), isDirectory()
 * 			숨김여부 : isHidden()
 * 			쓰기전용여부 : canWrite()
 * 			읽기전용여부 : canRead()
 * 
 * 	4) 네트워크
 * 		- 전송 OutputStream : 1byte
 * 		- 수신 BufferedReader : 2byte로 변환
 * 		- Socket : 전송, 수신 연결
 * 
 * 	5) 메소드
 * 		- read()
 * 		- write() : 한글자 저장
 * 		- close()
 * */

public class IO_ {
	public static void main(String[] args) {
		try {
			//디렉토리(폴더) 가져오기
			File dir=new File("c:\\javadev");
			//디렉토리의 전체 파일목록 가져옴
			File[] files=dir.listFiles(); 
				//File 클래스로 디렉토리, 파일 모두 관리 가능
			for(File f:files) {
				if(f.isDirectory()) //디렉토리만 골라서 반환
					System.out.println("<DIR>"+f.getName());
				else System.out.println(f.getName());
			}
			System.out.println();
			
			File dir2=new File("c:\\java_data");
			if(!dir2.exists()) //디렉토리가 없는 경우 생성
				dir2.mkdir();
			File file=new File("c:\\java_data\\sawon.txt");
			if(!file.exists()) //파일이 없는 경우 생성
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
