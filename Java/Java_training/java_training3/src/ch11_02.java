import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class comboBox extends JFrame{
	private JTextField tf = new JTextField(10);
	private JComboBox jcb = new JComboBox();
	
	public comboBox(){
		setTitle("JTextField and JComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c =getContentPane();
        c.setLayout(new FlowLayout());
        tf.addKeyListener(new EnterListener());
        c.add(tf);
        c.add(jcb);

        setSize(300, 300);
        setVisible(true);
        

	}
	public class EnterListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			if(KeyCode == KeyEvent.VK_ENTER) {
				jcb.addItem(tf.getText());
				tf.setText("");
			}
			}
	}
}

public class ch11_02 {
	public static void main(String args[]) {
		new comboBox();
	}
}
