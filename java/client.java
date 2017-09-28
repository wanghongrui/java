import java.net.*;
import java.io.*;
public class client{
	public static void main(String[] args)
		throws IOException
	{
		Socket socket = new Socket("127.0.0.1",30000);
		socket.setSoTimeout(1000);
		//try{
			
		//}catch (SocketTimeoutException ex){
			
		//}
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println("服务器："+ line);
		br.close();
		socket.close();	
	}
}