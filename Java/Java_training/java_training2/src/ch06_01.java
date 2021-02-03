class MyPoint {
	private int x;
	private int y;
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() { //객체를 문자열로 반환
		return "Point("+x+","+y+")";
	}


}
public class ch06_01 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(3, 50);
		MyPoint q = new MyPoint(4, 50);
		System.out.println(p);
		if(p.equals(q))
			System.out.println("같은 점");
		else
			System.out.println("다른 점");
	}
}