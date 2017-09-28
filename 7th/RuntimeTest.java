import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class RuntimeTest{
	public static void main(String[] args){
		try{
			Runtime rt = Runtime.getRuntime();
			System.out.println("progresses" + "---->" + rt.availableProcessors());
			System.out.println("freeMemory" + "---->" + rt.freeMemory());
			System.out.println("maxMemory" + "---->" + rt.maxMemory());
			System.out.println("totalMemory" + "---->" + rt.totalMemory());	
			rt.exec("notepad.exe");
		}catch(Exception e){}
		
	}
}