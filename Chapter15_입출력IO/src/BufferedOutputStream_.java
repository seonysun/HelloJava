import java.util.*;
import java.io.*;

public class BufferedOutputStream_ {

	public static void main(String[] args) {
		try
	    {
			BufferedInputStream bis=
	       			new BufferedInputStream(new FileInputStream("c:\\java_data\\student.txt"));
	       	int i=0;
	       	while((i=bis.read())!=-1) // -1 : EOF
	       	{
	       		System.out.print((char)i);
	       	}
	       	bis.close();
        }catch(Exception ex){}
		
	}

}
