import java.util.Scanner;

class Circle{
	private double x, y;
	private int radius;
	public Circle(double x, double y, int radius) { // x, y, radius 초기화
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public void show() {
		System.out.println("("+x+","+y+")"+radius);
	}
	public int getR() {
		return radius;
	}
}

public class ch04_06 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Circle c[] = new Circle[3]; // 3개의 Circle 배열 선언
		for(int i=0; i<c.length; i++) {
			System.out.print("x, y, radius >>");
			double x = scanner.nextDouble(); // x 값 읽기
		    double y = scanner.nextDouble(); // y 값 읽기
		    int radius = scanner.nextInt(); // 반지름 읽기
		    c[i] = new Circle(x, y, radius); // Circle 객체 생성
		}
		
		int tmp = 0;
		for(int i=1; i<c.length; i++)
		{
			if(c[tmp].getR() < c[i].getR())
				tmp = i;		
		}
		
		System.out.print("가장 면적이 큰 원은 ");
		c[tmp].show();
		scanner.close();
	}
}
