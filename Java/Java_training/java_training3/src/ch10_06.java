import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class randomLetter extends JFrame{
	JLabel label; 
	randomLetter(){
		setTitle("클릭 연습용 응용프로그램"); // 제목 지정
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼을 눌렀을 시 화면 닫기
         
        label= new JLabel("c");
        label.setSize(100,50);
        label.setLocation(100,100);
        label.addMouseListener(new MyMouseAdapter());
        // Jabel 컴포넌트 생성 후 MouseListener를 단다.
         
        add(label);
        setSize(500,500);
        setVisible(true);
        label.requestFocus();
	}
	class MyMouseAdapter extends MouseAdapter{
        int x,y;
        public void mousePressed(MouseEvent e) {
            x = (int)(Math.random()*400); // 여백을 조금 남기기 위해 400으로 지정
            y = (int)(Math.random()*400); // 여백을 조금 남기기 위해 400으로 지정
            label.setLocation(x,y);
        }
    }
}


public class ch10_06 {
	public static void main(String args[]) {
		new randomLetter();
	}
}
