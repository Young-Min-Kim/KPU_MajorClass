import javax.swing.*;
import java.awt.*;

class GridLayoutEx extends JFrame{
	Color colorArr[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.BLUE,new Color(330066), new Color(660066), Color.DARK_GRAY,
            Color.PINK, Color.GRAY };
	public GridLayoutEx() {
		setTitle("Ten Color Buttons Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridLayout grid = new GridLayout(1, 10);
		c.setLayout(grid);
		
		for(int i = 0; i< 10; i++) {
			JButton btn = new JButton(i+"");
			btn.setBackground(colorArr[i]);
			c.add(btn);
		}
		
		setSize(600, 300);
		setVisible(true);
	}
}

public class ch09_03 {

	public static void main(String[] args) {
		new GridLayoutEx();

	}

}
