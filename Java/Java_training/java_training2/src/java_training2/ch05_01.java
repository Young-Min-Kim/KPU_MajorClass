package java_training2; //다른 패키지에 TV 클래스가 있어서 구별하기 위함 // 디폴트 패키지면 이게 없더라 이건 그냥 패키지 이름 따라가드라

class TV {
	private int size;
	public TV(int size) { this.size = size; }
	protected int getSize() { return size; }
}

class ColorTV extends TV {
	private int color;
	public ColorTV(int size, int color) {
		super(size); // 수퍼 클래스의 생성자 내용을 쓴다. this.size = size;
		this.color = color;
	}
	protected int getColor() { return color; }
	public void printProperty() {
		System.out.println(getSize()+"인치 "+getColor()+"컬러");
	}
}

public class ch05_01 {
	public static void main(String args[]) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}
}
