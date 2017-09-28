import java.net.*;
import java.io.*;
public class server{
	public static void main(String[] args)
		throws IOException
	{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("您好，您收好我的祝福");
			ps.close();
			s.close();
		}
		
	}
}