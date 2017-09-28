import java.net.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Myserver {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args)
            throws Exception {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            Socket s = ss.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}