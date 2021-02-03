package java_training4;

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

class varyeun extends JFrame{
	MyPanel panel = new MyPanel();
	public varyeun() {
		setTitle("격자 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400,400);
		setVisible(true);
		
	}
	
}

class MyPanel extends JPanel{
	public void paintComponemt(Graphics g) {
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		for(int i=1;i<10;i++) {
			g.drawLine(0, (int)(h*0.1*i), w, (int)(h*0.1*i));
			g.drawLine((int)(w*0.1*i), 0, (int)(w*0.1*i),h);
		}
	}
}
public class ch12_04 {
	public static void main(String args[]) {
		new varyeun();
	}
}
