package java_training2;

class CcolorPoint extends Point {
	private String color;
	public CcolorPoint() {
		super(0, 0); // this.x = x; this.y = y;
		color = "BLACK";
	}
	public CcolorPoint(int x, int y) {
		super(x, y); // this.x = x; this.y = y;
		color = "BLACK";
	}
	public CcolorPoint(int x, int y, String color) {
		super(x, y); // this.x = x; this.y = y;
		this.color = color;
	}
	public void setXY(int x, int y) {
		move(x, y); // this.x = x; this.y = y;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		return (color+"색의 ("+getX()+","+getY()+")의 점");
	}
}


public class ch05_06 {

	public static void main(String args[]) {
		CcolorPoint zeroPoint = new CcolorPoint(); // (0,0) 위치의 BLACK 색 점
		System.out.println(zeroPoint.toString() + "입니다.");
		
		CcolorPoint cp = new CcolorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
	}

}
