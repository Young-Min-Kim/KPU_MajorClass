import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ChangeContentPane extends JFrame{
	JPanel contentPane = new JPanel();
	ChangeContentPane(){
        setTitle("드래깅 동안 색상 변경"); // 제목 지정
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼을 눌렀을 시 화면 닫기
        
        setContentPane(contentPane);
        contentPane.addMouseMotionListener(new MyMouseMotionAdapter());
        contentPane.addMouseListener(new MyMouseAdapter());
        contentPane.setBackground(Color.GREEN);

        setSize(400,200);
        setVisible(true);
         
    }
	class MyMouseMotionAdapter extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
			contentPane.setBackground(Color.YELLOW);
		}
	}
	class MyMouseAdapter extends MouseAdapter{
		public void mouseReleased(MouseEvent e) {
			contentPane.setBackground(Color.GREEN);
		}
		public void mouseClicked(MouseEvent e) {
			contentPane.setBackground(Color.black);
		}
		public void mousePressed(MouseEvent e) {
			contentPane.setBackground(Color.RED);
		}
	}
 
}

public class ch10_02 {
	public static void main(String args[]) {
		new ChangeContentPane();
	}
}
