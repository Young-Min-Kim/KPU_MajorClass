import base.Shape; // shape 클래스를 서야하기 때문에 이것도 임폴트
import derived.Circle;

public class ch06_04 {
	public static void main(String[] args) {
		Shape shape = new Circle();
		shape.draw();
	}
}