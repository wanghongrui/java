import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zx on 2017/9/26.
 */
public class Server {
    public static void main(String[] args)
    throws IOException
    {
        ServerSocket ss = new ServerSocket(30000);
        Socket s = ss.accept();
        PrintStream ps= new PrintStream(s.getOutputStream());
        ps.println("first");
        ps.println("second");
        s.shutdownOutput();
        System.out.println(s.isClosed());
        Scanner scan = new Scanner(s.getInputStream());
        while(scan.hasNextLine()){
            System.out.println(scan.hasNextLine());
        }
        scan.close();
        s.close();
        ss.close();
    }
}
