import java.util.*;
import java.io.*; 

public class FileCopy_ {

	public static void main(String[] args) {
		try
        {
        	FileInputStream fis=new FileInputStream("c:\\javaDev\\movie.txt");
        	FileOutputStream fos=new FileOutputStream("c:\\java_data\\movie1.txt");
        	byte[] buffer=new byte[1024]; //바이트 배열(버퍼) 크기 지정
        	// TCP(1024) / UDP(512) 
        	int i=0; //읽은 byte수
        	while((i=fis.read(buffer, 0, 1024))!=-1)
        			//fis로 1byte씩 read()한 결과 i번째 buffer 배열 요소에 저장
        							//0부터 최대 1024byte까지 입력
        										//파일의 끝까지(입력값이 -1, 없을 때까지)
        	{
        		fos.write(buffer, 0, i); //서버로 전송 ==> 파일 업로드 
        		//fos로 buffer 배열 요소 0부터 i번째까지 출력
        	}
        	fis.close();
        	fos.close();
        	System.out.println("파일 복사 완료!!");
        }catch(Exception ex){}
	
	}

}
