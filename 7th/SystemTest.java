import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class SystemTest{
	public static void main(String[] args){
		try{
		Map<String,String> evn = System.getenv();
		for(String name : evn.keySet()){
			System.out.println(name + "----->" + evn.get(name));
		}
		System.out.println(System.getenv("JAVA_HOME"));
		Properties props = System.getProperties();
		props.store(new FileOutputStream("props.txt"),"System Properties");
		System.out.println(System.getProperty("os.name"));
		}catch(Exception e){
			
		}
	
	}
}