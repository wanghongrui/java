import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ArgsTest
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!!");
		System.out.println(args.length);
		for(String arg : args){
			System.out.println(arg);
		}
		try
		{			
		Scanner scf = new Scanner(new File("ArgsTest.java"));

		while(scf.hasNextLine())
			{
			System.out.println(scf.nextLine());
			}
		}
		catch(Exception e){}
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			System.out.println("键盘输入为：" + sc.next());
		}
		

	}
}