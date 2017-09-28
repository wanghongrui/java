import java.awt.*;
public class FrameTest{
	public static void main(String[] args){
		Frame f = new Frame("FrameTest");
		f.setBounds(30,30,250,200);
		Dialog d1 =new Dialog(f,"model",true);
		Dialog d2 =new Dialog(f,"no-model",false);
		d1.setBounds(30,30,400,400);
		d2.setBounds(30,30,400,400);
		Button b1 = new Button("open model");
		Button b2 = new Button("open no-model");
		b1.addActionListener(e->d1.setVisible(true));
		b2.addActionListener(e->d2.setVisible(true));
		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.SOUTH);
		FileDialog d3 =new FileDialog(f,"load",FileDialog.LOAD);
		FileDialog d4 =new FileDialog(f,"save",FileDialog.SAVE);
		d3.setBounds(30,30,400,400);
		d4.setBounds(30,30,400,400);
		Button b3 = new Button("load");
		Button b4 = new Button("Save");
		b3.addActionListener(e->{d3.setVisible(true);
		System.out.println("road---->"+d3.getDirectory()+"   name----->"+d3.getFile());});
		b4.addActionListener(e->{d4.setVisible(true);
		System.out.println("road---->"+d4.getDirectory()+"   name----->"+d4.getFile());});
		f.add(b3,BorderLayout.WEST);
		f.add(b4,BorderLayout.EAST);
		Panel p =new Panel();
		p.add(new TextField(15));
		p.add(new Button("OK"));
		p.add(new Checkbox("man",false));
		f.add(p);
		f.setVisible(true);
	}
}