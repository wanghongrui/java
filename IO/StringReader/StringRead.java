import java.io.*;
public class StringRead{
	public static void main(String[] args){
		String src = "从明天起，做一个幸福的人\n"
		+"喂马，劈柴，周游世界\n"
		+"从明天起，关心粮食和蔬菜\n"
		+"我有一所大房子，面朝大海，春暖花开";
		char[] buffer = new char[32];
		int hasRead = 0;
		try(
		StringReader sr = new StringReader(src))
		{
			while((hasRead = sr.read(buffer))>0)
			{
				System.out.print(new String(buffer,0,hasRead));
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		try(
		StringWriter sw = new StringWriter()){
			sw.write("酸辣粉集散地\n");
			sw.write("水电费萨尔\n");
			sw.write("烧热后果标点符号\n");
			sw.write("色过得vcxzv\n");
			sw.write("撒地方违规和体会\n");
			System.out.println(sw);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		try(
		PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(read);)
		{
			System.setOut(ps);
			String line = null;
			while((line = br.readLine())!=null){
				if(line.equals("exist")){
					System.exit(1);
				}
				System.out.println(line);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
}}