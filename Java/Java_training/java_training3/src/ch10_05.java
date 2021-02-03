import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class bigLetter extends JFrame{
	JLabel label;
	bigLetter(){
		setTitle("+,- 키로 폰트 크기 조절"); // 제목 지정
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 닫기 버튼을 눌렀을 시 화면 닫기
         
        label= new JLabel("Love Java");
        label.setSize(200,50);
        label.setFont(new Font("Arial",Font.PLAIN,10));
        // Arial 폰트로 10픽셀 크기
         
        label.addKeyListener(new MyKeyAdapter());
        // Jabel 컴포넌트 생성 후 KeyListener를 단다.
         
        add(label);
        setSize(400,200);
        setVisible(true);
        label.requestFocus();
	}
	class MyKeyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
            Font f = label.getFont();
            int size = f.getSize();
            switch(e.getKeyCode()) {
            case 45: // -키 눌렀을 경우
                if(size>5) { // 5보다 클때만
                    label.setFont(new Font("Arial", Font.PLAIN,size-5));
                }
                break;
            case 61: // +나=키 놀렀을 경우
                label.setFont(new Font("Arial", Font.PLAIN,size+5));
                break;
        }
		}    
	}
}

public class ch10_05 {
	public static void main(String args[]) {
		new bigLetter();
	}
}
