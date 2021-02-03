import java.util.Scanner;
class Rectangle{
	private int x, y, width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	int square() {
		return x*y;
	}
	void show() {
		System.out.println("(" + x + ","+ y + ")" + "에서 크기가 "+ x*y + "인 사각형");
		
	}
	public boolean contains(Rectangle r) {
		if((this.x<r.x) && (this.y<r.y) && (this.x+this.width)>(r.x+r.width) && (this.y+this.height)>(r.y+r.height))
			return true;
		else
			return false;
	}
}
public class ch04_04 {
	public static void main(String args[]) {
		Rectangle r = new Rectangle(2,2,8,7);
		Rectangle s = new Rectangle(2,2,8,7);
		Rectangle t = new Rectangle(2,2,8,7);
		
		r.show();
		System.out.println("s의 면적은 "+ s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");

	}
}
