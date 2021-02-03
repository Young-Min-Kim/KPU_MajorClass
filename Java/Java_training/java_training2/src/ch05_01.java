class TV {
    private int size;
    public TV(int size) {
        this.size = size;
    }
    protected int getSize() {
        return size;
    }
 }


 class ColorTV extends TV {
    public int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }

    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
 }


 class IPTV extends ColorTV {
    String address;

    public IPTV(String address, int size, int color) {
        super(size, color);
        this.address = address;
    }

    public void printProperty() {
        System.out.println("나의 IPTV는 " + address + " 주소의 " + getSize() + "인치 " + color + "컬러");
    }
 }
 public class ch05_01{
	    public static void main(String[] args) {
	        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
	        iptv.printProperty();
	    }
 }