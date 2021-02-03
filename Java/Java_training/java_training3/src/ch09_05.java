import javax.swing.*;
import java.awt.*;
class LandomLayoutEx extends JFrame{
	public LandomLayoutEx() {
		setTitle("Random Labels");
	
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);//임의로 랜덤해서 배치해야하기 때문에
		for(int i = 0; i < 20; i++) {
			JLabel label = new JLabel();
			int x = (int)(Math.random()*200)+50; // 50~250
            int y = (int)(Math.random()*200)+50; // 50~250
            label.setLocation(x,y); // label을 (x,y)에 배치
            label.setBackground(Color.BLUE);
            label.setSize(10,10); // label 크기를 10*10으로 설정
            c.add(label);//컨탠트 팬에 라벨 추가
            label.setOpaque(true); // label에 배경색이 보이게 함
		}
		setSize(300,300);
	}
}
public class ch09_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LandomLayoutEx();
	}

}
