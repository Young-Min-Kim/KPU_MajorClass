package java_training2;

class IPTV extends ColorTV {
	private String IP;
	public IPTV(String IP, int size, int color) {
		super(size, color);
		this.IP = IP;
	}
	protected String getIP() {
		return IP;
	}
	public void  printProperty() {
		System.out.print("나의 IPTV는 "+getIP()+" 주소의 ");
		super.printProperty();
	}
}



public class ch05_02 {
	public static void main(String args[]) {
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048); // "192.1.1.2" 주소에 32인치, 2048 컬러
		iptv.printProperty();
	}
}