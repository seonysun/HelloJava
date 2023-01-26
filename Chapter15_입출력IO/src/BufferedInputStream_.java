import java.io.*;

public class BufferedInputStream_ {

	public static void main(String[] args) {
		try
        {
        	File dir=new File("c:\\java_data");
        	if(!dir.exists())
        	{
        		dir.mkdir();
        		System.out.println("데이터 저장 폴더가 만들어졌습니다!!");
        	}
        	else
        	{
        		System.out.println("이미 존재하는 폴더입니다!!");
        	}
        	
        	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("c:\\java_data\\student.txt"));
        													//버퍼를 이용하는 보조스트림은 독립 사용 불가 -> 주 스트림 설정
        	String std="1|홍길동|90|80|70\n"
        			  +"2|박문수|90|80|70\n"
        			  +"3|이순신|90|80|70\n"
        			  +"4|강감찬|90|80|70\n"
        			  +"5|을지문덕|90|80|70";
        		//전송된 데이터 메모리에 저장했다가 close 이후에 파일-데이터 연결
        	bos.write(std.getBytes()); // 메모리(버퍼)에 저장 
        	bos.close(); // 파일로 전송
        	System.out.println("데이터 저장 완료!!");
        }catch(Exception ex){}

	}

}
