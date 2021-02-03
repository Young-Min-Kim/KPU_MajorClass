import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.text.BadLocationException;

class textSlider extends JFrame{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0);
	private JTextArea ta = new JTextArea(7, 10);
	
	public textSlider() {
		setTitle("TextARea Practice Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(slider, BorderLayout.SOUTH);
		c.add(new JScrollPane(ta), BorderLayout.CENTER);
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);

		
		/*
		 * slider.addChangeListener(new ChangeListener() { public void
		 * stateChanged(ChangeEvent e) { JSlider slider = (JSlider)e.getSource();
		 * if(ta.getText().length()<=slider.getValue()) {
		 * slider.setValue(ta.getText().length()); } else { try {
		 * ta.setText(ta.getText(0, slider.getValue())); }catch(BadLocationException ex)
		 * {} } } }); ta.addKeyListener(new KeyAdapter() { public void KeyTyped(KeyEvent
		 * e) { JTextArea ta = (JTextArea)e.getSource(); int size =
		 * ta.getText().length(); try { if(size>=100) ta.setText(ta.getText(0, 100));
		 * }catch(BadLocationException ex) {} slider.setValue(size); } });
		 */
		 
		setSize(300, 250);
		setVisible(true);

	}
	


}
public class ch11_06 {

	public static void main(String[] args) {
		new textSlider();
	}

}
