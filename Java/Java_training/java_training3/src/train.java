import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class IndepClassListener extends JFrame{
	public IndepClassListener() {
		setTitle("Action 이벤트 처리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Ation");
		btn.addActionListener(new MyACtionListener());
		c.add(btn);
		setSize(300,150);
		setVisible(true);
		
	}
}
public class train {

	public static void main(String[] args) {
		new IndepClassListener();
	}
}
class MyACtionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getText().equals("Action"))
			b.setText("액션");
		else
			b.setText("Action");
	}
}
