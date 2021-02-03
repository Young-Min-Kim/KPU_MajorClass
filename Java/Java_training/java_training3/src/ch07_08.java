import java.util.*;
class custormaerManager{
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private Scanner scanner = new Scanner(System.in);
	private String name;
	int point;
	public void run() {
		System.out.println("**포인트 관리 프로그램**");
		
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			
			try {
				name = scanner.next();
				point = scanner.nextInt();
				
			}catch(Exception e) {
				System.out.println("잘못 입력 하셨습니다.");
				e.printStackTrace();
				throw e;
			}

			
			
			Integer n = map.get(name);
			if(n != null) {
				point += n;
			}
			map.put(name, point);
			System.out.println("("+name+", "+point+")");
		}
	}
}
public class ch07_08 {

	public static void main(String[] args) {
		custormaerManager man = new custormaerManager();
		man.run();

	}
}