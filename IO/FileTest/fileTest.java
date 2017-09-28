import java.io.*;
import java.lang.*;
public class fileTest{
	public static void main(String[] args){
		try
		{
			File file = new File(".");
			System.out.println(file.getName());
			System.out.println(file.getParent());
			System.out.println(file.getAbsoluteFile());
			System.out.println(file.getAbsoluteFile().getParent());

			File tem = File.createTempFile("tem",".txt",file);
			tem.deleteOnExit();
			File newFile = new File(System.currentTimeMillis()+"");
			System.out.println("newFile对象是否存在："+newFile.exists());
			newFile.createNewFile();
			newFile.mkdir();
			String[] fileList = file.list();
			for(String filename:fileList){
				System.out.println(filename);
			}
			File[] roots = File.listRoots();
			for(File root : roots){
				System.out.println(root);
			}
			String[] nameList = file.list((dir,name)->
			name.endsWith(".java")||new File(name).isDirectory());
			for(String name:nameList){
				System.out.println(name);
			}
			FileInputStream fis = new FileInputStream("fileTest.java");
			FileOutputStream fos = new FileOutputStream("fos.txt");
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while((hasRead = fis.read(bbuf)) > 0){
				System.out.println(new String(bbuf,0,hasRead));	
				fos.write(bbuf,0,hasRead);
				
			}
			fis.close();
			FileReader fr = new FileReader("fileTest.java");
			char[] cbuf = new char[550];
			int chasRead= 0;
			while((chasRead = fr.read(cbuf))>0){
				System.out.println(new String(cbuf,0,chasRead));
			}
		}catch(Exception e){}
		try(
		FileOutputStream fos = new FileOutputStream("tem.txt");
		PrintStream ps =new PrintStream(fos);		
		){
			ps.println("普通字符城");
			ps.println(new fileTest());
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}