
class Song{
	private String title, artist, country;
    private int year;
    
    public Song(String title, String artist, int year, String country) {
    	this.title = title;
    	this.artist = artist;
    	this.year = year;
    	this.country = country;
    }
    
    public void show() {
    	System.out.println("노래 제목 : " + this.title);
        System.out.println("가수 : " + this.artist);
        System.out.println("연도 : " + this.year);
        System.out.println("나라 : " + this.country);
    	
    }
}

public class ch04_03 {
	public static void main(String[] args) {
	Song song = new Song("Dancing Queen", "ABBA", 1978, "스웨덴국적의");
	song.show();
	}
}