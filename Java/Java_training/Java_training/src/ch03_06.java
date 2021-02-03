import java.util.Scanner;

public class ch03_06 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액 입력>> ");
		int money = scanner.nextInt();
		
		int[] unit= {50000, 10000, 1000, 500, 100, 50, 10};
		
		for(int i = 0; i< unit.length; i++) {
			int n = money/unit[i];
			if(n!=0) {
				System.out.println(unit[i] + "원  "+ n + "개" );
			}
			money %= unit[i];
		}
	}
}
