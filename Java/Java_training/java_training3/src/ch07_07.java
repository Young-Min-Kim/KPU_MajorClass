import java.util.*;

class Scholarship{
	private Scanner scanner = new Scanner(System.in);
	private HashMap<String, Double> scoreMap = new HashMap<String, Double>();
	
	public void read() {
		System.out.println("미래 장학금 관리 시스템입니다.");
		for(int i =0; i< 5; i++) {
			System.out.print("이름과 학점>> ");
			String name = scanner.next();
			double score = scanner.nextDouble();
			scoreMap.put(name, score);
		}
	}
	public void select() {
		System.out.print("장학생 선발 학점 기준 입력>> ");
		double cutline = scanner.nextDouble();
		
		System.out.println("장학생 명단: ");
		Set<String> nameSet = scoreMap.keySet();
		Iterator<String> it = nameSet.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Double value = scoreMap.get(name);
			if(value>cutline)
				System.out.println(name + " " + value + "장학생 합격");
			
		}
	}
	
}

public class ch07_07 {

	public static void main(String[] args) {
		Scholarship ship = new Scholarship();
		ship.read();
		ship.select();
	}

}
