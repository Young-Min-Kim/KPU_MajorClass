package java_training4;
import javax.swing.*;
import java.awt.Graphics;

class varyeun extends JFrame{
	MyPanel panel = new MyPanel();
	
	public varyeun() {
		setTitle("그래픽 다각형 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(400, 400);
		setVisible(true);
		
		
	}
	
	class MyPanel extends JPanel {
		public void paintCompinent(Graphics g) {
			super.paintComponent(g);
			int w = getWidth();
			int h = getHeight();
			int [] x = {w/2, w, w/2, 0};
			int [] y = {0, h/2, h, h/2};
			for(int i =0;i<10;i++) {
				g.drawPolygon(x,y,4);
				y[0]+=10; x[1]-=10;y[2]-=10;x[3]+=10;
			}
		}
	}
}

public class ch12_06_2 {
	public static void main(String args[]) {
		   new varyeun();
	}
}
