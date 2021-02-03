import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
class LetterSlider extends JFrame{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,1,100,56);
	private JLabel la = new JLabel("I love Jaba");
	
	public LetterSlider() {
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(slider, BorderLayout.NORTH);
		c.add(la, BorderLayout.CENTER);
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		
		la.setFont(new Font("Arial", Font.PLAIN, slider.getValue()));
		la.setHorizontalAlignment(JLabel.CENTER);
		la.setOpaque(true);
		slider.addChangeListener(new MyChangeListner());
		setSize(400, 300);
		setVisible(true);
	}
	class MyChangeListner implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider)e.getSource();
			la.setFont(new Font("Arial", Font.PLAIN,slider.getValue()));
		}
	}
}

public class ch11_07 {
	public static void main(String args[]) {
		new LetterSlider();
	}
}
