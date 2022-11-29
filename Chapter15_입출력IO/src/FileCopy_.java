import java.util.*;
import java.io.*; 

public class FileCopy_ {

	public static void main(String[] args) {
		try
        {
        	FileInputStream fis=new FileInputStream("c:\\javaDev\\movie.txt");
        	FileOutputStream fos=new FileOutputStream("c:\\download\\movie1.txt");
        	/*int i=0;
        	while((i=fis.read())!=-1)
        	{
        		fos.write(i);
        	}
        	fis.close();
        	fos.close();*/
        	byte[] buffer=new byte[1024];// 클라이언트에서 서버로 파일을 전송하는 방법 
        	// TCP(1024) / UDP(512) 
        	int i=0; // 글자번호가 아니다 (읽은 byte수)
        	while((i=fis.read(buffer, 0, 1024))!=-1)
        	{
        		fos.write(buffer, 0, i);// 서버로 전송 ==> 파일 업로드 
        	}
        	fis.close();
        	fos.close();
        	System.out.println("파일 복사 완료!!");
        }catch(Exception ex){}
	
	}

}
