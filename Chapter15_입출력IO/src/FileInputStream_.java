import java.util.*;
import java.io.*;

public class FileInputStream_ {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("c:\\java_data\\sawon.txt");
				//1byte씩 가져옴 -> 다운로드 전용(읽어오면 1byte이므로 글자 다 깨짐)
			int i=0;
			while((i=fis.read())!=-1) {
				System.out.print((char)i);
			}
			fis.close();
		} catch(Exception e) {}

	}

}
