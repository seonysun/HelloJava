// 보조 스트림을 이용한 파일 읽기 
import java.util.*;
import java.io.*;
/*
 *   Input / Reader ==> 읽기 
 *   Output / Writer ==> 쓰기 
 *   ------
 *    | 파일전송 / 파일복사 ==> 영문,숫자,특수문자 => 정상 수행 
 *                        --------------- 1byte,2byte 
 */
public class BufferedInputStream_ {

	public static void main(String[] args) {
		 try
	        {
	        	BufferedInputStream bis=
	        			new BufferedInputStream(new FileInputStream("c:\\java_data\\student.txt"));
	        	int i=0;
	        	while((i=bis.read())!=-1) // -1 EOF
	        	{
	        		System.out.print((char)i);
	        	}
	        	bis.close();
	        }catch(Exception ex){}
		
	}

}
