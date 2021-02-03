import java.util.Scanner;

class Person {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String turn() { // 턴이 돌아오면 Enter키 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("["+name+"]:");
		return sc.nextLine();
	}
	
	public boolean RandomNum() { // 랜덤숫자 3개 생성 후 일치하는지 확인
		int num[] = new int[3];
		
		for(int i=0; i<3; i++) {
			num[i] = (int)(Math.random()*3+1);
			System.out.print(num[i]+"\t"); // 랜덤 넘버 출력
		}
		
		boolean result = true;
		for(int i=0; i<3; i++) {
			if(num[0] != num[i]) {
				result = false; // 불일치
				break;
			}
		}
		return result;
	}
}

class GamblingGame {
	Person person[];
	Scanner sc = new Scanner(System.in);
	
	public GamblingGame() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("갬블링 게임에 참여할 선수 숫자>>");
		int num = sc.nextInt();
		
		person = new Person[num]; // 인원만큼 Person 생성
		
		for(int i=0; i<person.length; i++) {
			System.out.print((i+1) + "번째 선수 이름>>");
			person[i] = new Person(sc.next());
		}
	}
	
	public void Run() {
		while(true) {
			for(int i=0; i<person.length; i++) {
				String s = person[i].turn();
				if(s.equals("")) {
					System.out.println("<Enter>");
				}
				else {
					System.out.println("<Enter>키만 입력 가능합니다.");
					return;
				}
				
				// RandomNum()으로 랜덤 숫자가 서로 같은 지 비교 후
				if(person[i].RandomNum()) {
					System.out.println(person[i].getName() + "님이 이겼습니다!");
					return;
				}
				else
					System.out.println("아쉽군요!");
			}
		}
	}
}

public class ch06_10 {
	public static void main(String[] args) {
		GamblingGame game = new GamblingGame();
		game.Run();
	}
}

