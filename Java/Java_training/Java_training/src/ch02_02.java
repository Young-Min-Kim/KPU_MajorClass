import java.util.Scanner;

public class ch02_02 {
	
	public static void main(String args[]) {
		System.out.print("두 자리 정수를 입력 : ");
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		if(num /10 == num % 10)
			System.out.println("같습니다.");
		else
			System.out.println("다릅니다.");
			
		scanner.close();
	}

}
