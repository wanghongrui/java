import java.io.File;
import java.io.*;
public class FileTest{
	public static void main(String[] args)
		throws IOException
	{	
			//File file= new File(".");
			//File file1= new File("/");

			//System.out.println(file.getName());
			//System.out.println(file.getParent());
			//System.out.println("AbsoluteFile-->"+file.getAbsoluteFile());
			//System.out.println("AbsoluteFile-->"+file1.getAbsoluteFile());

		//	File str = file.getAbsoluteFile();
			//System.out.println("File-->"+str);
			//System.out.println("GetPath-->"+str.getPath());
			//System.out.println("File.Parent-->"+str.getParent());
			//File tempFile = File.createTempFile("aaa",".txt",file);
			//System.out.println(tempFile.getParent());
			//System.out.println(tempFile.getAbsoluteFile().getParent());
			//tempFile.deleteOnExit();
			//File newF = new File(System.currentTimeMillis()+"");
			//System.out.println("newF是否存在--》"+newF.exists());

		//	System.out.println("newF路径--》"+newF.getAbsoluteFile());
			//newF.createNewFile();
			//System.out.println(newF.mkdir());
			//String[] fileList = file.list();
			//for(String filename : fileList){
			//	System.out.println(filename);
			//}
			//File[] files = file.listFiles();
			//for(File f : files){
			//	System.out.println("f-->"+f);
			//}
			
			//File[] roots = File.listRoots();
			//for(File root : roots){
		//		System.out.println(root);
			//}
			//String[] nameList = file.list((dir,name)->{System.out.println("name-->"+name);return name.endsWith(".java")||new File(name).isDirectory();
			//});
			//for(String name:nameList){
		//		System.out.println(name);
			//} 
			//FileInputStream fileOwn = new FileInputStream("FileTest.java");
			//byte[] bbuf = new byte[2048];
			//int hasRead = 0;
			//while((hasRead = fileOwn.read(bbuf))>0){
	//			System.out.println(new String (bbuf,0,hasRead));
			//}
			//fileOwn.close();
			File fs = new File("./1");
			//FileReader fileReader = new FileReader(".");
			File[] temfs = fs.listFiles();
			for(File f :temfs ){
				//if(f.getName().endsWith)
				String[] names = f.getName().split(".");
				FileReader filereader= new FileReader(f);
				BufferedReader buff = new BufferedReader(filereader);
				
				String valueString=null;
				while ((valueString=buff.readLine())!=null){
					System.out.println(valueString);
				}
				
				System.out.println(f.getName());
			}
			
			
			
			
	}
}