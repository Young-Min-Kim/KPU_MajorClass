package etc; 
//디폴트  패키치는 위에같은거 안적어도 되는데 이건 적어줘야됨
public class Calc {
	private int x, y;
	public Calc(int x, int y) { this.x = x; this.y = y; }
	public int sum() { return x+y; }
}

