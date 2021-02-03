import java.util.Scanner;

public class ch02_01 {
	
	public static void main(String[] args) {
		System.out.print("원화를 입력하세요(단위 원)>>");
		Scanner scanner = new Scanner(System.in);
		int won = scanner.nextInt();// nextInt -> 정수값 입력
		
		double dollar = won*0.00085; // 
		
		System.out.println(won + "원은 $ " + dollar + "입니다.");
		
		scanner.close();
	}

}
