import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

class sliderMaker extends JFrame{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 130);
	private JLabel la = new JLabel(" ");
	
	public sliderMaker() {
		setTitle("JSlider Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		
		c.add(slider);
		
		la.setText(Integer.toString(slider.getValue()));
		la.setOpaque(true);
		la.setBackground(Color.GREEN);
		
		c.add(la);
		slider.addChangeListener(new MyChangeListener());

		
		setSize(350, 150);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider)e.getSource();
			la.setText(Integer.toString(slider.getValue()));
		}
	}
}

public class ch11_05 {
	public static void main(String args[]) {
		new sliderMaker();
	}
}
