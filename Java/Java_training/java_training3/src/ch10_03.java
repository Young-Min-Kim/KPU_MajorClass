import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class reverseLavel extends JFrame{
	JLabel label;
	
	StringBuffer s = new StringBuffer("Love Java");
	reverseLavel(){
		setTitle("Left 키로 문자열 교체");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Love Java");
		 label.addKeyListener(new MyKeyAdapter());
		label.setSize(200,50);
        add(label);
        setSize(400,200);
        setVisible(true);
        label.requestFocus();
	}
	class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				label.setText(s.reverse().toString()); 
			}
			else
				label.setText(s.reverse().toString());
		}
	}
}

public class ch10_03 {
	public static void main(String args[]) {
		new reverseLavel();
	}
}
